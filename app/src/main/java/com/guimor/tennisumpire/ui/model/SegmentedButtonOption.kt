package com.guimor.tennisumpire.ui.model

import androidx.compose.ui.graphics.vector.ImageVector

data class SegmentedButtonOption<T>(
    val selected: Boolean = false,
    val label: String,
    val icon: ImageVector? = null,
    val mirrorIcon: Boolean = false,
    val value: T
)