package com.guimor.tennisumpire.ui.screen.main.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
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

    @Composable
    fun <T : NavKey> GetNavDisplay(
        entries: List<NavEntry<T>>,
        onBack: () -> Unit
    ) = NavDisplay(
        entries = entries,
        onBack = { onBack() },
        transitionSpec = {
            slideInHorizontally { it } + fadeIn() togetherWith
                    slideOutHorizontally { -it } + fadeOut()
        },
        popTransitionSpec = {
            slideInHorizontally { -it } + fadeIn() togetherWith
                    slideOutHorizontally { it } + fadeOut()
        },
        predictivePopTransitionSpec = {
            slideInHorizontally { -it } + fadeIn() togetherWith
                    slideOutHorizontally { it } + fadeOut()
        },
    )
}

@Composable
fun NavKey.getTitle(): String = when (this) {
    NavRoutesMain.Matches -> "Matches"
    NavRoutesMain.Results -> "Results"
    NavRoutesMain.Players -> "Players"
    else -> ""
}