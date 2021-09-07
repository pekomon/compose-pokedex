package com.example.pekomon.composepokedex.repository

import com.example.pekomon.composepokedex.data.network.response.pokemon.Pokemon
import com.example.pekomon.composepokedex.data.network.response.pokemonlist.PokemonList
import com.example.pekomon.composepokedex.util.Resource

interface PokemonRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList>
    suspend fun getPokemon(pokemonName: String): Resource<Pokemon>
}