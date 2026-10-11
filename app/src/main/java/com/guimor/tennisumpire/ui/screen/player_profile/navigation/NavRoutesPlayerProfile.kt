package com.guimor.tennisumpire.ui.screen.player_profile.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface NavRoutesPlayerProfile {
    @Serializable
    data object Details
        : NavKey

    @Serializable
    data object Matches
        : NavKey

    @Serializable
    data object Statistics
        : NavKey
}