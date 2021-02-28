package com.andro.pupdop.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.andro.pupdop.ui.theme.typography

@Composable
fun Greeting(
    name: String,
    city: String,
    state: String
) {
    Column {
        Box(
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    start = 24.dp,
                    end = 24.dp
                )
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Column (
                modifier = Modifier.padding(24.dp).fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Welcome, $name!",
                    style = typography.h1,
                    textAlign = TextAlign.Center
                )
                Text(text = "$city, $state")
            }
        }
    }
}