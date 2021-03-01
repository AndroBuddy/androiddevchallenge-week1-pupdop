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
package com.andro.pupdop

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.andro.pupdop.ui.extension.getPupIdArgument
import com.andro.pupdop.ui.screen.PupdopDetail
import com.andro.pupdop.ui.screen.PupdopList
import com.andro.pupdop.ui.theme.PupdopTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PupdopTheme {
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
        NavGraph()
    }
}

@Composable
private fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Navigation.PUP_LIST
    ) {
        composable(route = Navigation.PUP_LIST) {
            PupdopList(navController = navController)
        }
        composable(
            route = Navigation.PUP_DETAIL,
            arguments = listOf(
                navArgument(Navigation.PUP_ARG) {
                    type = NavType.IntType
                }
            )
        ) {
            PupdopDetail(
                navController = navController,
                pupId = it.getPupIdArgument(Navigation.PUP_ARG)
            )
        }
    }
}
