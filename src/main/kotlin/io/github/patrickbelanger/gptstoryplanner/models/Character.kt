// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package io.github.patrickbelanger.gptstoryplanner.models

import io.github.patrickbelanger.gptstoryplanner.models.type.Gender
import io.github.patrickbelanger.gptstoryplanner.models.type.Relationship
import io.github.patrickbelanger.gptstoryplanner.models.type.SkinColor
import java.time.LocalDate

data class Character(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val gender: Gender,
    val genderDescription: String,
    val dateOfBirth: LocalDate,
    val profession: String,
    val relationship: Relationship,
    val relationshipWith: Long,
    val skinColor: SkinColor
) {
    companion object {
        val REQUIRED_MEMBERS = listOf(
            "firstName",
            "lastName"
        )
    }
}
