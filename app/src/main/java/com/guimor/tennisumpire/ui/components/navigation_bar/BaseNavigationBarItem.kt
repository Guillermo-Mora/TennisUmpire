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
    currentRoute: NavKey,
    newRoute: NavKey,
    onClick: (newRoute: NavKey) -> Unit,
    updateScreenData: (currentRoute: NavKey, newRoute: NavKey) -> Unit,
    selected: (route: NavKey) -> Boolean,
    label: String,
    icon: ImageVector,
    iconSelected: ImageVector
) {
    val selected = selected(newRoute)
    NavigationBarItem(
        onClick = {
            onClick(newRoute)
            updateScreenData(currentRoute, newRoute)
        },
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

data class BaseNavigationBarItemData(
    val newRoute: NavKey,
    val label: String,
    val icon: ImageVector,
    val iconSelected: ImageVector
)