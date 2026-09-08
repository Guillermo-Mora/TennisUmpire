package com.guimor.tennisumpire.ui.screen.onboarding

import androidx.compose.foundation.pager.PagerState
import com.guimor.tennisumpire.ui_state.BaseUiState

data class OnBoardingUiState(
    val pagerState: PagerState = PagerState(pageCount = { 3 })
) : BaseUiState()