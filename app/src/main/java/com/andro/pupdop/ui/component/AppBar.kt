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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andro.pupdop.R
import com.andro.pupdop.ui.theme.PupdopTheme
import com.andro.pupdop.ui.theme.typography

@Composable
fun AppBar() {
    Row(
        modifier = Modifier.padding(24.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = typography.h1
        )
        IconButton(
            onClick = {},
            modifier = Modifier.then(Modifier.size(24.dp))
        ) {
            Icon(
                imageVector = Icons.Outlined.AccountCircle,
                contentDescription = "user",
                tint = Color.Cyan
            )
        }
    }
}

@Preview("Light bar")
@Composable
fun LightBar() {
    PupdopTheme {
        Scaffold {
            AppBar()
        }
    }
}

@Preview("Dark bar")
@Composable
fun DarkBar() {
    PupdopTheme(darkTheme = true) {
        Scaffold {
            AppBar()
        }
    }
}
