package com.guimor.tennisumpire.ui.screen.players

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guimor.tennisumpire.domain.error.OperationResult

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayersScreen(
    onNavigateBack: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior,
    viewModel: PlayersViewModel = viewModel(factory = PlayersViewModel.Factory),
) {
    BackHandler { onNavigateBack() }
    val uiState by viewModel.uiState.collectAsState()
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        itemsIndexed(uiState.players) { index, player ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.surfaceContainerHighest)
            ) {
                Text(
                    text = player.firstName,
                    modifier = Modifier
                        .padding(20.dp)
                )
            }
        }
    }
}