package com.guimor.tennisumpire.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.navigation3.runtime.NavKey
import com.guimor.tennisumpire.domain.error.OperationResult
import com.guimor.tennisumpire.view_model.UiStateHolder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel(
    override val _uiState: MutableStateFlow<MainUiState> = MutableStateFlow(MainUiState()),
    override val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()
) : ViewModel(),
    UiStateHolder<MainUiState> {
    fun changeMainScreen(
        currentMainScreen: NavKey,
        newMainScreen: NavKey
    ) {
        if (newMainScreen != currentMainScreen)
            _uiState.update {
                it.copy(
                    mainScreenData = newMainScreen.getCurrentScreenData()
                )
            }
    }

    fun changeMainScreen(
        newMainScreen: NavKey?
    ) {
        newMainScreen?.let {
            _uiState.update {
                it.copy(
                    mainScreenData = newMainScreen.getCurrentScreenData()
                )
            }
        }
    }
}