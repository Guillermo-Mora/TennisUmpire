package com.guimor.tennisumpire.ui.components.player

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guimor.tennisumpire.domain.model.player.PlayerBackhand
import com.guimor.tennisumpire.domain.model.player.PlayerDominantHand
import com.guimor.tennisumpire.domain.model.player.PlayerGender
import com.guimor.tennisumpire.room_database.player.Player
import com.guimor.tennisumpire.ui.icons.article_personIcon
import com.guimor.tennisumpire.ui.icons.delete_foreverIcon
import com.guimor.tennisumpire.ui.icons.editIcon
import com.guimor.tennisumpire.ui.icons.warningIcon
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardBottomSheet(
    registryName: String,
    onClickDelete: () -> Unit,
    onClickEdit: () -> Unit,
    detailsSection: DetailsSection? = null,
    content: @Composable () -> Unit,
    button: @Composable (onOpenBottomSheet: () -> Unit) -> Unit,
) {
    val sheetState = rememberModalBottomSheetState()
    var showDeleteAlertDialog by rememberSaveable { mutableStateOf(false) }
    var showBottomSheet by rememberSaveable { mutableStateOf(false) }
    button { showBottomSheet = true }
    if (showBottomSheet) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { showBottomSheet = false }
        ) {
            content()
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surfaceContainer,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 8.dp,
                        alignment = Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    CardBottomSheetButton(
                        onClick = { showDeleteAlertDialog = true },
                        icon = delete_foreverIcon,
                        text = "Delete",
                        alertContentColor = true,
                        modifier = Modifier
                            .weight(1f)
                    )
                    detailsSection?.let {
                        CardBottomSheetButton(
                            onClick = {
                                it.onClickDetails()
                                showBottomSheet = false
                            },
                            icon = it.icon,
                            text = it.text,
                            modifier = Modifier
                                .weight(1f)
                        )
                    }
                    /*
                    CardBottomSheetButton(
                        onClick = {
                            onClickDetails()
                            showBottomSheet = false
                        },
                        icon = article_personIcon,
                        text = "Profile",
                        modifier = Modifier
                            .weight(1f)
                    )
                     */
                    CardBottomSheetButton(
                        onClick = {
                            onClickEdit()
                            showBottomSheet = false
                        },
                        icon = editIcon,
                        text = "Edit",
                        modifier = Modifier
                            .weight(1f)
                    )
                }
            }
        }
        if (showDeleteAlertDialog) {
            DeleteAlertDialog(
                onDismissRequest = { showDeleteAlertDialog = false },
                registryName = registryName,
                onClickDeletePlayer = {
                    onClickDelete()
                    showBottomSheet = false
                }
            )
        }
    }
}

@Composable
private fun CardBottomSheetButton(
    icon: ImageVector,
    text: String,
    modifier: Modifier,
    onClick: () -> Unit,
    alertContentColor: Boolean = false
) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
            contentColor =
                if (alertContentColor) MaterialTheme.colorScheme.error
                else MaterialTheme.colorScheme.onSurface,
            disabledContainerColor = ButtonDefaults.buttonColors().disabledContainerColor,
            disabledContentColor = ButtonDefaults.buttonColors().disabledContentColor
        ),
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                space = 2.dp,
                alignment = Alignment.CenterVertically
            )
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null
            )
            Text(
                text = text,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontSize = 12.sp
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DeleteAlertDialog(
    onDismissRequest: () -> Unit,
    registryName: String,
    onClickDeletePlayer: () -> Unit
) {
    BasicAlertDialog(
        onDismissRequest = { onDismissRequest() }
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
                        imageVector = warningIcon,
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                    )
                    Text(
                        text = "Permanently delete ",
                        fontSize = 22.sp
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = registryName,
                            fontSize = 22.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(
                                weight = 1f,
                                fill = false
                            )
                        )
                        Text(
                            text = "?",
                            fontSize = 22.sp
                        )
                    }
                    Text(
                        "If you press delete, it will be permanently deleted"
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {}
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 16.dp,
                        alignment = Alignment.End
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    OutlinedButton(
                        onClick = {
                            onDismissRequest()
                        },
                    ) {
                        Text("Cancel")
                    }
                    OutlinedButton(
                        onClick = {
                            onClickDeletePlayer()
                            onDismissRequest()
                        },
                        border = BorderStroke(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.error
                        ),
                        colors = ButtonColors(
                            containerColor = ButtonDefaults.outlinedButtonColors().containerColor,
                            contentColor = MaterialTheme.colorScheme.error,
                            disabledContainerColor = ButtonDefaults.outlinedButtonColors().disabledContainerColor,
                            disabledContentColor = ButtonDefaults.outlinedButtonColors().disabledContentColor
                        )
                    ) {
                        Text("Delete")
                    }
                }
            }
        }
    }
}

data class DetailsSection(
    val text: String,
    val icon: ImageVector,
    val onClickDetails: () -> Unit
)

@Composable
@Preview
fun CardBottomSheetPreview() {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            CardBottomSheet(
                registryName = "Guillermo Mora",
                onClickDelete = {},
                onClickEdit = {},
                content = {
                    PlayerListCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(MaterialTheme.colorScheme.surfaceContainerHigh),
                        player = Player(
                            uid = 0,
                            firstName = "Guillermo",
                            lastName = "Mora",
                            birthdate = LocalDate.of(2025, 10, 27),
                            height = 183f,
                            weight = 68f,
                            country = null,
                            gender = PlayerGender.MALE,
                            dominantHand = PlayerDominantHand.LEFT,
                            backhand = PlayerBackhand.ONE_HANDED,
                            photo = null
                        ),
                        interactiveMode = false,
                        onClickToggleAddPlayerToFavourites = { }
                    )
                },
            ) {

            }
        }
    }
}