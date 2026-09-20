package com.guimor.tennisumpire.ui.components.form

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import com.guimor.tennisumpire.take_photo.getImageUri
import com.guimor.tennisumpire.ui.icons.add_a_photoIcon
import com.guimor.tennisumpire.ui.icons.add_photo_alternateIcon
import com.guimor.tennisumpire.ui.icons.cancelIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPhotoAlertDialog(
    selectedPhoto: Uri?,
    setPhoto: (Uri?) -> Unit,
    buttonContent: @Composable (onOpenDialog: () -> Unit) -> Unit
) {
    val context = LocalContext.current
    var openDialog by rememberSaveable { mutableStateOf(false) }
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri -> if (uri != null) setPhoto(uri) }
    var cameraPhotoUri by rememberSaveable { mutableStateOf<Uri?>(null) }
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success ->
        if (success) cameraPhotoUri?.let { uri -> setPhoto(uri) }
    }
    buttonContent { openDialog = true }
    if (openDialog) {
        BasicAlertDialog(
            onDismissRequest = { openDialog = false },
        ) {
            Surface(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.large,
                tonalElevation = AlertDialogDefaults.TonalElevation,
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(
                        space = 16.dp,
                        alignment = Alignment.CenterVertically
                    )
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(
                            space = 8.dp,
                            alignment = Alignment.CenterVertically
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = add_photo_alternateIcon,
                            contentDescription = null,
                            modifier = Modifier
                                .size(26.dp)
                        )
                        Text(
                            text = "Add a photo",
                            fontSize = 22.sp
                        )
                    }
                    Column {
                        TextButton(
                            onClick = {
                                photoPickerLauncher.launch(
                                    input = PickVisualMediaRequest(
                                        mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                                    )
                                )
                                openDialog = false
                            }
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = add_photo_alternateIcon,
                                    contentDescription = null
                                )
                                Text("Select from gallery")
                            }
                        }
                        TextButton(
                            onClick = {
                                cameraPhotoUri = getImageUri(context = context)
                                cameraPhotoUri?.let { cameraLauncher.launch(input = it) }
                                println("THIS DEVICE HAS NO CAMERA")
                            }
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = add_a_photoIcon,
                                    contentDescription = null
                                )
                                Text("Take a photo")
                            }
                        }
                        TextButton(
                            onClick = {
                                setPhoto(null)
                                openDialog = false
                            },
                            enabled = selectedPhoto != null
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = cancelIcon,
                                    contentDescription = null
                                )
                                Text("Remove current photo")
                            }
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        TextButton(
                            onClick = { openDialog = false }
                        ) {
                            Text("Cancel")
                        }
                    }
                }
            }
        }
    }
}