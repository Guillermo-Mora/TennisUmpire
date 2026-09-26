package com.guimor.tennisumpire.file_manager

import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import androidx.core.content.FileProvider
import androidx.core.net.toFile
import com.guimor.tennisumpire.domain.error.FileManagerError
import com.guimor.tennisumpire.domain.error.OperationResult
import com.guimor.tennisumpire.domain.model.StoredIn
import java.io.File
import java.io.FileNotFoundException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AppFileManager(
    private val context: Context
) {
    fun createTempFileAndGetUri(
        storedIn: StoredIn
    ): OperationResult<Uri> {
        val storageDir = getStorageDir(storedIn).let {
            when (it) {
                is OperationResult.ErrorResult -> return it
                is OperationResult.SuccessResult -> it.value
            }
        }
        val file = File.createTempFile(
            "JPEG_${getCurrentTimeStamp()}_",
            ".jpg",
            storageDir
        )
        val uri = try {
            FileProvider.getUriForFile(
                context,
                "${context.packageName}.fileprovider",
                file
            )
        } catch (_: IllegalArgumentException) {
            return OperationResult.ErrorResult(FileManagerError.FILE_DOESNT_EXISTS)
        }
        return OperationResult.SuccessResult(uri)
    }

    fun createTempFileAndGetUri(
        storedIn: StoredIn,
        originalFileUri: Uri
    ): OperationResult<Uri> {
        val storageDir = getStorageDir(storedIn).let {
            when (it) {
                is OperationResult.ErrorResult -> return it
                is OperationResult.SuccessResult -> it.value
            }
        }
        val file =
            File(
                storageDir,
                "JPEG_${getCurrentTimeStamp()}_.jpg"
            )
        val input = try {
            context.contentResolver.openInputStream(originalFileUri)
        } catch (_: FileNotFoundException) {
            return OperationResult.ErrorResult(FileManagerError.FILE_DOESNT_EXISTS)
        }
        input.use { inputStream ->
            file.outputStream().use { outputStream ->
                inputStream?.copyTo(outputStream) ?: return OperationResult.ErrorResult(
                    FileManagerError.FILE_DOESNT_EXISTS
                )
            }
        }
        val uri = try {
            FileProvider.getUriForFile(
                context,
                "${context.packageName}.fileprovider",
                file
            )
        } catch (_: IllegalArgumentException) {
            return OperationResult.ErrorResult(FileManagerError.FILE_DOESNT_EXISTS)
        }
        return OperationResult.SuccessResult(uri)
    }

    fun persistFileAndGetUri(
        storedIn: StoredIn,
        tempFileUri: Uri
    ): OperationResult<Uri> {
        val storageDir = getStorageDir(storedIn).let {
            when (it) {
                is OperationResult.ErrorResult -> return it
                is OperationResult.SuccessResult -> it.value
            }
        }
        val file =
            File(
                storageDir,
                "JPEG_${getCurrentTimeStamp()}_.jpg"
            )
        val input = try {
            context.contentResolver.openInputStream(tempFileUri)
        } catch (_: FileNotFoundException) {
            return OperationResult.ErrorResult(FileManagerError.FILE_DOESNT_EXISTS)
        }
        input.use { inputStream ->
            file.outputStream().use { outputStream ->
                inputStream?.copyTo(outputStream) ?: return OperationResult.ErrorResult(
                    FileManagerError.FILE_DOESNT_EXISTS
                )
            }
        }
        val uri = try {
            FileProvider.getUriForFile(
                context,
                "${context.packageName}.fileprovider",
                file
            )
        } catch (_: IllegalArgumentException) {
            return OperationResult.ErrorResult(FileManagerError.FILE_DOESNT_EXISTS)
        }
        return OperationResult.SuccessResult(uri)
    }

    fun deleteFileIfExists(
        uri: Uri
    ) {
        context.contentResolver.delete(uri, null, null)
    }

    private fun getCurrentTimeStamp() =
        SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())

    private fun getStorageDir(
        storedIn: StoredIn
    ): OperationResult<File> {
        val file = File(
            when (storedIn) {
                StoredIn.PLAYER_PHOTOS -> context.filesDir
                StoredIn.CAMERA_CACHE -> context.cacheDir
            },
            storedIn.pathName
        ).also {
            if (!it.exists())
                if (!it.mkdirs()) return OperationResult.ErrorResult(FileManagerError.CANT_CREATE_FILE_DIRECTORY)
        }
        return OperationResult.SuccessResult(file)
    }

    fun deviceHasCamera() =
        (context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY))
}