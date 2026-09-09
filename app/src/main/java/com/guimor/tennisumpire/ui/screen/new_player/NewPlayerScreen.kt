package com.guimor.tennisumpire.ui.screen.new_player

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guimor.tennisumpire.ui.components.top_bar.MainTopAppBar
import com.guimor.tennisumpire.ui.components.top_bar.NavigateBackIconButton

@Composable
fun NewPlayerScreen(
    onNavigateBack: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    Scaffold(
        topBar = {
            MainTopAppBar(
                title = "New player",
                onNavigateToSettings = { onNavigateToSettings() },
                navigationIcon = { NavigateBackIconButton(onNavigateBack = { onNavigateBack() }) }
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           TextField(
               value = "",
               onValueChange = {},
               label = { },
               placeholder = { },
               leadingIcon = { },
               trailingIcon = { },
               supportingText = {},
               isError = false,
               singleLine = true
           )
        }
    }
}

@Composable
@Preview
fun NewPlayerScreenPreview() {
    NewPlayerScreen(
        onNavigateBack = {},
        onNavigateToSettings = {}
    )
}