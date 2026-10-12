package com.guimor.tennisumpire.ui.screen.main

import com.guimor.tennisumpire.ui.screen.main.navigation.NavRoutesMain
import com.guimor.tennisumpire.ui_state.BaseUiState

data class MainUiState(
    val mainScreenData: MainScreenData = NavRoutesMain.Matches.getCurrentScreenData()
) : BaseUiState()