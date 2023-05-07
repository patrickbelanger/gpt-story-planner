package io.github.patrickbelanger.gptstoryplanner.controllers

import io.github.patrickbelanger.gptstoryplanner.models.Character
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
    fun saveCharacter(character: Character): Character {
        return characterService.saveCharacter(character)
    }
}