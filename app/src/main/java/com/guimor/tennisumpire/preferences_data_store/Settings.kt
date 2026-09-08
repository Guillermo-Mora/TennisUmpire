package com.guimor.tennisumpire.preferences_data_store

sealed class Settings {
        data class LoadedSettings(
                val isOnBoardingFinished: Boolean = false
        ) : Settings()

        object LoadingSettings : Settings()
}