package com.guimor.tennisumpire.ui.components.form

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.guimor.tennisumpire.ui.icons.cancelIcon
import com.guimor.tennisumpire.ui.icons.errorIcon
import com.guimor.tennisumpire.ui.icons.searchIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T>FormDropDownMenuWithSearch(
    icon: ImageVector? = null,
    value: String? = null,
    valueIcon: Painter? = null,
    label: String,
    onItemSelected: (T?) -> Unit,
    options: List<T>,
    searchFilter: @Composable (searchValue: String, options: List<T>) -> List<T>,
    required: Boolean = false,
    menuItem: @Composable (T) -> Unit
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    var searchValue by rememberSaveable { mutableStateOf("") }
    val itemsList = if (
        searchValue.isNotBlank()
    ) searchFilter(searchValue, options)
    else options
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
        } ?: Spacer(modifier = Modifier.size(24.dp))
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
                if (expanded) searchValue = ""
            },
            modifier = Modifier
                .widthIn(max = 300.dp)
                .fillMaxWidth()
        ) {
            /*
            SearchBar(
                state = TODO(),
                inputField = TODO(),
                modifier = TODO(),
                shape = TODO(),
                colors = TODO(),
                tonalElevation = TODO(),
                shadowElevation = TODO()
            )
             */
            TextField(
                value = value ?: label,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                leadingIcon =
                    valueIcon?.let {
                        {
                            Image(
                                painter = it,
                                contentDescription = null
                            )
                        }
                    },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable)
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                OutlinedTextField(
                    value = searchValue,
                    onValueChange = { searchValue = it },
                    placeholder = { Text("Search...") },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = searchIcon,
                            contentDescription = "Search"
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                )
                LazyColumn(
                    modifier = Modifier
                        .width(300.dp)
                        .height(200.dp)
                ) {
                    if (!required) {
                        item {
                            DropdownMenuItem(
                                text = {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(
                                            space = 8.dp,
                                            alignment = Alignment.Start
                                        )
                                    ) {
                                        Icon(
                                            imageVector = cancelIcon,
                                            contentDescription = "Select none"
                                        )
                                        Text("None")
                                    }
                                },
                                onClick = {
                                    onItemSelected(null)
                                    expanded = false
                                }
                            )
                        }
                    }
                    items(
                        items = itemsList
                    ) { option ->
                        DropdownMenuItem(
                            text = { menuItem(option) },
                            onClick = {
                                onItemSelected(option)
                                expanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }
            }
        }
    }
}