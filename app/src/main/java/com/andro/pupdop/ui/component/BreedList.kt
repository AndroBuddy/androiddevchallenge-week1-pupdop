package com.andro.pupdop.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.andro.pupdop.R
import com.andro.pupdop.ui.theme.typography

@Composable
fun BreedList() {
    Column(
        modifier = Modifier.padding(bottom = 24.dp)
    ) {
        val scrollState = rememberLazyListState()
        Text(text = "Choose by Breed",
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 40.dp, bottom = 24.dp),
            style = typography.h2
        )
        LazyRow(state = scrollState, modifier = Modifier.fillMaxWidth()) {
            item {
                Box(
                    modifier = Modifier.padding(start = 24.dp)
                        .width(160.dp)
                        .height(160.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(Color.Gray)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.shiba_inu),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = "Shiba Inu",
                        modifier = Modifier.align(Alignment.Center),
                        style = typography.h2,
                        color = Color.White
                    )
                }
            }
            item {
                Box(
                    modifier = Modifier.padding(start = 24.dp)
                        .width(160.dp)
                        .height(160.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(Color.Gray)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.chihuahua),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = "Chihuahua",
                        modifier = Modifier.align(Alignment.Center),
                        style = typography.h2,
                        color = Color.White
                    )
                }
            }
            item {
                Box(
                    modifier = Modifier.padding(start = 24.dp, end = 24.dp)
                        .width(160.dp)
                        .height(160.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(Color.Gray)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.poodle),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = "Poodle",
                        modifier = Modifier.align(Alignment.Center),
                        style = typography.h2,
                        color = Color.White
                    )
                }
            }
        }
    }
}