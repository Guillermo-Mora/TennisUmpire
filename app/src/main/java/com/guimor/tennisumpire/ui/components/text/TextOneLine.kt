package com.guimor.tennisumpire.ui.components.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun TextOneLine(
    text: String
) {
    Text(
        text = text,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}