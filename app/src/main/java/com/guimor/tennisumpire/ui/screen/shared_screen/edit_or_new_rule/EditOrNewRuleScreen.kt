package com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_rule

import androidx.activity.compose.BackHandler
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
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
import androidx.compose.runtime.rememberCoroutineScope
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
import com.guimor.tennisumpire.ui.components.snackbar_host.OperationSnackBarVisuals
import com.guimor.tennisumpire.ui.components.spacer.BigSpacer
import com.guimor.tennisumpire.ui.components.spacer.DefaultSpacer
import com.guimor.tennisumpire.ui.components.top_bar.MainTopAppBar
import com.guimor.tennisumpire.ui.components.top_bar.NavigateBackIconButton
import com.guimor.tennisumpire.ui.icons.assignmentIcon
import com.guimor.tennisumpire.ui.model.SegmentedButtonOption
import kotlinx.coroutines.launch

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
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
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
                    visuals = OperationSnackBarVisuals(
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
    val ruleNameRequester = remember { BringIntoViewRequester() }
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
            Column(
                modifier = Modifier
                    .animateContentSize(),
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
                        required = true,
                        modifier = Modifier
                            .widthIn(max = 500.dp)
                            .fillMaxWidth()
                            .bringIntoViewRequester(ruleNameRequester)
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
                        incrementQuantity = if (uiState.ruleSetsQuantityType == BEST_OF) 2
                        else 1,
                        decrementQuantity = if (uiState.ruleSetsQuantityType == BEST_OF) 2
                        else 1
                    )
                    DefaultSpacer()
                }
                //Normal set rules
                HorizontalDivider()
                SetsSection(
                    isDecidingSet = false,
                    setType = uiState.ruleGlobalSetType,
                    setDecider = uiState.ruleGlobalSetDecider,
                    gamesPerSet = uiState.ruleGlobalGamesPerSet,
                    onGameDeuce = uiState.ruleGlobalOnGameDeuce,
                    pointsPerTiebreak = uiState.ruleGlobalPointsPerTiebreak,
                    tieBreakDecider = uiState.ruleGlobalTiebreakDecider,
                    setSetType = editOrNewRuleViewModel::setSetsType,
                    setGamesPerSet = editOrNewRuleViewModel::setGamesPerSet,
                    setSetDecider = editOrNewRuleViewModel::setSetDecider,
                    setOnGameDeuce = editOrNewRuleViewModel::setOnGameDeuce,
                    setTiebreakDecider = editOrNewRuleViewModel::setTiebreakDecider,
                    setPointsPerTiebreak = editOrNewRuleViewModel::setPointsPerTiebreak,
                    canDecrementNumber = editOrNewRuleViewModel::canDecrementNumber,
                    canIncrementNumber = editOrNewRuleViewModel::canIncrementNumber
                )
                HorizontalDivider()
                RuleSection {
                    DefaultSpacer()
                    SectionHeaderText("Deciding set rules")
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
                //Deciding set rules
                HorizontalDivider()
                if (uiState.areDecidingSetRulesDifferent) {
                    SetsSection(
                        isDecidingSet = true,
                        setType = uiState.ruleDecidingSetType,
                        setDecider = uiState.ruleDecidingSetDecider,
                        gamesPerSet = uiState.ruleDecidingGamesPerSet,
                        onGameDeuce = uiState.ruleDecidingOnGameDeuce,
                        pointsPerTiebreak = uiState.ruleDecidingPointsPerTiebreak,
                        tieBreakDecider = uiState.ruleDecidingTiebreakDecider,
                        setSetType = editOrNewRuleViewModel::setDecidingSetType,
                        setGamesPerSet = editOrNewRuleViewModel::setDecidingGamesPerSet,
                        setSetDecider = editOrNewRuleViewModel::setDecidingSetDecider,
                        setOnGameDeuce = editOrNewRuleViewModel::setDecidingOnGameDeuce,
                        setTiebreakDecider = editOrNewRuleViewModel::setDecidingTiebreakDecider,
                        setPointsPerTiebreak = editOrNewRuleViewModel::setDecidingPointsPerTiebreak,
                        canDecrementNumber = editOrNewRuleViewModel::canDecrementNumber,
                        canIncrementNumber = editOrNewRuleViewModel::canIncrementNumber
                    )
                    HorizontalDivider()
                }
                RuleSection {
                    DefaultSpacer()
                    SectionHeaderText("Serving order")
                    DefaultSpacer()
                }
                BigSpacer()
                Button(
                    onClick = {
                        val firstError = editOrNewRuleViewModel.validateForm()
                        when (firstError) {
                            RequestableFieldsIDs.RULE_NAME -> {
                                scope.launch { ruleNameRequester.bringIntoView() }
                            }

                            else -> {}
                        }
                    }
                ) {
                    Text(buttonText)
                }
                DefaultSpacer()
            }
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
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .animateContentSize()
    ) {
        content()
    }
}

