package com.guimor.tennisumpire.ui.screen.onboarding

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.guimor.tennisumpire.ui.components.onboarding.OnBoardingScreenContent

@Composable
fun OnBoardingScreen2(
    onNextPage: () -> Unit
) {
    OnBoardingScreenContent(
        buttonText = "Continue",
        buttonAction = { onNextPage() }
    ) {
        Text(
            text = "Track every match with stats and more",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            lineHeight = 40.sp
        )
    }
}