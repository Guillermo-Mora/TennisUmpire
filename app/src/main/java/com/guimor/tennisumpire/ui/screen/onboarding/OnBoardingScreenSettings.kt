package com.guimor.tennisumpire.ui.screen.onboarding

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.guimor.tennisumpire.ui.components.form.FormSingleChoiceSegmentedButtonRow
import com.guimor.tennisumpire.ui.components.onboarding.OnBoardingScreenContent
import com.guimor.tennisumpire.ui.components.spacer.DefaultSpacer
import com.guimor.tennisumpire.ui.icons.straightenIcon
import com.guimor.tennisumpire.ui.icons.weightIcon
import com.guimor.tennisumpire.ui.model.SegmentedButtonOption

@Composable
fun OnBoardingScreenSettings(
    onNextPage: () -> Unit
) {
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
            Text("Configure your preferences")
            Text("Language (English, Spanish, system)")
            Text("Theme (light, dark, system)")
            FormSingleChoiceSegmentedButtonRow(
                label = "Height",
                icon = straightenIcon,
                selectedOption = "cm",
                options = listOf(
                    SegmentedButtonOption(
                        label = "Centimeters",
                        value = "cm"
                    ),
                    SegmentedButtonOption(
                        label = "Inches",
                        value = "in"
                    ),
                ),
                onClick = { }
            )
            DefaultSpacer()
            FormSingleChoiceSegmentedButtonRow(
                label = "Weight",
                icon = weightIcon,
                selectedOption = "kg",
                options = listOf(
                    SegmentedButtonOption(
                        label = "Kilograms",
                        value = "kg"
                    ),
                    SegmentedButtonOption(
                        label = "Pounds",
                        value = "lbs"
                    ),
                ),
                onClick = { }
            )
        }
    }
}