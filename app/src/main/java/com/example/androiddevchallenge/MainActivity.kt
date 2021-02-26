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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Main()
                }
            }
        }
    }
}

// Main
@Composable
fun Main() {
    Scaffold {
        Column {
            AppBar()
            Content()
        }
    }
}

// Custom AppBar
@Composable
fun AppBar() {
    Row (
        modifier = Modifier.padding(24.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Pupdop",
            style = typography.h1
        )
        Image(
            painter = painterResource(id = R.drawable.ic_search),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSecondary),
            contentDescription = null
        )
    }
}

// Welcoming card layout
@Composable
fun ContentView() {
    Column {
        Box(
            modifier = Modifier.padding(top = 16.dp, start = 24.dp, end = 24.dp)
                .fillMaxWidth()
                .height(100.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .background(Color.Gray)
        ) {
            Column (
                modifier = Modifier.padding(24.dp).fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Welcome, Clarice!",
                    style = typography.h1,
                    textAlign = TextAlign.Center
                )
                Text(text = "Chicago, US")
            }
        }
    }
}


// LazyList for main content
@Composable
fun Content() {
    val scrollState = rememberLazyListState()
    LazyColumn(state = scrollState, modifier = Modifier.fillMaxWidth()) {
        item { ContentView() }
        item { Adopt() }
        item { BreedChoice() }
    }
}

@Composable
fun Adopt() {
    Column {
        val scrollState = rememberLazyListState()
        Text(text = "Adopt a pup",
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 40.dp, bottom = 24.dp),
            style = typography.h2
        )
        LazyRow(state = scrollState, modifier = Modifier.fillMaxWidth()) {
            items(4) {
                Box(
                    modifier = Modifier.padding(start = 24.dp)
                        .width(160.dp)
                        .height(216.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(Color.Gray)
                ) {
                    Column {
                        Text(text = "Challace",
                            modifier = Modifier.padding(24.dp),
                            style = typography.h2
                        )
                        IconButton(
                            onClick = {}
                        ) {}
                    }
                }
            }
        }
    }
}

@Composable
fun BreedChoice() {
    Column {
        val scrollState = rememberLazyListState()
        Text(text = "Choose by Breed",
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 40.dp, bottom = 24.dp),
            style = typography.h2
        )
        LazyRow(state = scrollState, modifier = Modifier.fillMaxWidth()) {
            items(4) {
                Box(
                    modifier = Modifier.padding(start = 24.dp)
                        .width(160.dp)
                        .height(160.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(Color.Gray)
                ) {
                    Text(text = "Shiba Inu",
                        modifier = Modifier.align(Alignment.Center),
                        style = typography.h2
                    )
                }
            }
        }
    }
}


// Previews

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        Main()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Main()
    }
}
