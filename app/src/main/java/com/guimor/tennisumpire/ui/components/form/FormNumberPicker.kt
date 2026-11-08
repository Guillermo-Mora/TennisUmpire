package com.guimor.tennisumpire.ui.components.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guimor.tennisumpire.ui.components.spacer.DefaultSpacer
import com.guimor.tennisumpire.ui.icons.addIcon
import com.guimor.tennisumpire.ui.icons.removeIcon

@Composable
fun FormNumberPicker(
    value: Int,
    onValueChange: (newValue: Int) -> Unit,
    label: String? = null,
    enabledRemove: Boolean,
    enabledAdd: Boolean,
    incrementQuantity: Int = 1,
    decrementQuantity: Int = 1,
) {
    Column(
        modifier = Modifier
            .widthIn(max = 500.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        label?.let { label ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = label)
            }
            DefaultSpacer()
        }
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.surfaceContainerHighest
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PickerButton(
                    onValueChange = { onValueChange(value - decrementQuantity) },
                    icon = removeIcon,
                    contentDescription = "Remove",
                    enabled = enabledRemove
                )
                Text(
                    text = value.toString()
                )
                PickerButton(
                    onValueChange = { onValueChange(value + incrementQuantity) },
                    icon = addIcon,
                    contentDescription = "Add",
                    enabled = enabledAdd
                )
            }
        }
    }
}

@Composable
private fun PickerButton(
    onValueChange: () -> Unit,
    icon: ImageVector,
    contentDescription: String,
    enabled: Boolean
) {
    IconButton(
        onClick = { onValueChange() },
        enabled = enabled,
        colors = IconButtonColors(
            containerColor = IconButtonDefaults.iconButtonColors().containerColor,
            contentColor = IconButtonDefaults.iconButtonColors().contentColor,
            disabledContainerColor = IconButtonDefaults.iconButtonColors().disabledContainerColor,
            disabledContentColor = IconButtonDefaults.iconButtonColors().disabledContentColor
        )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription
        )
    }
}

@Preview
@Composable
fun FormNumberPickerPreview() {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            FormNumberPicker(
                onValueChange = {},
                value = 3,
                label = "Number picker",
                enabledRemove = true,
                enabledAdd = true,
            )
        }
    }
}