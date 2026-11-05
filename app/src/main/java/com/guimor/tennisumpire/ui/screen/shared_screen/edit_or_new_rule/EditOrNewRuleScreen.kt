package com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_rule

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guimor.tennisumpire.R
import com.guimor.tennisumpire.domain.model.rule.RuleOnGameDeuce
import com.guimor.tennisumpire.domain.model.rule.RuleSetDecider
import com.guimor.tennisumpire.domain.model.rule.RuleSetType
import com.guimor.tennisumpire.domain.model.rule.RuleSetsQuantityType
import com.guimor.tennisumpire.domain.model.rule.RuleSetsQuantityType.BEST_OF
import com.guimor.tennisumpire.domain.model.rule.RuleSetsQuantityType.FIXED_QUANTITY
import com.guimor.tennisumpire.domain.model.rule.RuleTiebreakDecider
import com.guimor.tennisumpire.domain.operation_result.result_type.SuccessResult
import com.guimor.tennisumpire.domain.ui_messages.ResultWithUiText
import com.guimor.tennisumpire.domain.ui_messages.toResultWithUiText
import com.guimor.tennisumpire.room_database.rule.FakeRuleRepository
import com.guimor.tennisumpire.ui.components.form.FormInformativeText
import com.guimor.tennisumpire.ui.components.form.FormNumberPicker
import com.guimor.tennisumpire.ui.components.form.FormSingleChoiceSegmentedButtonRow
import com.guimor.tennisumpire.ui.components.form.FormSwitch
import com.guimor.tennisumpire.ui.components.form.FormTextField
import com.guimor.tennisumpire.ui.components.snackbar_host.OperationSnackBarHost
import com.guimor.tennisumpire.ui.components.snackbar_host.OperationSnackbarVisuals
import com.guimor.tennisumpire.ui.components.spacer.BigSpacer
import com.guimor.tennisumpire.ui.components.spacer.DefaultSpacer
import com.guimor.tennisumpire.ui.components.top_bar.MainTopAppBar
import com.guimor.tennisumpire.ui.components.top_bar.NavigateBackIconButton
import com.guimor.tennisumpire.ui.icons.assignmentIcon
import com.guimor.tennisumpire.ui.model.SegmentedButtonOption

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditOrNewRuleScreen(
    onNavigateBack: () -> Unit,
    editOrNewRuleViewModel: EditOrNewRuleViewModel,
    onOperationSuccess: (resultWithUiText: ResultWithUiText) -> Unit,
    title: String,
    buttonText: String,
) {
    BackHandler {
        onNavigateBack()
    }
    val uiState by editOrNewRuleViewModel.uiState.collectAsState()
    val lazyListState = rememberLazyListState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val snackBarHostState = remember { SnackbarHostState() }
    LaunchedEffect(uiState.operationResult) {
        uiState.operationResult?.let { operationResult ->
            if (operationResult is SuccessResult) {
                onOperationSuccess(
                    operationResult.toResultWithUiText(
                        R.string.rule,
                        uiState.ruleName.value
                    )
                )
                onNavigateBack()
            } else {
                snackBarHostState.showSnackbar(
                    visuals = OperationSnackbarVisuals(
                        resultWithUiText = operationResult.toResultWithUiText(
                            R.string.rule,
                            uiState.ruleName.value
                        ),
                        duration = SnackbarDuration.Short,
                    ),
                )
                editOrNewRuleViewModel.resetOperationResult()
            }
        }
    }
    LaunchedEffect(uiState.scrollToErrorSection) {
        if (uiState.scrollToErrorSection != -1) {
            try {
                lazyListState.animateScrollToItem(
                    index = uiState.scrollToErrorSection,
                    scrollOffset = -50
                )
            } finally {
                editOrNewRuleViewModel.resetScrollToError()
            }
        }
    }
    val ruleSetsQuantityTypeOptions = listOf(
        SegmentedButtonOption(
            label = stringResource(R.string.best_of),
            value = BEST_OF
        ),
        SegmentedButtonOption(
            label = stringResource(R.string.fixed_quantity),
            value = FIXED_QUANTITY
        ),
    )
    val ruleGlobalSetTypeOptions = listOf(
        SegmentedButtonOption(
            label = stringResource(R.string.games),
            value = RuleSetType.GAMES
        ),
        SegmentedButtonOption(
            label = stringResource(R.string.tiebreak),
            value = RuleSetType.TIEBREAK
        ),
    )
    val ruleGlobalOnGameDeuceOptions = listOf(
        SegmentedButtonOption(
            label = stringResource(R.string.advantage),
            value = RuleOnGameDeuce.ADVANTAGE
        ),
        SegmentedButtonOption(
            label = stringResource(R.string.golden_point),
            value = RuleOnGameDeuce.GOLDEN_POINT
        ),
        SegmentedButtonOption(
            label = stringResource(R.string.star_point),
            value = RuleOnGameDeuce.STAR_POINT
        ),
    )
    val ruleGlobalTiebreakStartsOnOptions = listOf(
        SegmentedButtonOption(
            label = "Tiebreak",
            value = RuleSetDecider.TIEBREAK
        ),
        SegmentedButtonOption(
            label = "2 games difference",
            value = RuleSetDecider.TWO_GAMES_DIFFERENCE
        ),
    )
    val ruleGlobalTiebreakDeciderOptions = listOf(
        SegmentedButtonOption(
            label = "Two points difference",
            value = RuleTiebreakDecider.TWO_POINTS_DIFFERENCE
        ),
        SegmentedButtonOption(
            label = "Golden point",
            value = RuleTiebreakDecider.GOLDEN_POINT
        ),
    )
    Scaffold(
        snackbarHost = { OperationSnackBarHost(snackBarHostState = snackBarHostState) },
        topBar = {
            MainTopAppBar(
                title = title,
                navigationIcon = {
                    NavigateBackIconButton(onNavigateBack = {
                        onNavigateBack()
                    })
                },
                scrollBehavior = scrollBehavior
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .imePadding()
                .verticalScroll(
                    state = rememberScrollState(),
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultSpacer()
            RuleSection {
                FormTextField(
                    formFieldData = uiState.ruleName,
                    icon = assignmentIcon,
                    onValueChange = editOrNewRuleViewModel::setRuleName,
                    label = "Rule name",
                    placeholder = "My rule",
                    required = true
                )
                DefaultSpacer()
                FormSingleChoiceSegmentedButtonRow(
                    label = "Sets quantity",
                    selectedOption = uiState.ruleSetsQuantityType,
                    options = ruleSetsQuantityTypeOptions,
                    onClick = editOrNewRuleViewModel::setSetsQuantityType,
                )
                DefaultSpacer()
                FormNumberPicker(
                    value = uiState.ruleSetsQuantity,
                    onValueChange = editOrNewRuleViewModel::setSetsQuantity,
                    enabledRemove = editOrNewRuleViewModel.canDecrementSets(uiState.ruleSetsQuantity),
                    enabledAdd = editOrNewRuleViewModel.canIncrementSets(uiState.ruleSetsQuantity),
                    incrementQuantity = if (uiState.ruleSetsQuantityType == RuleSetsQuantityType.BEST_OF) 2
                    else 1,
                    decrementQuantity = if (uiState.ruleSetsQuantityType == RuleSetsQuantityType.BEST_OF) 2
                    else 1
                    )
                DefaultSpacer()
            }
            HorizontalDivider()
            RuleSection {
                DefaultSpacer()
                SectionHeaderText("Sets rules")
                DefaultSpacer()
                FormSingleChoiceSegmentedButtonRow(
                    label = "Sets type",
                    selectedOption = uiState.ruleGlobalSetType,
                    options = ruleGlobalSetTypeOptions,
                    onClick = editOrNewRuleViewModel::setSetsType,
                )
                DefaultSpacer()
                if (uiState.ruleGlobalSetType == RuleSetType.GAMES) {
                    FormNumberPicker(
                        value = uiState.ruleGlobalGamesPerSet,
                        onValueChange = editOrNewRuleViewModel::setGamesPerSet,
                        label = "Games per set",
                        enabledRemove = editOrNewRuleViewModel.canDecrementNumber(uiState.ruleGlobalGamesPerSet),
                        enabledAdd = editOrNewRuleViewModel.canIncrementNumber(uiState.ruleGlobalGamesPerSet),
                    )
                    DefaultSpacer()
                    FormSingleChoiceSegmentedButtonRow(
                        label = "Set decider on maximum games draw",
                        selectedOption = uiState.ruleGlobalSetDecider,
                        options = ruleGlobalTiebreakStartsOnOptions,
                        onClick = editOrNewRuleViewModel::setSetDecider,
                    )
                    DefaultSpacer()
                }
            }
            if (uiState.ruleGlobalSetType == RuleSetType.GAMES) {
                HorizontalDivider()
                RuleSection {
                    DefaultSpacer()
                    SectionHeaderText("Games rules")
                    DefaultSpacer()
                    FormSingleChoiceSegmentedButtonRow(
                        label = "On 40-40",
                        selectedOption = uiState.ruleGlobalOnGameDeuce,
                        options = ruleGlobalOnGameDeuceOptions,
                        onClick = editOrNewRuleViewModel::setOnGameDeuce,
                    )
                    DefaultSpacer()
                    FormInformativeText(
                        title = "How they work",
                        text = """- Golden point: the winner of the next point wins the game.
                    |- Star point: on the third deuce, golden point is played.
                """.trimMargin()
                    )
                    DefaultSpacer()
                }
            }
            if (uiState.ruleGlobalSetDecider == RuleSetDecider.TIEBREAK
                || uiState.ruleGlobalSetType == RuleSetType.TIEBREAK
            ) {
                HorizontalDivider()
                RuleSection {
                    DefaultSpacer()
                    SectionHeaderText("Tiebreaks rules")
                    DefaultSpacer()
                    FormNumberPicker(
                        value = uiState.ruleGlobalPointsPerTiebreak,
                        onValueChange = editOrNewRuleViewModel::setPointsPerTiebreak,
                        label = "Points per tiebreak",
                        enabledRemove = editOrNewRuleViewModel.canDecrementNumber(uiState.ruleGlobalPointsPerTiebreak),
                        enabledAdd = editOrNewRuleViewModel.canIncrementNumber(uiState.ruleGlobalPointsPerTiebreak),
                    )
                    DefaultSpacer()
                    FormSingleChoiceSegmentedButtonRow(
                        label = "Tiebreak winner on maximum points draw",
                        selectedOption = uiState.ruleGlobalTiebreakDecider,
                        options = ruleGlobalTiebreakDeciderOptions,
                        onClick = editOrNewRuleViewModel::setTiebreakDecider,
                    )
                    DefaultSpacer()
                }
            }
            HorizontalDivider()
            RuleSection {
                DefaultSpacer()
                SectionHeaderText("Deciding set")
                DefaultSpacer()
                FormSwitch(
                    label = "Deciding set rules are different",
                    checked = uiState.areDecidingSetRulesDifferent,
                    enabled = uiState.ruleSetsQuantityType == BEST_OF &&
                            uiState.ruleSetsQuantity > 1,
                    onCheckedChange = editOrNewRuleViewModel::setDecidingSet
                )
                DefaultSpacer()
            }
            HorizontalDivider()
            //Deciding set rules
            if (uiState.areDecidingSetRulesDifferent) {
                RuleSection {
                    DefaultSpacer()
                    SectionHeaderText("Deciding set - Set rules")
                    DefaultSpacer()
                    FormSingleChoiceSegmentedButtonRow(
                        label = "Set type",
                        selectedOption = uiState.ruleDecidingSetType,
                        options = ruleGlobalSetTypeOptions,
                        onClick = editOrNewRuleViewModel::setDecidingSetType,
                    )
                    DefaultSpacer()
                    FormNumberPicker(
                        value = uiState.ruleDecidingGamesPerSet,
                        onValueChange = editOrNewRuleViewModel::setDecidingGamesPerSet,
                        label = "Games per set",
                        enabledRemove = editOrNewRuleViewModel.canDecrementNumber(uiState.ruleDecidingGamesPerSet),
                        enabledAdd = editOrNewRuleViewModel.canIncrementNumber(uiState.ruleDecidingGamesPerSet),
                    )
                    DefaultSpacer()
                    FormSingleChoiceSegmentedButtonRow(
                        label = "Set decider on max games draw",
                        selectedOption = uiState.ruleDecidingSetDecider,
                        options = ruleGlobalTiebreakStartsOnOptions,
                        onClick = editOrNewRuleViewModel::setDecidingSetDecider,
                    )
                    DefaultSpacer()
                }
                HorizontalDivider()
                RuleSection {
                    DefaultSpacer()
                    SectionHeaderText("Deciding set - Games rules")
                    DefaultSpacer()
                    FormSingleChoiceSegmentedButtonRow(
                        label = "On 40-40",
                        selectedOption = uiState.ruleDecidingOnGameDeuce,
                        options = ruleGlobalOnGameDeuceOptions,
                        onClick = editOrNewRuleViewModel::setDecidingOnGameDeuce,
                    )
                    DefaultSpacer()
                    FormInformativeText(
                        title = "How they work",
                        text = """- Golden point: the winner of the next point wins the game.
                    |- Star point: on the third deuce, golden point is played.
                """.trimMargin()
                    )
                    DefaultSpacer()
                }
                HorizontalDivider()
                RuleSection {
                    DefaultSpacer()
                    SectionHeaderText("Deciding set - Tiebreaks rules")
                    DefaultSpacer()
                    FormNumberPicker(
                        value = uiState.ruleDecidingPointsPerTiebreak,
                        onValueChange = editOrNewRuleViewModel::setDecidingPointsPerTiebreak,
                        label = "Points per tiebreak",
                        enabledRemove = editOrNewRuleViewModel.canDecrementNumber(uiState.ruleDecidingPointsPerTiebreak),
                        enabledAdd = editOrNewRuleViewModel.canIncrementNumber(uiState.ruleDecidingPointsPerTiebreak),
                    )
                    DefaultSpacer()
                    FormSingleChoiceSegmentedButtonRow(
                        label = "Tiebreak winner on points draw",
                        selectedOption = uiState.ruleDecidingTiebreakDecider,
                        options = ruleGlobalTiebreakDeciderOptions,
                        onClick = editOrNewRuleViewModel::setDecidingTiebreakDecider,
                    )
                    DefaultSpacer()
                }
                HorizontalDivider()
            }
            BigSpacer()
            Button(
                onClick = {}
            ) {
                Text(buttonText)
            }
            DefaultSpacer()
        }
    }
}

@Composable
private fun SectionHeaderText(
    text: String
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = text,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
private fun RuleSection(
    content: @Composable () -> Unit
) { Column(modifier = Modifier.padding(horizontal = 16.dp)) { content() } }

@Composable
@Preview(
    heightDp = 3000
)
private fun EditOrNewRuleScreenPreview() {
    MaterialTheme {
        EditOrNewRuleScreen(
            onNavigateBack = {},
            editOrNewRuleViewModel = viewModel {
                EditOrNewRuleViewModel(
                    ruleRepository = FakeRuleRepository()
                )
            },
            onOperationSuccess = {},
            title = "New Rule",
            buttonText = "Create rule"
        )
    }
}