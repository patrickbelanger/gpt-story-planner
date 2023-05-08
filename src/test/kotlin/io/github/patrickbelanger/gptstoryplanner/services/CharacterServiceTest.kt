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

package io.github.patrickbelanger.gptstoryplanner.services

import io.github.patrickbelanger.gptstoryplanner.extensions.toEntity
import io.github.patrickbelanger.gptstoryplanner.mocks.CharacterEntityMocks
import io.github.patrickbelanger.gptstoryplanner.mocks.CharacterMocks
import io.github.patrickbelanger.gptstoryplanner.mocks.TransactionStatusCharacterMocks
import io.github.patrickbelanger.gptstoryplanner.models.Character
import io.github.patrickbelanger.gptstoryplanner.repositories.CharacterRepository
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
class CharacterServiceTest {

    @MockK
    private lateinit var characterService: CharacterService

    @MockK
    private lateinit var characterRepository: CharacterRepository
    
    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        characterService = CharacterService(characterRepository)
    }

    @Test
    fun `should be able to save a character and get the character back embedded into transaction status object with HttpStatus OK`() {
        // Given
        val character = CharacterMocks.validCharacter()
        every { characterRepository.save(character.toEntity()) } returns CharacterEntityMocks.validCharacter()

        // When
        val result = characterService.saveCharacter(character)

        // Then
        assert(result.response == character)
        assert(result.httpStatus == HttpStatus.OK)
        assert(result == TransactionStatusCharacterMocks.validTransactionStatusCharacter())
    }

    @Test
    fun `should return an invalid character with transaction status object with HttpStatus BAD REQUEST and missing fields`() {
        // Given
        val character = CharacterMocks.invalidCharacter()
        every { characterRepository.save(character.toEntity()) } returns CharacterEntityMocks.invalidCharacter()

        // When
        val result = characterService.saveCharacter(character)

        // Then
        assert(result.response == character)
        assert(result.httpStatus == HttpStatus.BAD_REQUEST)
        assert(result.errorFields.size == 2)
        assert(result.errorFields.containsAll(Character.REQUIRED_MEMBERS))
        assert(result == TransactionStatusCharacterMocks.invalidTransactionStatusCharacter())
    }

    @AfterEach
    fun tearDown() {
        clearAllMocks()
    }
}