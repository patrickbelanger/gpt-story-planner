package io.github.patrickbelanger.gptstoryplanner.extensions

import io.github.patrickbelanger.gptstoryplanner.entities.CharacterEntity
import io.github.patrickbelanger.gptstoryplanner.models.Character

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
        relationshipWith = this.relationshipWith
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
        relationshipWith = this.relationshipWith
    )
}

fun Character.isValid(): Boolean {
    return (
        (firstName.isNotEmpty()) &&
        (lastName.isNotEmpty())
    )
}