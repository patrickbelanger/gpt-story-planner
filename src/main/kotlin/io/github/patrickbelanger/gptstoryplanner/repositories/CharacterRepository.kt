package io.github.patrickbelanger.gptstoryplanner.repositories

import io.github.patrickbelanger.gptstoryplanner.entities.CharacterEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CharacterRepository : JpaRepository<CharacterEntity, Long> {
}