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
package com.andro.pupdop.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.andro.pupdop.Navigation
import com.andro.pupdop.R
import com.andro.pupdop.data.PupProvider
import com.andro.pupdop.ui.component.AppBar
import com.andro.pupdop.ui.component.Greeting
import com.andro.pupdop.ui.component.PupListLayout
import com.andro.pupdop.ui.component.SearchBar
import com.andro.pupdop.ui.theme.typography

@Composable
fun PupdopList(
    navController: NavController
) {
    Column {
        val scrollState = rememberLazyListState()

        AppBar()
        Greeting(
            name = stringResource(id = R.string.user),
            city = stringResource(id = R.string.city),
            state = stringResource(id = R.string.state)
        )
        SearchBar()
        ScrollingBody(
            scrollState = scrollState,
            navController = navController
        )
    }
}

@Composable
fun ScrollingBody(
    scrollState: LazyListState,
    navController: NavController
) {
    val pupList = PupProvider.getAllPups()

    LazyColumn(
        state = scrollState,
        modifier = Modifier.fillMaxWidth().padding(top = 24.dp)
    ) {
        item {
            Text(
                text = "Adopt your pup",
                modifier = Modifier.padding(start = 24.dp),
                style = typography.h2
            )
        }

        itemsIndexed(pupList) { _, puppy ->
            key(puppy.id.value) {
                PupListLayout(
                    puppy = puppy,
                    onClick = {
                        navController.navigate(Navigation.buildPuppyDetailPath(pupId = puppy.id))
                    }
                )
            }
        }
    }
}
