package com.guimor.tennisumpire.ui.components.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.guimor.tennisreferee.R
import com.guimor.tennisumpire.ui.icons.errorIcon
import com.guimor.tennisumpire.ui.components.error.getErrorMessage

@Composable
fun FormTextField(
    icon: ImageVector? = null,
    formFieldData: FormFieldData,
    onValueChange: (newValue: String) -> Unit,
    label: String,
    placeholder: String,
    keyboardType: KeyboardType = KeyboardOptions.Default.keyboardType,
    visualTransformation: VisualTransformation? = null,
    required: Boolean = false
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon?.let {
            Icon(
                modifier = Modifier
                    .padding(bottom = 20.dp),
                imageVector = it,
                contentDescription = null,
            )
        } ?: Spacer(
            modifier = Modifier
                .size(24.dp)
        )
        TextField(
            value = formFieldData.value,
            onValueChange = { onValueChange(it) },
            label = {
                Row {
                    Text(label)
                    if (required) Text(" *")
                }
            },
            placeholder = { Text(placeholder) },
            supportingText = {
                Text(
                    if (required && formFieldData.error == null) stringResource(R.string.required)
                    else if (formFieldData.error != null) formFieldData.error.getErrorMessage()
                    else ""
                )
            },
            isError = formFieldData.error != null,
            trailingIcon = {
                formFieldData.error?.let {
                    Icon(
                        imageVector = errorIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardOptions.Default.capitalization,
                autoCorrectEnabled = KeyboardOptions.Default.autoCorrectEnabled,
                keyboardType = keyboardType,
                imeAction = KeyboardOptions.Default.imeAction,
                platformImeOptions = KeyboardOptions.Default.platformImeOptions,
                showKeyboardOnFocus = KeyboardOptions.Default.showKeyboardOnFocus,
                hintLocales = KeyboardOptions.Default.hintLocales
            ),
            visualTransformation = visualTransformation ?: VisualTransformation.None,
            modifier = Modifier
                .widthIn(max = 300.dp)
                .fillMaxWidth()
        )
    }
}