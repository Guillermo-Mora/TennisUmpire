package com.guimor.tennisumpire.ui.screen.shared_screen.edit_or_new_rule

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.guimor.tennisumpire.R
import com.guimor.tennisumpire.domain.model.Country
import com.guimor.tennisumpire.domain.model.player.PlayerBackhand
import com.guimor.tennisumpire.domain.model.player.PlayerDominantHand
import com.guimor.tennisumpire.domain.model.player.PlayerGender
import com.guimor.tennisumpire.domain.operation_result.result_type.SuccessResult
import com.guimor.tennisumpire.domain.ui_messages.ResultWithUiText
import com.guimor.tennisumpire.domain.ui_messages.toResultWithUiText
import com.guimor.tennisumpire.ui.components.form.AddPhotoAlertDialog
import com.guimor.tennisumpire.ui.components.form.FormDateField
import com.guimor.tennisumpire.ui.components.form.FormDropDownMenuWithSearch
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
import com.guimor.tennisumpire.ui.icons.cakeIcon
import com.guimor.tennisumpire.ui.icons.femaleIcon
import com.guimor.tennisumpire.ui.icons.globe_location_pinIcon
import com.guimor.tennisumpire.ui.icons.maleIcon
import com.guimor.tennisumpire.ui.icons.pan_toolIcon
import com.guimor.tennisumpire.ui.icons.personFilledIcon
import com.guimor.tennisumpire.ui.icons.personIcon
import com.guimor.tennisumpire.ui.icons.sign_languageIcon
import com.guimor.tennisumpire.ui.icons.straightenIcon
import com.guimor.tennisumpire.ui.icons.weightIcon
import com.guimor.tennisumpire.ui.model.SegmentedButtonOption

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditOrNewRuleScreen(
    onNavigateBack: () -> Unit,
    onNavigateToSettings: () -> Unit,
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
    val playerGenderOptions = listOf(
        SegmentedButtonOption(
            label = "Male",
            icon = maleIcon,
            value = PlayerGender.MALE
        ),
        SegmentedButtonOption(
            label = "Female",
            icon = femaleIcon,
            value = PlayerGender.FEMALE
        ),
    )
    val playerDominantHandOptions = listOf(
        SegmentedButtonOption(
            label = "Left",
            icon = pan_toolIcon,
            mirrorIcon = true,
            value = PlayerDominantHand.LEFT
        ),
        SegmentedButtonOption(
            label = "Right",
            icon = pan_toolIcon,
            value = PlayerDominantHand.RIGHT
        ),
    )
    val playerBackhandOptions = listOf(
        SegmentedButtonOption(
            label = "Two-handed",
            icon = sign_languageIcon,
            value = PlayerBackhand.TWO_HANDED
        ),
        SegmentedButtonOption(
            label = "One-handed",
            icon = pan_toolIcon,
            value = PlayerBackhand.ONE_HANDED
        ),
    )
    Scaffold(
        snackbarHost = { OperationSnackBarHost(snackBarHostState = snackBarHostState) },
        topBar = {
            MainTopAppBar(
                title = title,
                onNavigateToSettings = { onNavigateToSettings() },
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
        LazyColumn(
            state = lazyListState,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .imePadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                ) {
                    Surface(
                        shape = CircleShape,
                        modifier = Modifier
                            .border(
                                width = 1.5.dp,
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.surfaceContainerHighest
                            )
                    ) {
                        uiState.playerPhotoUri?.let {
                            AsyncImage(
                                modifier = Modifier
                                    .fillMaxSize(),
                                model = it,
                                contentDescription = "Player photo",
                                contentScale = ContentScale.Crop
                            )
                        } ?: Icon(
                            modifier = Modifier
                                .fillMaxSize(),
                            imageVector = personFilledIcon,
                            contentDescription = "Player photo",
                            tint = MaterialTheme.colorScheme.secondary
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.Bottom,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        AddPhotoAlertDialog(
                            selectedPhoto = uiState.playerPhotoUri,
                            setPhoto = editPlayerViewModel::setPlayerPhoto
                        ) { onOpenDialog ->
                            IconButton(
                                modifier = Modifier
                                    .size(45.dp),
                                colors = IconButtonColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                                    contentColor = IconButtonDefaults.iconButtonColors().contentColor,
                                    disabledContainerColor = IconButtonDefaults.iconButtonColors().disabledContainerColor,
                                    disabledContentColor = IconButtonDefaults.iconButtonColors().disabledContentColor
                                ),
                                onClick = { onOpenDialog() }
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(10.dp),
                                    imageVector = add_photo_alternateIcon,
                                    contentDescription = "Add player picture"
                                )
                            }
                        }
                    }
                }
                BigSpacer()
            }
            item {
                FormTextField(
                    formFieldData = uiState.playerFirstName,
                    icon = personIcon,
                    onValueChange = editPlayerViewModel::setPlayerFirstName,
                    label = "First name",
                    placeholder = "William",
                    required = true,
                )
                DefaultSpacer()
            }
            item {
                FormTextField(
                    formFieldData = uiState.playerLastName,
                    onValueChange = editPlayerViewModel::setPlayerLastName,
                    label = "Last name",
                    placeholder = "Smith",
                    required = true
                )
                DefaultSpacer()
            }
            item {
                FormDateField(
                    icon = cakeIcon,
                    formFieldDataType = uiState.playerBirthdate,
                    onDateSelected = editPlayerViewModel::setPlayerBirthdate,
                    label = "Birthdate"
                )
                DefaultSpacer()
            }
            item {
                FormTextField(
                    formFieldData = uiState.playerHeight,
                    icon = straightenIcon,
                    onValueChange = editPlayerViewModel::setPlayerHeight,
                    label = "Height",
                    placeholder = "180 cm",
                    keyboardType = KeyboardType.Decimal,
                    visualTransformation = HeightVisualTransformation()
                )
                DefaultSpacer()
            }
            item {
                FormTextField(
                    formFieldData = uiState.playerWeight,
                    icon = weightIcon,
                    onValueChange = editPlayerViewModel::setPlayerWeight,
                    label = "Weight",
                    placeholder = "85 kg",
                    keyboardType = KeyboardType.Decimal,
                    visualTransformation = WeightVisualTransformation()
                )
                DefaultSpacer()
            }
            item {
                FormDropDownMenuWithSearch(
                    value = uiState.playerCountry?.let { stringResource(it.displayName) },
                    valueIcon = uiState.playerCountry?.let { painterResource(it.flag) },
                    icon = globe_location_pinIcon,
                    searchFilter = { searchValue, list ->
                        list.filter {
                            stringResource(it.displayName)
                                .contains(searchValue.trim(), ignoreCase = true)
                        }
                    },
                    label = "Country",
                    onItemSelected = editPlayerViewModel::setPlayerCountry,
                    options = Country.entries
                ) { option ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(
                            space = 8.dp,
                            alignment = Alignment.Start
                        )
                    ) {
                        Image(
                            painter = painterResource(option.flag),
                            contentDescription = null,
                        )
                        Text(
                            text = stringResource(option.displayName),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
                DefaultSpacer()
            }
            item {
                FormSingleChoiceSegmentedButtonRow(
                    label = "Gender",
                    selectedOption = uiState.playerGender,
                    options = playerGenderOptions,
                    onClick = editPlayerViewModel::setPlayerGender,
                )
                DefaultSpacer()
            }
            item {
                FormSingleChoiceSegmentedButtonRow(
                    label = "Dominant hand",
                    selectedOption = uiState.playerDominantHand,
                    options = playerDominantHandOptions,
                    onClick = editPlayerViewModel::setPlayerDominantHand,
                )
                DefaultSpacer()
            }
            item {
                FormSingleChoiceSegmentedButtonRow(
                    label = "Backhand",
                    selectedOption = uiState.playerBackhand,
                    options = playerBackhandOptions,
                    onClick = editPlayerViewModel::setPlayerBackhand,
                )
                BigSpacer()
            }
            item {
                Button(
                    onClick = { editPlayerViewModel.validateForm() }
                ) {
                    Text(buttonText)
                }
                DefaultSpacer()
            }
        }
    }

     */
}