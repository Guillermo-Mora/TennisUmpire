package com.guimor.tennisumpire.ui.screen.rules

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RulesScreen(
    onNavigateBack: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior
) {
    BackHandler { onNavigateBack() }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        //
    }
}