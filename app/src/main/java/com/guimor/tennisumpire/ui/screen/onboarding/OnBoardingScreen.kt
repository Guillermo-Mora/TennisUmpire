package com.guimor.tennisumpire.ui.screen.onboarding

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guimor.tennisumpire.dataStore
import com.guimor.tennisumpire.preferences_data_store.SettingsViewModel
import com.guimor.tennisumpire.preferences_data_store.UserPreferencesRepository
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel = viewModel { OnBoardingViewModel() },
    settingsViewModel: SettingsViewModel = viewModel(factory = SettingsViewModel.Factory),
    onNavigateToMainScreen: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    if (uiState.pagerState.currentPage >= 1) {
        BackHandler {
            scope.launch {
                uiState.pagerState.animateScrollToPage(uiState.pagerState.currentPage - 1)
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold { paddingValues ->
            HorizontalPager(
                state = uiState.pagerState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
            ) { page ->
                val nextPage = page + 1
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(
                        space = 16.dp,
                        alignment = Alignment.CenterVertically
                    ),
                ) {
                    when (page) {
                        0 -> OnBoardingScreen1(
                            onNextPage = {
                                scope.launch {
                                    uiState.pagerState.animateScrollToPage(nextPage)
                                }
                            },
                        )

                        1 -> OnBoardingScreen2(
                            onNextPage = {
                                scope.launch {
                                    uiState.pagerState.animateScrollToPage(nextPage)
                                }
                            },
                        )

                        else -> OnBoardingScreen3(
                            onNextPage = {
                                onNavigateToMainScreen()
                                settingsViewModel.finishOnBoarding()
                            }
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .padding()
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 26.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(uiState.pagerState.pageCount) {
                val color =
                    if (uiState.pagerState.currentPage == it) colorScheme.primary
                    else colorScheme.surfaceContainerHighest
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(10.dp)
                        .clickable(
                            onClick = {
                                scope.launch { uiState.pagerState.animateScrollToPage(it) }
                            }
                        )
                )
            }
        }
    }
}

@Preview
@Composable
    fun Preview() {
    OnBoardingScreen(
        onNavigateToMainScreen = {}
    )
}