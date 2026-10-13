package com.guimor.tennisumpire.ui.components.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guimor.tennisumpire.ui.components.spacer.DefaultSpacer
import com.guimor.tennisumpire.ui.icons.addIcon
import com.guimor.tennisumpire.ui.icons.removeIcon
import com.guimor.tennisumpire.ui.model.FormFieldData

@Composable
fun FormNumberPicker(
    formFieldData: FormFieldData,
    onValueChange: (newValue: String) -> Unit,
    label: String?,
    placeHolder: String,
    keyboardType: KeyboardType = KeyboardType.Number,
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
                    onValueChange = { onValueChange("") },
                    icon = removeIcon,
                    contentDescription = "Remove"
                )
                OutlinedTextField(
                    value = formFieldData.value,
                    onValueChange = { onValueChange(it) },
                    placeholder = { Text(placeHolder) },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardOptions.Default.capitalization,
                        autoCorrectEnabled = KeyboardOptions.Default.autoCorrectEnabled,
                        keyboardType = keyboardType,
                        imeAction = KeyboardOptions.Default.imeAction,
                        platformImeOptions = KeyboardOptions.Default.platformImeOptions,
                        showKeyboardOnFocus = KeyboardOptions.Default.showKeyboardOnFocus,
                        hintLocales = KeyboardOptions.Default.hintLocales
                    ),
                    modifier = Modifier.width(70.dp)
                )
                PickerButton(
                    onValueChange = { onValueChange("") },
                    icon = addIcon,
                    contentDescription = "Add"
                )
            }
        }
    }
}

@Composable
private fun PickerButton(
    onValueChange: (newValue: String) -> Unit,
    icon: ImageVector,
    contentDescription: String
) {
    IconButton(
        onClick = { onValueChange("") },
        colors = IconButtonColors(
            containerColor = IconButtonDefaults.iconButtonColors().containerColor, //MaterialTheme.colorScheme.surfaceContainerHighest,
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
            val formFieldData = FormFieldData()
            FormNumberPicker(
                formFieldData = formFieldData,
                onValueChange = {},
                placeHolder = "3",
                label = "Number picker"
            )
        }
    }
}