package com.guimor.tennisumpire.ui.components.top_bar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.guimor.tennisumpire.ui.icons.settingsIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(
    title: String,
    onNavigateToSettings: () -> Unit,
    navigationIcon: @Composable (() -> Unit)? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = { Text(title) },
        navigationIcon = {
            navigationIcon?.invoke()
        },
        actions = {
            IconButton(
                onClick = { onNavigateToSettings() }
            ) {
                Icon(
                    imageVector = settingsIcon,
                    contentDescription = "Settings",
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
        },
    )
}