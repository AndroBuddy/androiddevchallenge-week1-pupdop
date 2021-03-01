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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.andro.pupdop.R
import com.andro.pupdop.data.PupProvider
import com.andro.pupdop.ui.module.PupId
import com.andro.pupdop.ui.module.PupListModule
import com.andro.pupdop.ui.theme.typography

@Composable
fun PupdopDetail(
    navController: NavController,
    pupId: PupId
) {
    val puppy = PupProvider.getPup(pupId)
    Box {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            item {
                Header(
                    navController = navController,
                    puppy = puppy
                )
            }
            item {
                DetailBody(puppy = puppy)
            }
        }
        AdoptButton()
    }
}

@Composable
fun Header(
    navController: NavController,
    puppy: PupListModule
) {
    Surface {
        key(puppy.image) {
            Image(
                painter = painterResource(id = puppy.image),
                contentDescription = "image",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }
        IconButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = "back",
                tint = Color.White
            )
        }
    }
}

@Composable
fun DetailBody(
    puppy: PupListModule
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 24.dp)
        ) {
            val favPup = remember { mutableStateOf(false) }
            // Puppy Info
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = puppy.name,
                        style = typography.h1
                    )
                    Text(
                        text = puppy.breed.breed,
                        style = typography.body2
                    )
                }
                IconButton(
                    onClick = {
                        favPup.value = !favPup.value
                    }
                ) {
                    Icon(
                        imageVector = if (favPup.value) { Icons.Outlined.Favorite } else { Icons.Outlined.FavoriteBorder },
                        contentDescription = "favorite",
                        tint = if (favPup.value) { Color.Red } else { MaterialTheme.colors.onSecondary }
                    )
                }
            }

            // Location
            Row(
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.LocationOn,
                    contentDescription = "location",
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = puppy.location,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            // Owner & Contact
            Row(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Owner info
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = puppy.ownerImg),
                        contentDescription = "owner",
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .size(64.dp)
                    )
                    Column(
                        modifier = Modifier.padding(start = 24.dp)
                    ) {
                        Text(
                            text = puppy.owner,
                            style = typography.subtitle1
                        )
                        Text(text = "Owner")
                    }
                }

                // Contact buttons
                Row {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Outlined.Phone,
                            contentDescription = "call"
                        )
                    }
                    IconButton(onClick = {}, modifier = Modifier.padding(start = 8.dp)) {
                        Icon(
                            imageVector = Icons.Outlined.Message,
                            contentDescription = "text"
                        )
                    }
                }
            }

            // Words from owner
            Row(
                modifier = Modifier.padding(top = 32.dp)
            ) {
                Text(
                    text = stringResource(R.string.puppy_info),
                    style = typography.body1,
                    lineHeight = 24.sp
                )
            }
        }
    }
}

@Composable
private fun BoxScope.AdoptButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .padding(32.dp)
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(16.dp))
            .align(Alignment.BottomCenter)
    ) {
        Text(
            text = "Adopt Me!",
            style = typography.h1
        )
    }
}
