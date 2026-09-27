package com.guimor.tennisumpire.ui.components.player

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.guimor.tennisumpire.domain.model.PlayerGender
import com.guimor.tennisumpire.room_database.player.Player
import com.guimor.tennisumpire.ui.icons.cakeFilledIcon
import com.guimor.tennisumpire.ui.icons.femaleIcon
import com.guimor.tennisumpire.ui.icons.fiber_manual_recordFilledIcon
import com.guimor.tennisumpire.ui.icons.maleIcon
import com.guimor.tennisumpire.ui.icons.more_vertIcon
import com.guimor.tennisumpire.ui.icons.personFilledIcon
import java.time.LocalDate
import java.time.Period

@Composable
fun PlayerListCard(
    modifier: Modifier = Modifier,
    player: Player,
    interactiveMode: Boolean = true,
) {
    val playerAge =
        player.birthdate?.let { playerBirthdate ->
            Period.between(playerBirthdate, LocalDate.now()).years.toString()
        }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = if (interactiveMode) Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surfaceContainerHighest)
        else modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(
                space = 8.dp,
                alignment = Alignment.Start
            ),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    horizontal = 10.dp,
                    vertical = 10.dp
                )
                .weight(5f)
        ) {
            Box(
                modifier = Modifier
                    .size(35.dp)
            ) {
                player.photo?.let {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                            .background(color = MaterialTheme.colorScheme.surfaceContainerHighest)
                    ) {
                        AsyncImage(
                            model = it,
                            contentDescription = "Player image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                        )
                    }
                } ?: Icon(
                    imageVector = personFilledIcon,
                    contentDescription = "Player image",
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.background)
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    space = 0.dp,
                    alignment = Alignment.CenterVertically
                ),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 4.dp,
                        alignment = Alignment.Start,
                    ),
                    modifier = Modifier
                        .height(23.dp)
                ) {
                    Text(
                        text = "${player.firstName.first()}. ${player.lastName}",
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .weight(
                                weight = 10f,
                                fill = false
                            )
                    )
                    player.gender?.let { gender ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(
                                space = 4.dp,
                                alignment = Alignment.Start,
                            )
                        ) {
                            Icon(
                                imageVector = fiber_manual_recordFilledIcon,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.background,
                                modifier = Modifier
                                    .size(10.dp)
                            )
                            Icon(
                                imageVector = when (gender) {
                                    PlayerGender.MALE -> maleIcon
                                    PlayerGender.FEMALE -> femaleIcon
                                },
                                contentDescription = "Player gender",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier
                                    .size(15.dp)
                            )
                        }
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 4.dp,
                        alignment = Alignment.CenterHorizontally
                    ),
                    modifier = Modifier
                        .height(23.dp)
                ) {
                    player.country?.let { country ->
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
                        Text(
                            text = stringResource(country.displayName),
                            fontSize = 12.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier
                                .weight(
                                    weight = 10f,
                                    fill = false
                                )
                        )
                        playerAge?.let {
                            Icon(
                                imageVector = fiber_manual_recordFilledIcon,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.background,
                                modifier = Modifier
                                    .size(10.dp)
                            )
                        }
                    }
                    playerAge?.let {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(
                                space = 2.dp,
                                alignment = Alignment.Start
                            )
                        ) {
                            Icon(
                                imageVector = cakeFilledIcon,
                                contentDescription = "Player age",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier
                                    .size(15.dp)
                                    .offset(y = (-1).dp),
                            )
                            Text(
                                text = playerAge,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
        if (interactiveMode) {
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .weight(1f)
            ) {
                PlayerCardBottomSheet(
                    player = player,
                    { onOpenBottomSheet ->
                        IconButton(
                            onClick = { onOpenBottomSheet() }
                        ) {
                            Icon(
                                imageVector = more_vertIcon,
                                contentDescription = "Player options"
                            )
                        }
                    }
                )
            }
        }
    }
}