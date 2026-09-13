package com.guimor.tennisumpire.ui.components.top_bar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.guimor.tennisumpire.ui.icons.arrow_backIcon

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
        ),
        modifier = Modifier.padding(start = 16.dp)
    ) {
        Icon(
            imageVector = arrow_backIcon,
            contentDescription = "Navigate back"
        )
    }
}