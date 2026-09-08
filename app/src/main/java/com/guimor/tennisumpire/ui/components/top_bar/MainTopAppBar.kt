package com.guimor.tennisumpire.ui.components.top_bar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.guimor.tennisumpire.icons.settingsIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(
    title: String,
    onNavigateToSettings: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        actions = {
            IconButton(
                onClick = { onNavigateToSettings() }
            ) {
                Icon(
                    imageVector = settingsIcon,
                    contentDescription = "Settings",
                )
            }
        },
        modifier = Modifier
            .padding(horizontal = 16.dp),
    )
}