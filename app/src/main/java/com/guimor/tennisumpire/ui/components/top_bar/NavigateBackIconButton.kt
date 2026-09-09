package com.guimor.tennisumpire.ui.components.top_bar

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.guimor.tennisumpire.icons.arrow_backIcon

@Composable
fun NavigateBackIconButton(
    onNavigateBack: () -> Unit
) {
    IconButton(
        onClick = { onNavigateBack() },
        colors = IconButtonColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = IconButtonDefaults.iconButtonColors().contentColor,
            disabledContainerColor = IconButtonDefaults.iconButtonColors().disabledContainerColor,
            disabledContentColor = IconButtonDefaults.iconButtonColors().disabledContentColor
        )
    ) {
        Icon(
            imageVector = arrow_backIcon,
            contentDescription = "Navigate back"
        )
    }
}