@Composable
private fun SetsSection(
    isDecidingSet: Boolean,
    setType: RuleSetType,
    setDecider: RuleSetDecider,
    gamesPerSet: Int,
    onGameDeuce: RuleOnGameDeuce,
    pointsPerTiebreak: Int,
    tieBreakDecider: RuleTiebreakDecider,
    setSetType: (RuleSetType) -> Unit,
    setGamesPerSet: (Int) -> Unit,
    setSetDecider: (RuleSetDecider) -> Unit,
    setOnGameDeuce: (RuleOnGameDeuce) -> Unit,
    setTiebreakDecider: (RuleTiebreakDecider) -> Unit,
    setPointsPerTiebreak: (Int) -> Unit,
    canDecrementNumber: (Int) -> Boolean,
    canIncrementNumber: (Int) -> Boolean
) {
    val prefix = "Deciding set - "
    fun stringValue(common: String, deciding: String) = if (isDecidingSet) deciding else common
    val setTypeOptions = listOf(
        SegmentedButtonOption(
            label = stringResource(R.string.games),
            value = RuleSetType.GAMES
        ),
        SegmentedButtonOption(
            label = stringResource(R.string.tiebreak),
            value = RuleSetType.TIEBREAK
        ),
    )
    val setDeciderOptions = listOf(
        SegmentedButtonOption(
            label = "Tiebreak",
            value = RuleSetDecider.TIEBREAK
        ),
        SegmentedButtonOption(
            label = "2 games difference",
            value = RuleSetDecider.TWO_GAMES_DIFFERENCE
        ),
    )
    val onGameDeuceOptions = listOf(
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
    val tiebreakDeciderOptions = listOf(
        SegmentedButtonOption(
            label = "Two points difference",
            value = RuleTiebreakDecider.TWO_POINTS_DIFFERENCE
        ),
        SegmentedButtonOption(
            label = "Golden point",
            value = RuleTiebreakDecider.GOLDEN_POINT
        ),
    )
    RuleSection {
        DefaultSpacer()
        SectionHeaderText(stringValue(common = "Sets rules", deciding = "${prefix}Set rules"))
        DefaultSpacer()
        FormSingleChoiceSegmentedButtonRow(
            label = "Sets type",
            selectedOption = setType,
            options = setTypeOptions,
            onClick = { setSetType(it) },
        )
        DefaultSpacer()
        if (setType == RuleSetType.GAMES) {
            FormNumberPicker(
                value = gamesPerSet,
                onValueChange = { setGamesPerSet(it) },
                label = "Games per set",
                enabledRemove = canDecrementNumber(gamesPerSet),
                enabledAdd = canIncrementNumber(gamesPerSet),
            )
            DefaultSpacer()
            FormSingleChoiceSegmentedButtonRow(
                label = "Set decider on maximum games draw",
                selectedOption = setDecider,
                options = setDeciderOptions,
                onClick = { setSetDecider(it) },
            )
            DefaultSpacer()
        }
    }
    if (setType == RuleSetType.GAMES) {
        HorizontalDivider()
        RuleSection {
            DefaultSpacer()
            SectionHeaderText(
                stringValue(
                    common = "Games rules",
                    deciding = "${prefix}Games rules"
                )
            )
            DefaultSpacer()
            FormSingleChoiceSegmentedButtonRow(
                label = "On 40-40",
                selectedOption = onGameDeuce,
                options = onGameDeuceOptions,
                onClick = { setOnGameDeuce(it) },
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
    if (setDecider == RuleSetDecider.TIEBREAK
        || setType == RuleSetType.TIEBREAK
    ) {
        HorizontalDivider()
        RuleSection {
            DefaultSpacer()
            SectionHeaderText(
                stringValue(
                    common = "Tiebreaks rules",
                    deciding = "${prefix}Tiebreak rules"
                )
            )
            DefaultSpacer()
            FormNumberPicker(
                value = pointsPerTiebreak,
                onValueChange = { setPointsPerTiebreak(it) },
                label = "Points per tiebreak",
                enabledRemove = canDecrementNumber(pointsPerTiebreak),
                enabledAdd = canIncrementNumber(pointsPerTiebreak),
            )
            DefaultSpacer()
            FormSingleChoiceSegmentedButtonRow(
                label = "Tiebreak winner on points draw",
                selectedOption = tieBreakDecider,
                options = tiebreakDeciderOptions,
                onClick = { setTiebreakDecider(it) },
            )
            DefaultSpacer()
        }
    }
}

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