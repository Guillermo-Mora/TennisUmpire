package com.guimor.tennisumpire.ui.screen.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import com.guimor.tennisumpire.ui.navigation.rememberNavigationState


object NavigationMain {
    //Top level routes are the main tree routes. For example x match detail screen, is not
    // a top level route. These 3 are, ase they come from the main tree.
    val topLevelRoutes = setOf(
        NavRoutesMain.Matches,
        NavRoutesMain.Results,
        NavRoutesMain.Players
    )

    @Composable
    fun getRememberNavigationState() = rememberNavigationState(
        startRoute = NavRoutesMain.Matches,
        topLevelRoutes = topLevelRoutes
    )
}

@Composable
fun NavKey.getTitle(): String = when (this) {
    NavRoutesMain.Matches -> "Matches"
    NavRoutesMain.Results -> "Results"
    NavRoutesMain.Players -> "Players"
    else -> ""
}