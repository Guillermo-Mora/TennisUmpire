package com.guimor.tennisumpire.ui.screen.main

import androidx.lifecycle.ViewModel
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
    fun test(str: String) {
        _uiState.update {
            it.copy(
                test = str
            )
        }
    }
}