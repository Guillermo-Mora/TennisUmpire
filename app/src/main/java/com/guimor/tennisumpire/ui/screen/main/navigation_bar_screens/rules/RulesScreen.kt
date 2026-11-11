package com.guimor.tennisumpire.ui.screen.main.navigation_bar_screens.rules

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.guimor.tennisumpire.R
import com.guimor.tennisumpire.domain.ui_messages.ResultWithUiText
import com.guimor.tennisumpire.domain.ui_messages.toResultWithUiText
import com.guimor.tennisumpire.ui.components.rule.RuleListCard
import com.guimor.tennisumpire.ui.components.spacer.LastRegistrySpacer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RulesScreen(
    onNavigateBack: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior,
    onOperationResult: (resultWithUiText: ResultWithUiText) -> Unit,
    onNavigateToEditRule: (playerUid: Int) -> Unit,
    onNavigateToRuleDetails: (playerUid: Int) -> Unit,
    viewModel: RulesViewModel,
) {
    BackHandler { onNavigateBack() }
    val uiState by viewModel.uiState.collectAsState()
    LaunchedEffect(uiState.messageResult) {
        uiState.messageResult?.let { messageResult ->
            onOperationResult(
                messageResult.toResultWithUiText(
                    R.string.rule,
                    uiState.ruleName
                )
            )
            viewModel.resetMessageResult()
        }
    }
    val rules = viewModel.rules.collectAsLazyPagingItems()
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        items(
            count = rules.itemCount,
            key = rules.itemKey { it.uid }
        ) { index ->
            val rule = rules[index]
            rule?.let { rule ->
                RuleListCard(
                    rule = rule,
                    onClickToggleAddRuleToFavourites = {
                        viewModel.toggleAddRuleToFavourites(rule.uid)
                    },
                    onClickRuleDetails = { onNavigateToRuleDetails(rule.uid) },
                    onClickDeleteRule = { viewModel.deleteRule(rule.uid) },
                    onClickEditRule = { onNavigateToEditRule(rule.uid) }
                )
                //Spacer so on the last registry you can access the actions button. Because
                // the floating action button can cover it otherwise.
                if (index == rules.itemCount - 1) {
                    LastRegistrySpacer()
                }
            }
        }
    }
}