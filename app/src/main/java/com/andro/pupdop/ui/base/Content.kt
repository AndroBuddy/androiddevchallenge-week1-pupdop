package com.andro.pupdop.ui.base

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.andro.pupdop.R
import com.andro.pupdop.ui.component.BreedList
import com.andro.pupdop.ui.component.Greeting
import com.andro.pupdop.ui.component.PuppyList

@Composable
fun Content() {
    val scrollState = rememberLazyListState()
    LazyColumn(
        state = scrollState,
        modifier = Modifier.fillMaxWidth()
    ) {
        item {
            Greeting(
                name = stringResource(id = R.string.user),
                city = stringResource(id = R.string.city),
                state = stringResource(id = R.string.state)
            )
        }
        item { PuppyList() }
        item { BreedList() }
    }
}