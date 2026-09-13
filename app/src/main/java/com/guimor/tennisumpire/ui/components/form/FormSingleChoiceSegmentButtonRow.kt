package com.guimor.tennisumpire.ui.components.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun <T>FormSingleChoiceSegmentedButtonRow(
    label: String,
    selectedOption: T?,
    options: List<SegmentedButtonOption<T>>,
    onClick: (optionValue: T) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(label)
            Spacer(
                modifier = Modifier
                    .height(8.dp)
            )
            SingleChoiceSegmentedButtonRow {
                options.forEachIndexed { index, option ->
                    SegmentedButton(
                        selected = option.value == selectedOption,
                        onClick = { onClick(option.value) },
                        shape = SegmentedButtonDefaults.itemShape(
                            index = index,
                            count = options.size,
                        ),
                        icon = { SegmentedButtonDefaults.Icon(active = option.value == selectedOption) },
                        label = {
                            Icon(
                                imageVector = option.icon,
                                contentDescription = option.label,
                                modifier = if (option.mirrorIcon)
                                    Modifier.scale(scaleX = -1f, scaleY = 1f)
                                else Modifier
                            )
                        }
                    )
                }
            }
        }
    }
}

data class SegmentedButtonOption<T>(
    val selected: Boolean = false,
    val label: String,
    val icon: ImageVector,
    val mirrorIcon: Boolean = false,
    val value: T
)