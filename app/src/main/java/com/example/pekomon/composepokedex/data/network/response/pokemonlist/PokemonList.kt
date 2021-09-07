package com.example.pekomon.composepokedex.data.network.response.pokemonlist


import com.google.gson.annotations.SerializedName

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)