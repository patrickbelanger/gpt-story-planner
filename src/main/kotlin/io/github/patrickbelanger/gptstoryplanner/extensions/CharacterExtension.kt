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

package io.github.patrickbelanger.gptstoryplanner.extensions

import io.github.patrickbelanger.gptstoryplanner.entities.CharacterEntity
import io.github.patrickbelanger.gptstoryplanner.models.Character
import kotlin.reflect.KVisibility
import kotlin.reflect.full.memberProperties

fun CharacterEntity.toModel(): Character {
    return Character(
        id = this.id,
        firstName = this.firstName,
        lastName = this.lastName,
        gender = this.gender,
        genderDescription = this.genderDescription,
        dateOfBirth = this.dateOfBirth,
        profession = this.profession,
        relationship = this.relationship,
        relationshipWith = this.relationshipWith,
        skinColor = this.skinColor
    )
}

fun Character.toEntity(): CharacterEntity {
    return CharacterEntity(
        id = this.id,
        firstName = this.firstName,
        lastName = this.lastName,
        gender = this.gender,
        genderDescription = this.genderDescription,
        dateOfBirth = this.dateOfBirth,
        profession = this.profession,
        relationship = this.relationship,
        relationshipWith = this.relationshipWith,
        skinColor = this.skinColor
    )
}

fun Character.isValid(): Boolean {
    return invalidFields().isEmpty()
}

fun Character.invalidFields(): List<String> {
    return this::class.memberProperties
        .filter {
            Character.REQUIRED_MEMBERS.contains(it.name) &&
            (it.visibility == KVisibility.PUBLIC && it.getter.call(this).toString().isEmpty())
        }
        .map{ it.name }
        .toList()
}