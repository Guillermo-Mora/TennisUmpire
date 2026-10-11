package com.guimor.tennisumpire.previews

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.guimor.tennisumpire.domain.model.PlayerBackhand
import com.guimor.tennisumpire.domain.model.PlayerDominantHand
import com.guimor.tennisumpire.domain.model.PlayerGender
import com.guimor.tennisumpire.room_database.player.Player
import com.guimor.tennisumpire.ui.components.player.PlayerFullProfileCard
import java.time.LocalDate

@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
private fun PlayerFullProfileCardPreview() {
    MaterialTheme {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
            ) {
                PlayerFullProfileCard(
                    player = Player(
                        uid = 200,
                        firstName = "SDKLFSJFKLDSJ LSDKJFKLSDJFDSLKFJDLKSJDFSLKFJSDLK FSDLKFDJSKLFJDSLKFSJLFSKJFSLKJLKJLKJLKJ",
                        lastName = "SEKLRFJD FLKDSJFLKDSF DSKLFJSLKDJFDSLKSDJFLKSDJFSDLKSFJDLKSFJFDSKLJSFDKLJ",
                        birthdate = LocalDate.of(2005, 10, 27),
                        height = 183.76567567576576f,
                        weight = 688.765765765765765f,
                        country = null,
                        gender = PlayerGender.MALE,
                        dominantHand = PlayerDominantHand.LEFT,
                        backhand = PlayerBackhand.ONE_HANDED,
                        photo = null,
                        favourite = false
                    ),
                )
            }
        }
    }
}