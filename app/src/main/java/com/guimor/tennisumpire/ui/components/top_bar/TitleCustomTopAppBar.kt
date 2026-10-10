package com.guimor.tennisumpire.ui.components.top_bar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.guimor.tennisumpire.ui.icons.settingsIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleCustomTopAppBar(
    modifier: Modifier = Modifier,
    titleContent: @Composable () -> Unit,
    onNavigateToSettings: (() -> Unit)? = null,
    navigationIcon: @Composable (() -> Unit)? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    colors: TopAppBarColors? = null
) {
    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = { titleContent() },
        navigationIcon = {
            navigationIcon?.invoke()
        },
        actions = {
            onNavigateToSettings?.let { onNavigateToSettings ->
                IconButton(
                    onClick = { onNavigateToSettings() }
                ) {
                    Icon(
                        imageVector = settingsIcon,
                        contentDescription = "Settings",
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
            }
        },
        colors = colors ?: TopAppBarDefaults.topAppBarColors(),
        modifier = modifier
    )
}