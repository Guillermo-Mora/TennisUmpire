package com.guimor.tennisumpire.ui.screen.main.navigation_bar_screens.players

import com.guimor.tennisumpire.domain.operation_result.result_type.ResultType
import com.guimor.tennisumpire.ui_state.BaseUiState

data class PlayersUiState(
    val messageResult: ResultType? = null
) : BaseUiState()