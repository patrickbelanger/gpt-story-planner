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

package io.github.patrickbelanger.gptstoryplanner.controllers

import io.github.patrickbelanger.gptstoryplanner.models.Character
import io.github.patrickbelanger.gptstoryplanner.models.TransactionStatus
import io.github.patrickbelanger.gptstoryplanner.services.CharacterService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/character")
class CharacterController(val characterService: CharacterService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveCharacter(character: Character): TransactionStatus<Character> {
        return characterService.saveCharacter(character)
    }
}