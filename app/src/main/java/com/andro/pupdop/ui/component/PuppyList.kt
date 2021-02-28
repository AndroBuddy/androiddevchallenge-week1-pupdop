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

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.andro.pupdop.R
import com.andro.pupdop.ui.theme.typography

@Composable
fun PuppyList() {
    Column(
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        Text(
            text = "Adopt a pup",
            modifier = Modifier.padding(top = 16.dp),
            style = typography.h2
        )
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            val context = LocalContext.current
            Box(
                modifier = Modifier
                    .padding(
                        top = 24.dp
                    )
                    .height(146.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .clickable(
                        onClick = {
                            Toast.makeText(context, "Pup woof!", Toast.LENGTH_SHORT).show()
                        }
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.challace),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .fillMaxHeight()
                        .padding(24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "Challace",
                        style = typography.h2,
                        color = Color.White
                    )
                    Text(
                        text = "poodle",
                        style = typography.body1,
                        color = Color.White
                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(
                        top = 24.dp
                    )
                    .height(146.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .clickable(
                        onClick = {
                            Toast.makeText(context, "Pup woof!", Toast.LENGTH_SHORT).show()
                        }
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.buffy),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .fillMaxHeight()
                        .padding(24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "Buffy",
                        style = typography.h2,
                        color = Color.White
                    )
                    Text(
                        text = "bulldog",
                        style = typography.body1,
                        color = Color.White
                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(
                        top = 24.dp
                    )
                    .height(146.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .clickable(
                        onClick = {
                            Toast.makeText(context, "Pup woof!", Toast.LENGTH_SHORT).show()
                        }
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.doge),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .fillMaxHeight()
                        .padding(24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "Doge",
                        style = typography.h2,
                        color = Color.White
                    )
                    Text(
                        text = "shiba inu",
                        style = typography.body1,
                        color = Color.White
                    )
                }
            }
        }
    }
}
