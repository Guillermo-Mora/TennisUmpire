package com.guimor.tennisumpire.ui.screen.onboarding.settings

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.guimor.tennisumpire.R
import com.guimor.tennisumpire.domain.AppLanguage
import com.guimor.tennisumpire.domain.SYSTEM_DEFAULT_LANGUAGE
import com.guimor.tennisumpire.domain.getLanguage
import com.guimor.tennisumpire.domain.model.preferences.Height
import com.guimor.tennisumpire.domain.model.preferences.Theme
import com.guimor.tennisumpire.domain.model.preferences.Weight
import com.guimor.tennisumpire.preferences_data_store.PreferencesDataStore
import com.guimor.tennisumpire.preferences_data_store.PreferencesDataStoreEvent
import com.guimor.tennisumpire.preferences_data_store.value
import com.guimor.tennisumpire.ui.components.form.FormDropDownMenuWithSearch
import com.guimor.tennisumpire.ui.components.form.FormSingleChoiceSegmentedButtonRow
import com.guimor.tennisumpire.ui.components.onboarding.OnBoardingScreenContent
import com.guimor.tennisumpire.ui.components.spacer.BigSpacer
import com.guimor.tennisumpire.ui.components.spacer.DefaultSpacer
import com.guimor.tennisumpire.ui.icons.dark_modeIcon
import com.guimor.tennisumpire.ui.icons.languageIcon
import com.guimor.tennisumpire.ui.icons.light_modeIcon
import com.guimor.tennisumpire.ui.icons.paletteIcon
import com.guimor.tennisumpire.ui.icons.straightenIcon
import com.guimor.tennisumpire.ui.icons.weightIcon
import com.guimor.tennisumpire.ui.model.SegmentedButtonOption

@Composable
fun OnBoardingSettingsScreen(
    onNextPage: () -> Unit,
    uiState: PreferencesDataStore,
    onEvent: (PreferencesDataStoreEvent) -> Unit
) {
    val languageOptions =
        AppLanguage.entries.map {
            SegmentedButtonOption(
                label = stringResource(it.displayName),
                value = it.code
            )
        }.toList()
    val themeOptions = listOf(
        SegmentedButtonOption(
            label = stringResource(R.string.system),
            value = Theme.SYSTEM,
        ),
        SegmentedButtonOption(
            label = stringResource(R.string.dark),
            value = Theme.DARK,
            icon = dark_modeIcon
        ),
        SegmentedButtonOption(
            label = stringResource(R.string.light),
            value = Theme.LIGHT,
            icon = light_modeIcon
        ),
    )
    val heightOptions = listOf(
        SegmentedButtonOption(
            label = "Centimeters",
            value = Height.CENTIMETERS
        ),
        SegmentedButtonOption(
            label = "Inches",
            value = Height.INCHES
        ),
    )
    val weightOptions = listOf(
        SegmentedButtonOption(
            label = "Kilograms",
            value = Weight.KILOGRAMS
        ),
        SegmentedButtonOption(
            label = "Pounds",
            value = Weight.POUNDS
        ),
    )
    OnBoardingScreenContent(
        buttonText = "I am ready",
        buttonAction = {
            onNextPage()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultSpacer()
            Text(
                text = "Set up your preferences",
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 24.sp
            )
            BigSpacer()
            FormDropDownMenuWithSearch(
                labelTitle = "Language",
                iconTitle = languageIcon,
                value = stringResource(
                    AppCompatDelegate.getApplicationLocales().get(0)?.toLanguageTag()
                        .getLanguage().displayName
                ),
                required = true,
                searchFilter = { searchValue, list ->
                    list.filter {
                        it.label?.contains(
                            searchValue.trim(),
                            ignoreCase = true
                        ) == true
                    }
                },
                label = "Language",
                onItemSelected = {
                    onEvent(
                        PreferencesDataStoreEvent.OnChangeLanguage(
                            it?.value ?: SYSTEM_DEFAULT_LANGUAGE
                        )
                    )
                },
                options = languageOptions,
                getItemValue = { it.value },
            ) { option, _ ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = option.label ?: "",
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                    }
                }
            }
            DefaultSpacer()
            FormSingleChoiceSegmentedButtonRow(
                label = "Theme",
                icon = paletteIcon,
                selectedOption = uiState.value { it.theme },
                options = themeOptions,
                onClick = { onEvent(PreferencesDataStoreEvent.OnChangeTheme(it)) }
            )
            DefaultSpacer()
            FormSingleChoiceSegmentedButtonRow(
                label = "Height",
                icon = straightenIcon,
                selectedOption = uiState.value { it.heightFormat },
                options = heightOptions,
                onClick = { onEvent(PreferencesDataStoreEvent.OnChangeHeightFormat(it)) }
            )
            DefaultSpacer()
            FormSingleChoiceSegmentedButtonRow(
                label = "Weight",
                icon = weightIcon,
                selectedOption = uiState.value { it.weightFormat },
                options = weightOptions,
                onClick = { onEvent(PreferencesDataStoreEvent.OnChangeWeightFormat(it)) }
            )
        }
    }
}