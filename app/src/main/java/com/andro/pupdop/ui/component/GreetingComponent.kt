/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.andro.pupdop.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andro.pupdop.R
import com.andro.pupdop.ui.theme.PupdopTheme
import com.andro.pupdop.ui.theme.typography

@Composable
fun Greeting(
    name: String,
    city: String,
    state: String
) {
    Column {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
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

@Preview("Light greeter")
@Composable
fun LightGreet() {
    PupdopTheme {
        Scaffold {
            Greeting(
                name = stringResource(id = R.string.user),
                city = stringResource(id = R.string.city),
                state = stringResource(id = R.string.state)
            )
        }
    }
}

@Preview("Dark greeter")
@Composable
fun DarkGreet() {
    PupdopTheme(darkTheme = true) {
        Scaffold {
            Greeting(
                name = stringResource(id = R.string.user),
                city = stringResource(id = R.string.city),
                state = stringResource(id = R.string.state)
            )
        }
    }
}
