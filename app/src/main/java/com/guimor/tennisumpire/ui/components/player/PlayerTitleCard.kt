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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.guimor.tennisumpire.domain.model.PlayerBackhand
import com.guimor.tennisumpire.domain.model.PlayerDominantHand
import com.guimor.tennisumpire.domain.model.PlayerGender
import com.guimor.tennisumpire.room_database.player.Player
import com.guimor.tennisumpire.ui.icons.personFilledIcon
import com.guimor.tennisumpire.ui.icons.starFilledIcon
import com.guimor.tennisumpire.ui.icons.starIcon
import java.time.LocalDate

@Composable
fun PlayerTitleCard(
    player: Player?,
    onClickToggleAddPlayerToFavourites: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
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
                .weight(6f)
        ) {
            Box(
                modifier = Modifier
                    .size(35.dp)
            ) {
                player?.photo?.let {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                    ) {
                        AsyncImage(
                            model = it,
                            contentDescription = "Player image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                                .background(color = MaterialTheme.colorScheme.onBackground)
                        )
                    }
                } ?: Icon(
                    imageVector = personFilledIcon,
                    contentDescription = "Player image",
                    tint = MaterialTheme.colorScheme.background,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.onBackground)
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
                        text = player?.let { player ->
                            "${player.firstName.first()}. ${player.lastName}"
                        } ?: "",
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .weight(
                                weight = 10f,
                                fill = false
                            )
                    )
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
                    player?.country?.let { country ->
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
                    }
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .weight(1f)
        ) {
            IconButton(
                onClick = { onClickToggleAddPlayerToFavourites() },
                modifier = Modifier
                    .weight(1f)
            ) {
                Icon(
                    imageVector =
                        if (player?.favourite == true) starFilledIcon
                        else starIcon,
                    contentDescription = "Toggle add to favourites",
                    tint =
                        if (player?.favourite == true) MaterialTheme.colorScheme.tertiary
                        else LocalContentColor.current,
                )
            }
        }
    }
}