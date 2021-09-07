package com.example.pekomon.composepokedex.data.network

import com.example.pekomon.composepokedex.data.network.response.pokemon.Pokemon
import com.example.pekomon.composepokedex.data.network.response.pokemonlist.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemon(
        @Path("name") name: String
    ): Pokemon
}