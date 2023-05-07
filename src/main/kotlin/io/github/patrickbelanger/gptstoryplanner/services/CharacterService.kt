package io.github.patrickbelanger.gptstoryplanner.services

import io.github.patrickbelanger.gptstoryplanner.extensions.toEntity
import io.github.patrickbelanger.gptstoryplanner.extensions.toModel
import io.github.patrickbelanger.gptstoryplanner.extensions.isValid
import io.github.patrickbelanger.gptstoryplanner.models.Character
import io.github.patrickbelanger.gptstoryplanner.repositories.CharacterRepository
import org.springframework.stereotype.Service

@Service
class CharacterService(val characterRepository: CharacterRepository) {

    fun saveCharacter(character: Character): Character {
        if (!character.isValid()) {
            throw NotImplementedError("")
        }
        return characterRepository
                .save(character.toEntity())
                .toModel()
    }
}