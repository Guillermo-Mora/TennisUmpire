package com.guimor.tennisumpire.ui.components.navigation_bar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavKey

@Composable
fun RowScope.BaseNavigationBarItem(
    route: NavKey,
    onClick: (route: NavKey) -> Unit,
    selected: (route: NavKey) -> Boolean,
    label: String,
    icon: ImageVector,
    iconSelected: ImageVector,
) {
    val selected = selected(route)
    NavigationBarItem(
        onClick = { onClick(route) },
        icon = {
            Icon(
                imageVector = if (selected) iconSelected else icon,
                contentDescription = label
            )
        },
        label = { Text(label) },
        selected = selected,
    )
}