package com.guimor.tennisumpire.ui.components.form

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guimor.tennisumpire.R
import com.guimor.tennisumpire.ui.components.spacer.BigSpacer
import com.guimor.tennisumpire.ui.icons.infoIcon

@Composable
fun FormInformativeText(
    title: String? = null,
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        Column {
            Icon(
                imageVector = infoIcon,
                contentDescription = stringResource(R.string.info),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Column {

            Text(
                text = title ?: text,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontWeight = title?.let { FontWeight.SemiBold }
            )
            title?.let {
                Spacer(Modifier.height(4.dp))
                Text(
                    text = text,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun FormInformativeTextPreview() {
    MaterialTheme{
        Scaffold {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                FormInformativeText(
                    title = "Aditional information",
                    text = "This is very important to read and to understand before proceeding. So please, pay attention to all the details we describe in this informative section."
                )
                BigSpacer()
                FormInformativeText(
                    text = "This is very important to read and to understand before proceeding. So please, pay attention to all the details we describe in this informative section."
                )
            }
        }
    }
}