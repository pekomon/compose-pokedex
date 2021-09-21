package com.example.pekomon.composepokedex.extensions

import androidx.compose.ui.graphics.Color
import com.example.pekomon.composepokedex.data.network.response.pokemon.Type
import com.example.pekomon.composepokedex.ui.theme.*
import java.util.*

fun Type.typeColor(): Color {
    return when(type.name.toLowerCase(Locale.ROOT)) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}