package com.guimor.tennisumpire.ui.components.player

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.guimor.tennisumpire.domain.model.PlayerBackhand
import com.guimor.tennisumpire.domain.model.PlayerDominantHand
import com.guimor.tennisumpire.domain.model.PlayerGender
import com.guimor.tennisumpire.room_database.player.Player
import com.guimor.tennisumpire.ui.icons.femaleIcon
import com.guimor.tennisumpire.ui.icons.front_handIcon
import com.guimor.tennisumpire.ui.icons.maleIcon
import com.guimor.tennisumpire.ui.icons.pan_toolIcon
import com.guimor.tennisumpire.ui.icons.sign_languageIcon
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.Date

@Composable
fun PlayerFullProfileCard(
    player: Player?
) {
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        color = MaterialTheme.colorScheme.surfaceContainerHighest,
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            CardEntry(
                definition = "Full Name"
            ) {
                TextOneLine("${player?.firstName} ${player?.lastName}")
            }
            player?.gender?.let { gender ->
                CardEntry(
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
            player?.country?.let { country ->
                CardEntry(
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
            player?.birthdate?.let { birthdate ->
                val age = Period.between(birthdate, LocalDate.now()).years.toString()
                CardEntry(
                    definition = "Age"
                ) {
                    TextOneLine("$age (${birthdate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))})")
                }
            }
            player?.height?.let { height ->
                CardEntry(
                    definition = "Height"
                ) {
                    TextOneLine("$height cm")
                }
            }
            player?.weight?.let { weight ->
                CardEntry(
                    definition = "Weight"
                ) {
                    TextOneLine("$weight kg")
                }
            }
            player?.dominantHand?.let { dominantHand ->
                CardEntry(
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
            player?.backhand?.let { backhand ->
                CardEntry(
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
private fun CardEntry(
    definition: String,
    value: @Composable () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        Text(
            text = definition,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier
                .weight(1f)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(
                space = 8.dp,
                alignment = Alignment.End
            ),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(1f)
        ) {
            value()
        }
    }
}

@Composable
private fun TextOneLine(
    text: String
) {
    Text(
        text = text,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}