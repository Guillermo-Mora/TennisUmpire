package com.guimor.tennisumpire.ui.components.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


fun LazyListScope.textEmptyListAction(
    itemCount: Int,
    title: String,
    actionText: String,
    icon: ImageVector
) {
    if (itemCount == 0) {
        val text = actionText.split('+')
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = text.first()
                    )
                    Icon(
                        imageVector = icon,
                        contentDescription = "action",
                        modifier = Modifier
                            .size(24.dp),
                    )
                    Text(text.last())
                }
            }
        }
    }
}