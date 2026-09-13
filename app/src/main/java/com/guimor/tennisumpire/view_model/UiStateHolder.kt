package com.guimor.tennisumpire.view_model

import com.guimor.tennisumpire.ui_state.BaseUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface UiStateHolder<T : BaseUiState> {
    val _uiState : MutableStateFlow<T>
    val uiState: StateFlow<T>
}