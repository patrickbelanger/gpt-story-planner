package io.github.patrickbelanger.gptstoryplanner.entities

import io.github.patrickbelanger.gptstoryplanner.models.type.Gender
import io.github.patrickbelanger.gptstoryplanner.models.type.Relationship
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Table
import org.springframework.data.annotation.Id
import java.time.LocalDate

@Entity
@Table(name = "persons")
data class CharacterEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val firstName: String,
    val lastName: String,
    val gender: Gender,
    val genderDescription: String,
    val dateOfBirth: LocalDate,
    val profession: String,
    val relationship: Relationship,
    var relationshipWith: Long,
)