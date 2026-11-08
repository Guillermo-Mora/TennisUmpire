package com.guimor.tennisumpire.file_manager

import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import androidx.core.content.FileProvider
import com.guimor.tennisumpire.domain.operation_result.result_type.FileManagerError
import com.guimor.tennisumpire.domain.operation_result.OperationResult
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
                is OperationResult.ErrorOperation -> return it
                is OperationResult.SuccessOperation -> it.value
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
            return OperationResult.ErrorOperation(FileManagerError.FILE_DOESNT_EXISTS)
        }
        return OperationResult.SuccessOperation(uri)
    }

    fun createTempFileAndGetUri(
        storedIn: StoredIn,
        originalFileUri: Uri
    ): OperationResult<Uri> {
        val storageDir = getStorageDir(storedIn).let {
            when (it) {
                is OperationResult.ErrorOperation -> return it
                is OperationResult.SuccessOperation -> it.value
            }
        }
        val file =
            File(
                storageDir,
                "${getCurrentTimeStamp()}.jpg"
            )
        val input = try {
            context.contentResolver.openInputStream(originalFileUri)
        } catch (_: FileNotFoundException) {
            return OperationResult.ErrorOperation(FileManagerError.FILE_DOESNT_EXISTS)
        }
        input.use { inputStream ->
            file.outputStream().use { outputStream ->
                inputStream?.copyTo(outputStream) ?: return OperationResult.ErrorOperation(
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
            return OperationResult.ErrorOperation(FileManagerError.FILE_DOESNT_EXISTS)
        }
        return OperationResult.SuccessOperation(uri)
    }

    fun persistFileAndGetUri(
        storedIn: StoredIn,
        tempFileUri: Uri
    ): OperationResult<Uri> {
        val storageDir = getStorageDir(storedIn).let {
            when (it) {
                is OperationResult.ErrorOperation -> return it
                is OperationResult.SuccessOperation -> it.value
            }
        }
        val file =
            File(
                storageDir,
                "${getCurrentTimeStamp()}.jpg"
            )
        val input = try {
            context.contentResolver.openInputStream(tempFileUri)
        } catch (_: FileNotFoundException) {
            return OperationResult.ErrorOperation(FileManagerError.FILE_DOESNT_EXISTS)
        }
        input.use { inputStream ->
            file.outputStream().use { outputStream ->
                inputStream?.copyTo(outputStream) ?: return OperationResult.ErrorOperation(
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
            return OperationResult.ErrorOperation(FileManagerError.FILE_DOESNT_EXISTS)
        }
        return OperationResult.SuccessOperation(uri)
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
                if (!it.mkdirs()) return OperationResult.ErrorOperation(FileManagerError.CANT_CREATE_DIRECTORY)
        }
        return OperationResult.SuccessOperation(file)
    }

    fun deviceHasCamera() =
        (context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY))
}