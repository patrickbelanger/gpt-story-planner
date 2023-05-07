package io.github.patrickbelanger.gptstoryplanner.models

import io.github.patrickbelanger.gptstoryplanner.models.type.Gender
import io.github.patrickbelanger.gptstoryplanner.models.type.Relationship
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
    var relationshipWith: Long,
)
