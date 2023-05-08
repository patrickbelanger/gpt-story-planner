package io.github.patrickbelanger.gptstoryplanner.models.type

enum class SkinColor(val skinTone: String, val skinColor: String, val hexValue: String) {
    IVORY("Cool", "Ivory", "#FFFFF0"),
    FAIR("Cool", "Fair", "#F0D9C8"),
    LIGHT("Warm", "Light", "#E0C9A7"),
    MEDIUM_LIGHT("Neutral", "Medium Light", "#C6A48B"),
    MEDIUM("Warm", "Medium", "#B38D72"),
    MEDIUM_DARK("Neutral", "Medium Dark", "#7E5E4B"),
    DARK("Cool", "Dark", "#624536"),
    DEEP_DARK("Neutral", "Deep Dark", "#3B2E23")
}