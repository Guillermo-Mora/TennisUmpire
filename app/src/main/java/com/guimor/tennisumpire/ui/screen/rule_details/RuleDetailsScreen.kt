package com.guimor.tennisumpire.ui.screen.rule_details

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.guimor.tennisumpire.domain.ui_messages.ResultWithUiText
import com.guimor.tennisumpire.ui.components.rule.RuleDetailsCard
import com.guimor.tennisumpire.ui.components.rule.RuleTitleCard
import com.guimor.tennisumpire.ui.components.top_bar.NavigateBackIconButton
import com.guimor.tennisumpire.ui.components.top_bar.TitleCustomTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RuleDetailsScreen(
    onNavigateBack: () -> Unit,
    ruleDetailsViewModel: RuleDetailsViewModel,
    onOperationSuccess: (resultWithUiText: ResultWithUiText) -> Unit,
) {
    BackHandler { onNavigateBack() }
    val uiState by ruleDetailsViewModel.uiState.collectAsState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        topBar = {
            TitleCustomTopAppBar(
                titleContent = {
                    RuleTitleCard(
                        ruleName = uiState.rule?.name,
                        onClickToggleAddRuleToFavourites = { ruleDetailsViewModel.toggleAddRuleToFavourites() },
                        isFavourite = uiState.rule?.favourite
                    )
                },
                navigationIcon = { NavigateBackIconButton { onNavigateBack() } },
                scrollBehavior = scrollBehavior,
            )
        },
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .widthIn(max = 560.dp)
                    .fillMaxWidth(),
            ) {
                RuleDetailsCard(
                    rule = uiState.rule
                )
            }
        }
    }
}