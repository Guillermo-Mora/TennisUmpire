package com.guimor.tennisumpire.ui.components.rule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guimor.tennisumpire.ui.components.top_bar.NavigateBackIconButton
import com.guimor.tennisumpire.ui.components.top_bar.TitleCustomTopAppBar
import com.guimor.tennisumpire.ui.icons.starFilledIcon
import com.guimor.tennisumpire.ui.icons.starIcon

@Composable
fun RuleTitleCard(
    ruleName: String?,
    onClickToggleAddRuleToFavourites: () -> Unit,
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

            Text(
                text = ruleName ?: "",
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
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .weight(1f)
        ) {
            IconButton(
                onClick = { onClickToggleAddRuleToFavourites() },
                modifier = Modifier
                    .weight(1f)
            ) {
                Icon(
                    imageVector =
                        if (/*rule?.favourite == true*/ false) starFilledIcon
                        else starIcon,
                    contentDescription = "Toggle add to favourites",
                    tint =
                        if (/*rule?.favourite == true*/ false) MaterialTheme.colorScheme.tertiary
                        else LocalContentColor.current,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
private fun RuleTitleCardPreview() {
    Scaffold(
        topBar = {
            TitleCustomTopAppBar(
                titleContent = {

                    RuleTitleCard(
                        ruleName = "Normal rule loooooooong",
                        onClickToggleAddRuleToFavourites = {},
                    )
                },
                navigationIcon = { NavigateBackIconButton(onNavigateBack = {}) },
            )
        }
    ) { paddingValues -> Column(modifier = Modifier.padding(paddingValues)) {} }
}