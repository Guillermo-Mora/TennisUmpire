package com.guimor.tennisumpire.ui.screen.players

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guimor.tennisumpire.domain.model.PlayerGender
import com.guimor.tennisumpire.ui.icons.cakeFilledIcon
import com.guimor.tennisumpire.ui.icons.cakeIcon
import com.guimor.tennisumpire.ui.icons.femaleIcon
import com.guimor.tennisumpire.ui.icons.maleIcon
import com.guimor.tennisumpire.ui.icons.more_vertIcon
import com.guimor.tennisumpire.ui.icons.personFilledIcon
import java.time.LocalDate
import java.time.Period

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayersScreen(
    onNavigateBack: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior,
    viewModel: PlayersViewModel = viewModel(factory = PlayersViewModel.Factory),
) {
    BackHandler { onNavigateBack() }
    val uiState by viewModel.uiState.collectAsState()
    val currentLocalDate = LocalDate.now()
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        itemsIndexed(uiState.players) { index, player ->
            val playerAge =
                 player.birthdate?.let { playerBirthdate ->
                     Period.between(playerBirthdate, currentLocalDate).years.toString()
                         .let {
                             if (it.length >= 4) it.substring(0,3)
                             else it
                         }
                 }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.surfaceContainerHighest)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 8.dp,
                        alignment = Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(
                            horizontal = 8.dp,
                            vertical = 8.dp
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .size(35.dp)
                    ) {
                        player.country?.let {
                            Image(
                                painter = painterResource(it.flag),
                                contentDescription = "Player image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(CircleShape)
                                    .background(color = MaterialTheme.colorScheme.surfaceContainerHighest)
                            )
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
                        modifier = Modifier
                            .widthIn(max = 120.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "${player.firstName.first()}. ${player.lastName}",
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(
                                space = 4.dp,
                                alignment = Alignment.Start
                            )
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(15.dp)
                            ) {
                                player.country?.let { country ->
                                    Image(
                                        painter = painterResource(country.flag),
                                        contentDescription = "Country",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .clip(CircleShape)
                                    )
                                }
                            }
                            Text(
                                text = player.country?.let { stringResource(it.displayName) }
                                    ?: "",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )

                        }
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(
                            space = 4.dp,
                            alignment = Alignment.CenterVertically
                        )
                    ) {
                        //I don't like very much how this looks with the space separation
                        // from the name. So I will change the layout and do it like Sofascore.
                        //However, I'm sure that I will only add gender and age as extra
                        //information in this view. The rest will be visible inside the
                        //detail screen.
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxHeight(0.5f)
                        ) {
                             player.gender?.let { gender ->
                                Icon(
                                    imageVector = when(gender) {
                                        PlayerGender.MALE -> maleIcon
                                        PlayerGender.FEMALE -> femaleIcon
                                    },
                                    contentDescription = "Player age",
                                    modifier = Modifier.size(15.dp),
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxHeight(0.5f)
                        ) {
                            playerAge?.let { playerAge ->
                                Icon(
                                    imageVector = cakeFilledIcon,
                                    contentDescription = "Player age",
                                    modifier = Modifier.size(15.dp),
                                    MaterialTheme.colorScheme.onSurfaceVariant
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
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = more_vertIcon,
                        contentDescription = "Player options"
                    )
                }
            }
        }
    }
}