package com.guimor.tennisumpire.ui.components.form

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.getSelectedDate
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.guimor.tennisreferee.R
import com.guimor.tennisumpire.ui.icons.date_rangeIcon
import com.guimor.tennisumpire.domain.error.getErrorMessage
import com.guimor.tennisumpire.ui.model.FormFieldDataType
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Composable
fun FormDateField(
    icon: ImageVector? = null,
    formFieldDataType: FormFieldDataType<LocalDate>,
    onDateSelected: (newValue: LocalDate?) -> Unit,
    label: String,
    required: Boolean = false
) {
    var selectedDate by rememberSaveable { mutableStateOf<Long?>(null) }
    var showModal by rememberSaveable { mutableStateOf(false) }
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
            value = formFieldDataType.value?.formatDate() ?: "",
            onValueChange = {},
            label = { Text(label) },
            placeholder = { Text("MM/DD/YYYY") },
            trailingIcon = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = date_rangeIcon,
                        contentDescription = "Select date"
                    )
                }
            },
            supportingText = {
                Text(
                    if (required && formFieldDataType.error == null) stringResource(R.string.required)
                    else if (formFieldDataType.error != null) formFieldDataType.error.getErrorMessage()
                    else ""
                )
            },
            readOnly = true,
            isError = formFieldDataType.error != null,
            singleLine = true,
            modifier = Modifier
                .widthIn(max = 300.dp)
                .fillMaxWidth()
                .pointerInput(selectedDate) {
                    awaitEachGesture {
                        // Modifier.clickable doesn't work for text fields, so we use Modifier.pointerInput
                        // in the Initial pass to observe events before the text field consumes them
                        // in the Main pass.
                        awaitFirstDown(pass = PointerEventPass.Initial)
                        val upEvent =
                            waitForUpOrCancellation(pass = PointerEventPass.Initial)
                        if (upEvent != null) {
                            showModal = true
                        }
                    }
                }
        )
        if (showModal) {
            DatePickerModal(
                onDateSelected = { onDateSelected(it) },
                onDismiss = { showModal = false }
            )
        }
    }
}

private fun LocalDate.formatDate() =
    DateTimeFormatter.ofPattern("MM/dd/yyyy").format(this)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDateSelected: (LocalDate?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()
    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = {
                    onDateSelected(datePickerState.getSelectedDate())
                    onDismiss()
                }
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(
                onClick = { onDismiss() }
            ) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}