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

package io.github.patrickbelanger.gptstoryplanner.mocks

import io.github.patrickbelanger.gptstoryplanner.models.Character
import io.github.patrickbelanger.gptstoryplanner.models.TransactionStatus
import io.github.patrickbelanger.gptstoryplanner.models.type.Gender
import io.github.patrickbelanger.gptstoryplanner.models.type.Relationship
import io.github.patrickbelanger.gptstoryplanner.models.type.SkinColor
import org.springframework.http.HttpStatus
import java.time.LocalDate

class TransactionStatusCharacterMocks {
    companion object {
        fun validTransactionStatusCharacter(): TransactionStatus<Character> {
            return TransactionStatus(
                response = Character(
                    id = 1L,
                    firstName = "Maria",
                    lastName = "Rodriguez",
                    gender = Gender.FEMALE,
                    genderDescription = "",
                    dateOfBirth = LocalDate.of(1981, 1, 1),
                    profession = "Architect",
                    relationship = Relationship.MARRIED,
                    relationshipWith = 2L,
                    skinColor = SkinColor.IVORY
                ),
                httpStatus = HttpStatus.OK,
                errorMessage = null,
                errorFields = mutableListOf()
            )
        }

        fun invalidTransactionStatusCharacter(): TransactionStatus<Character> {
            return TransactionStatus(
                response = Character(
                    id = 1L,
                    firstName = "",
                    lastName = "",
                    gender = Gender.MALE,
                    genderDescription = "",
                    dateOfBirth = LocalDate.of(1981, 1, 1),
                    profession = "Architect",
                    relationship = Relationship.MARRIED,
                    relationshipWith = 1L,
                    skinColor = SkinColor.IVORY
                ),
                httpStatus = HttpStatus.BAD_REQUEST,
                errorMessage = "Missing required field(s)",
                errorFields = mutableListOf("firstName","lastName")
            )
        }
    }
}