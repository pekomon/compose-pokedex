package com.example.pekomon.composepokedex.data.network.response.pokemonlist


import com.google.gson.annotations.SerializedName

data class Result(
    val name: String,
    val url: String
)