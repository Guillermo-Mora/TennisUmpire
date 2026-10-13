package com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_rule

import android.widget.NumberPicker
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.guimor.tennisumpire.R
import com.guimor.tennisumpire.domain.model.Country
import com.guimor.tennisumpire.domain.model.player.PlayerBackhand
import com.guimor.tennisumpire.domain.model.player.PlayerDominantHand
import com.guimor.tennisumpire.domain.model.player.PlayerGender
import com.guimor.tennisumpire.domain.model.rule.RuleSetsQuantityType
import com.guimor.tennisumpire.domain.model.rule.RuleSetsQuantityType.*
import com.guimor.tennisumpire.domain.operation_result.result_type.SuccessResult
import com.guimor.tennisumpire.domain.ui_messages.ResultWithUiText
import com.guimor.tennisumpire.domain.ui_messages.toResultWithUiText
import com.guimor.tennisumpire.ui.components.form.AddPhotoAlertDialog
import com.guimor.tennisumpire.ui.components.form.FormDateField
import com.guimor.tennisumpire.ui.components.form.FormDropDownMenuWithSearch
import com.guimor.tennisumpire.ui.components.form.FormNumberPicker
import com.guimor.tennisumpire.ui.components.form.FormSingleChoiceSegmentedButtonRow
import com.guimor.tennisumpire.ui.components.form.FormTextField
import com.guimor.tennisumpire.ui.components.snackbar_host.OperationSnackBarHost
import com.guimor.tennisumpire.ui.components.snackbar_host.OperationSnackbarVisuals
import com.guimor.tennisumpire.ui.components.spacer.BigSpacer
import com.guimor.tennisumpire.ui.components.spacer.DefaultSpacer
import com.guimor.tennisumpire.ui.components.top_bar.MainTopAppBar
import com.guimor.tennisumpire.ui.components.top_bar.NavigateBackIconButton
import com.guimor.tennisumpire.ui.components.transformation.HeightVisualTransformation
import com.guimor.tennisumpire.ui.components.transformation.WeightVisualTransformation
import com.guimor.tennisumpire.ui.icons.add_photo_alternateIcon
import com.guimor.tennisumpire.ui.icons.assignmentIcon
import com.guimor.tennisumpire.ui.icons.cakeIcon
import com.guimor.tennisumpire.ui.icons.femaleIcon
import com.guimor.tennisumpire.ui.icons.globe_location_pinIcon
import com.guimor.tennisumpire.ui.icons.maleIcon
import com.guimor.tennisumpire.ui.icons.pan_toolIcon
import com.guimor.tennisumpire.ui.icons.personFilledIcon
import com.guimor.tennisumpire.ui.icons.personIcon
import com.guimor.tennisumpire.ui.icons.settingsIcon
import com.guimor.tennisumpire.ui.icons.sign_languageIcon
import com.guimor.tennisumpire.ui.icons.straightenIcon
import com.guimor.tennisumpire.ui.icons.weightIcon
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
                        "ruleName"//uiState.ruleName
                    )
                )
                onNavigateBack()
            } else {
                snackBarHostState.showSnackbar(
                    visuals = OperationSnackbarVisuals(
                        resultWithUiText = operationResult.toResultWithUiText(
                            R.string.rule,
                            "ruleName"//uiState.ruleName
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
            selected = false,
            label = stringResource(R.string.best_of),
            value = BEST_OF
        ),
        SegmentedButtonOption(
            selected = false,
            label = stringResource(R.string.fixed_quantity),
            value = FIXED_QUANTITY
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
                .padding(horizontal = 16.dp)
                .imePadding()
                .verticalScroll(
                    state = rememberScrollState(),
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultSpacer()
            FormTextField(
                formFieldData = uiState.ruleName,
                icon = assignmentIcon,
                onValueChange = {}, //editPlayerViewModel::setPlayerFirstName,
                label = "Rule name",
                placeholder = "My rule",
                required = false //required = true,
            )
            DefaultSpacer()
            FormSingleChoiceSegmentedButtonRow(
                label = "Sets quantity",
                selectedOption = uiState.ruleSetsQuantityType,
                options = ruleSetsQuantityTypeOptions,
                onClick = {},
            )
            DefaultSpacer()
            FormNumberPicker(
                formFieldData = uiState.ruleSetsQuantity,
                onValueChange = {},
                label = null,//
                placeHolder = "3"
            )
            BigSpacer()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Sets rule",
                    fontWeight = FontWeight.Bold
                )
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