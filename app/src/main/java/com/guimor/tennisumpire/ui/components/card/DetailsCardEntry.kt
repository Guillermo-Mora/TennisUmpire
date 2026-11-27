package com.guimor.tennisumpire.ui.components.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun DetailsCardEntry(
    definition: String,
    definitionFontWeight: FontWeight? = null,
    definitionColor: Color? = null,
    value: @Composable (() -> Unit)? = null
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
            fontWeight = definitionFontWeight,
            color = definitionColor ?: Color.Unspecified,
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
            value?.invoke()
        }
    }
}