package com.guimor.tennisumpire.ui.screen.main.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface NavRoutesMain {
    @Serializable
    data object Matches :
        NavKey

    @Serializable
    data object Results :
        NavKey

    @Serializable
    data object Players :
        NavKey
}