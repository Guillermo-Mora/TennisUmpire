package com.guimor.tennisumpire.ui.components.rule

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.guimor.tennisumpire.room_database.rule.Rule
import com.guimor.tennisumpire.ui.components.player.CardBottomSheet
import com.guimor.tennisumpire.ui.components.player.DetailsSection
import com.guimor.tennisumpire.ui.icons.articleIcon
import com.guimor.tennisumpire.ui.icons.more_vertIcon
import com.guimor.tennisumpire.ui.icons.starIcon

@Composable
fun RuleListCard(
    modifier: Modifier = Modifier,
    rule: Rule,
    interactiveMode: Boolean = true,
    onClickToggleAddRuleToFavourites: () -> Unit,
    onClickDeleteRule: (() -> Unit)? = null,
    onClickEditRule: (() -> Unit)? = null,
    onClickRuleDetails: (() -> Unit)? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = if (interactiveMode) Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surfaceContainerHighest)
            .clickable(
                onClick = { onClickRuleDetails?.invoke() }
            )
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
                .weight(6f)
                .height(47.dp)
        ) {
            Text(
                text = rule.name,
                overflow = TextOverflow.Ellipsis,
                softWrap = false
            )
        }
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .weight(if (interactiveMode) 2f else 1f)
        ) {
            IconButton(
                onClick = { onClickToggleAddRuleToFavourites() },
                modifier = Modifier
                    .weight(1f)
            ) {
                /*
            Icon(
                imageVector =
                    if (rule.favourite) starFilledIcon
                    else starIcon,
                contentDescription = "Toggle add to favourites",
                tint =
                    if (rule.favourite) MaterialTheme.colorScheme.tertiary
                    else LocalContentColor.current,
            )
             */
                Icon(
                    imageVector = starIcon,
                    contentDescription = "Toggle add to favourites",
                    tint = LocalContentColor.current
                )
            }
            if (interactiveMode) {
                CardBottomSheet(
                    registryName = rule.name,
                    onClickDelete = { onClickDeleteRule?.invoke() },
                    onClickEdit = { onClickEditRule?.invoke() },
                    detailsSection = DetailsSection(
                        text = "Details",
                        icon = articleIcon,
                        onClickDetails = { onClickRuleDetails?.invoke() }
                    ),
                    content = {
                        RuleListCard(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(MaterialTheme.colorScheme.surfaceContainerHigh),
                            rule = rule,
                            interactiveMode = false,
                            onClickToggleAddRuleToFavourites = { onClickToggleAddRuleToFavourites() }
                        )
                    },
                ) { onOpenBottomSheet ->
                    IconButton(
                        onClick = { onOpenBottomSheet() },
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Icon(
                            imageVector = more_vertIcon,
                            contentDescription = "Rule options"
                        )
                    }
                }
            }
        }
    }
}