package com.guimor.tennisumpire.ui.navigation
/*
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
/*
Extension functions and utilities for preventing accidental double navigations to occur when tapping
more than once (quickly) a navigation button that triggers a navigation action.
 */

private fun NavHostController.backStackEntryLifeCycleStateIsResumed() =
    this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED

private fun NavHostController.safe(
    navigationAction: () -> Unit
) {
    if (this.backStackEntryLifeCycleStateIsResumed()) navigationAction()
}

fun <T : NavRoutes> NavHostController.safeNavigate(
    route: T
) {
    safe { this.navigate(route) }
}

fun NavHostController.safePopBackStack() {
    safe { this.popBackStack() }
}

fun NavHostController.canNavigateBack(
    canNavigateBack: Boolean
): (() -> Unit)? {
    return if (canNavigateBack) {
        { this.safePopBackStack() }
    } else null
}

 */