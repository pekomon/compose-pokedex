package com.example.pekomon.composepokedex.extensions

import androidx.compose.ui.graphics.Color
import com.example.pekomon.composepokedex.data.network.response.pokemon.Stat
import com.example.pekomon.composepokedex.ui.theme.*
import java.util.*

fun Stat.toColor(): Color {
    return when(stat.name.lowercase(Locale.ROOT)) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.White
    }
}

fun Stat.toAbbr(): String {
    return when(stat.name.toLowerCase()) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "Spd"
        else -> ""
    }
}