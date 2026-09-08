package com.guimor.tennisumpire.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class NavRoutesRoot {
    @Serializable
    data object OnBoarding : NavKey

    @Serializable
    data object Main : NavKey

    @Serializable
    data object Settings : NavKey

    @Serializable
    data object NewMatch : NavKey

    @Serializable
    data object NewResult : NavKey

    @Serializable
    data object NewPlayer : NavKey

    @Serializable
    data class Results(
        val canNavigateBack: Boolean = false
    ) : NavKey
}