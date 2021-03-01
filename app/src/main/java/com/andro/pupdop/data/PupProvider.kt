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
package com.andro.pupdop.data

import com.andro.pupdop.R
import com.andro.pupdop.ui.module.BreedId
import com.andro.pupdop.ui.module.BreedListModule
import com.andro.pupdop.ui.module.PupId
import com.andro.pupdop.ui.module.PupListModule

object PupProvider {

    private val breeds = listOf(
        BreedListModule(
            id = BreedId(1),
            breed = "shiba inu"
        ),
        BreedListModule(
            id = BreedId(2),
            breed = "chihuahua"
        ),
        BreedListModule(
            id = BreedId(3),
            breed = "poodle"
        ),
        BreedListModule(
            id = BreedId(4),
            breed = "bulldog"
        )
    )

    private val puppies = listOf(
        PupListModule(
            id = PupId(1),
            name = "Challace",
            breed = breeds[2],
            image = R.drawable.challace,
            owner = "Zack Frizz",
            ownerImg = R.drawable.zack,
            location = "Thornton, US"
        ),
        PupListModule(
            id = PupId(2),
            name = "Buffy",
            breed = breeds[3],
            image = R.drawable.buffy,
            owner = "Bennett Jose",
            ownerImg = R.drawable.bennett,
            location = "Washington, US"
        ),
        PupListModule(
            id = PupId(3),
            name = "Doge",
            breed = breeds[0],
            image = R.drawable.doge,
            owner = "Doge",
            ownerImg = R.drawable.dogedaowner,
            location = "Earth"
        ),
        PupListModule(
            id = PupId(4),
            name = "Pancy",
            breed = breeds[1],
            image = R.drawable.pancy,
            owner = "Betty Drew",
            ownerImg = R.drawable.betty,
            location = "LA, US"
        )
    )

    fun getAllPups(): List<PupListModule> = puppies
    fun getPup(pupId: PupId): PupListModule = puppies.first { it.id.value == pupId.value }
}
