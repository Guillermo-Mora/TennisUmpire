package com.guimor.tennisumpire.ui.screen.onboarding

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.guimor.tennisumpire.ui.components.onboarding.OnBoardingScreenContent

@Composable
fun OnBoardingScreen3(
    onNextPage: () -> Unit
) {
    OnBoardingScreenContent(
        buttonText = "I am ready",
        buttonAction = {
            onNextPage()
        }
    ) {
        Text(
            text = "Save results, players, and analyze them",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            lineHeight = 40.sp
        )
    }
}