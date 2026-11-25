package com.guimor.tennisumpire.ui.screen.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.guimor.tennisumpire.domain.model.preferences.Height
import com.guimor.tennisumpire.domain.model.preferences.Theme
import com.guimor.tennisumpire.domain.model.preferences.Weight
import com.guimor.tennisumpire.preferences_data_store.PreferencesDataStoreViewModel
import com.guimor.tennisumpire.preferences_data_store.value
import com.guimor.tennisumpire.ui.components.form.FormDropDownMenuWithSearch
import com.guimor.tennisumpire.ui.components.form.FormSingleChoiceSegmentedButtonRow
import com.guimor.tennisumpire.ui.components.onboarding.OnBoardingScreenContent
import com.guimor.tennisumpire.ui.components.spacer.BigSpacer
import com.guimor.tennisumpire.ui.components.spacer.DefaultSpacer
import com.guimor.tennisumpire.ui.components.spacer.SmallSpacer
import com.guimor.tennisumpire.ui.components.text.TextWithIcon
import com.guimor.tennisumpire.ui.icons.dark_modeIcon
import com.guimor.tennisumpire.ui.icons.languageIcon
import com.guimor.tennisumpire.ui.icons.light_modeIcon
import com.guimor.tennisumpire.ui.icons.paletteIcon
import com.guimor.tennisumpire.ui.icons.straightenIcon
import com.guimor.tennisumpire.ui.icons.weightIcon
import com.guimor.tennisumpire.ui.model.SegmentedButtonOption

@Composable
fun OnBoardingScreenSettings(
    onNextPage: () -> Unit,
    preferencesDataStoreViewModel: PreferencesDataStoreViewModel
) {
    val preferencesDataStoreState by preferencesDataStoreViewModel.userPreferencesDataStore.collectAsStateWithLifecycle()
    val themeOptions = listOf(
        SegmentedButtonOption(
            label = "System",
            value = Theme.SYSTEM,
        ),
        SegmentedButtonOption(
            label = "Dark",
            value = Theme.DARK,
            icon = dark_modeIcon
        ),
        SegmentedButtonOption(
            label = "Light",
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
                .verticalScroll(rememberScrollState())
        ) {
            DefaultSpacer()
            Text(
                text = "Set up your preferences",
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 24.sp
            )
            BigSpacer()
            TextWithIcon(
                label = "Language",
                icon = languageIcon
            )
            SmallSpacer()
            FormDropDownMenuWithSearch(
                value = "System",
                required = true,
                searchFilter = { searchValue, list ->
                    list.filter { it.contains(searchValue.trim(), ignoreCase = true) }
                },
                label = "Country",
                onItemSelected = { },
                options = listOf("System", "English", "Spanish"),
                getItemValue = { it },
            ) { option, _ ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = option,
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                    }
                }
            }
            DefaultSpacer()
            FormSingleChoiceSegmentedButtonRow(
                label = "Theme",
                icon = paletteIcon,
                selectedOption = Theme.SYSTEM,
                options = themeOptions,
                onClick = { }
            )
            DefaultSpacer()
            FormSingleChoiceSegmentedButtonRow(
                label = "Height",
                icon = straightenIcon,
                selectedOption = preferencesDataStoreState.value { it.heightFormat },
                options = heightOptions,
                onClick = preferencesDataStoreViewModel::changeHeightFormat
            )
            DefaultSpacer()
            FormSingleChoiceSegmentedButtonRow(
                label = "Weight",
                icon = weightIcon,
                selectedOption = preferencesDataStoreState.value { it.weightFormat },
                options = weightOptions,
                onClick = preferencesDataStoreViewModel::changeWeightFormat
            )
        }
    }
}