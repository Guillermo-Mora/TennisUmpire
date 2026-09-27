package com.guimor.tennisumpire.previews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.guimor.tennisumpire.domain.model.PlayerBackhand
import com.guimor.tennisumpire.domain.model.PlayerDominantHand
import com.guimor.tennisumpire.domain.model.PlayerGender
import com.guimor.tennisumpire.room_database.player.Player
import com.guimor.tennisumpire.ui.components.player.PlayerCardBottomSheet
import java.time.LocalDate

@Composable
@Preview
fun PlayerCardBottomSheetPreview() {
    Scaffold() { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            PlayerCardBottomSheet(
                player = Player(
                    uid = 0,
                    firstName = "Guillermo",
                    lastName = "Mora",
                    birthdate = LocalDate.of(2025, 10, 27),
                    height = 183f,
                    weight = 68f,
                    country = null,
                    gender = PlayerGender.MALE,
                    dominantHand = PlayerDominantHand.LEFT,
                    backhand = PlayerBackhand.ONE_HANDED,
                    photo = null
                )
            ) {
            }
        }
    }
}