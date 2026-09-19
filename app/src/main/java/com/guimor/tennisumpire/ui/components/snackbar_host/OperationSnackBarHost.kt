package com.guimor.tennisumpire.ui.components.snackbar_host

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.guimor.tennisumpire.domain.error.OperationResult
import com.guimor.tennisumpire.ui.icons.check_circleIcon
import com.guimor.tennisumpire.ui.icons.closeIcon
import com.guimor.tennisumpire.ui.icons.errorIcon

@Composable
fun OperationSnackBarHost(
    snackBarHostState: SnackbarHostState
) {
    SnackbarHost(
        hostState = snackBarHostState,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .shadow(elevation = 5.dp, shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.onBackground)
    ) { snackBarData ->
        val visuals = snackBarData.visuals as OperationSnackbarVisuals
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector =
                        if (visuals.operationResult is OperationResult.Error) errorIcon
                        else check_circleIcon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.background
                )
                Text(
                    text = stringResource(visuals.operationResult.messageId),
                    color = MaterialTheme.colorScheme.background
                )
            }
            IconButton(
                onClick = { snackBarHostState.currentSnackbarData?.dismiss() }
            ) {
                Icon(
                    imageVector = closeIcon,
                    contentDescription = "Close message",
                    tint = MaterialTheme.colorScheme.background
                )
            }
        }
    }
}

data class OperationSnackbarVisuals (
    val operationResult: OperationResult,
    override val duration: SnackbarDuration,
    override val actionLabel: String? = null,
    override val message: String = "",
    override val withDismissAction: Boolean = false
) : SnackbarVisuals