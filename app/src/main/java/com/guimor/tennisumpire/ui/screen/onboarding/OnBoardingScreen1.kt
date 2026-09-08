package com.guimor.tennisumpire.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guimor.tennisreferee.R
import com.guimor.tennisumpire.icons.high_chairIcon
import com.guimor.tennisumpire.ui.components.onboarding.OnBoardingScreenContent


@Composable
fun OnBoardingScreen1(
    onNextPage: () -> Unit,
) {
    OnBoardingScreenContent(
        buttonText = "Get started",
        buttonAction = { onNextPage() }
    ) {
        Icon(
            imageVector = high_chairIcon,
            contentDescription = "Tennis chair umpire",
            modifier = Modifier
                .fillMaxSize(0.3F)
        )
        Text(
            text = "Tennis Umpire",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
        )
        Text(
            text = "The ultimate tool for tennis chair umpires"
        )
    }
}