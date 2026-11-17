package com.guimor.tennisumpire.ui.components.rule

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guimor.tennisumpire.domain.model.player.PlayerBackhand
import com.guimor.tennisumpire.domain.model.player.PlayerDominantHand
import com.guimor.tennisumpire.domain.model.player.PlayerGender
import com.guimor.tennisumpire.room_database.player.Player
import com.guimor.tennisumpire.room_database.rule.Rule
import com.guimor.tennisumpire.ui.components.card.DetailsCardEntry
import com.guimor.tennisumpire.ui.components.text.TextOneLine
import com.guimor.tennisumpire.ui.icons.femaleIcon
import com.guimor.tennisumpire.ui.icons.maleIcon
import com.guimor.tennisumpire.ui.icons.pan_toolIcon
import com.guimor.tennisumpire.ui.icons.sign_languageIcon
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

@Composable
fun RuleDetailsCard(
    rule: Rule?
) {
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        color = MaterialTheme.colorScheme.surfaceContainer,
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            DetailsCardEntry(
                definition = "Full Name"
            ) {
                TextOneLine("${rule?.firstName} ${rule?.lastName}")
            }
            rule?.gender?.let { gender ->
                DetailsCardEntry(
                    definition = "Gender"
                ) {

                    Icon(
                        imageVector = if (gender == PlayerGender.MALE) maleIcon else femaleIcon,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                    TextOneLine(if (gender == PlayerGender.MALE) "Male" else "Female")
                }
            }
            rule?.country?.let { country ->
                DetailsCardEntry(
                    definition = "Country"
                ) {
                    Box(
                        modifier = Modifier
                            .size(15.dp)
                    ) {
                        Image(
                            painter = painterResource(country.flag),
                            contentDescription = "Country",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                        )
                    }
                    TextOneLine(stringResource(country.displayName))
                }
            }
            rule?.birthdate?.let { birthdate ->
                val age = Period.between(birthdate, LocalDate.now()).years.toString()
                DetailsCardEntry(
                    definition = "Age"
                ) {
                    TextOneLine("$age (${birthdate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))})")
                }
            }
            rule?.height?.let { height ->
                DetailsCardEntry(
                    definition = "Height"
                ) {
                    TextOneLine("$height cm")
                }
            }
            rule?.weight?.let { weight ->
                DetailsCardEntry(
                    definition = "Weight"
                ) {
                    TextOneLine("$weight kg")
                }
            }
            rule?.dominantHand?.let { dominantHand ->
                DetailsCardEntry(
                    definition = "Dominant hand"
                ) {
                    Icon(
                        imageVector = pan_toolIcon,
                        modifier = if (dominantHand == PlayerDominantHand.LEFT)
                            Modifier.scale(scaleX = -1f, scaleY = 1f).size(18.dp)
                        else Modifier.size(18.dp),
                        contentDescription = null,
                    )
                    TextOneLine(if (dominantHand == PlayerDominantHand.RIGHT) "Right" else "Left")
                }
            }
            rule?.backhand?.let { backhand ->
                DetailsCardEntry(
                    definition = "Backhand"
                ) {
                    Icon(
                        imageVector = if (backhand == PlayerBackhand.TWO_HANDED) sign_languageIcon
                        else pan_toolIcon,
                        contentDescription = "Male",
                        modifier = Modifier
                            .size(18.dp)
                    )
                    TextOneLine(if (backhand == PlayerBackhand.TWO_HANDED) "Two-Handed" else "One-Handed")
                }
            }
        }
    }
}

@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
private fun RuleDetailsCardPreview() {
    MaterialTheme {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
            ) {
                RuleDetailsCard(
                    rule = Player(
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