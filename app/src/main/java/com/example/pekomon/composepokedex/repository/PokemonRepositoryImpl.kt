package com.example.pekomon.composepokedex.repository

import com.example.pekomon.composepokedex.data.network.PokemonApi
import com.example.pekomon.composepokedex.data.network.response.pokemon.Pokemon
import com.example.pekomon.composepokedex.data.network.response.pokemonlist.PokemonList
import com.example.pekomon.composepokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi
) : PokemonRepository {

    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error(message = "Something went wrong")
        }
        return Resource.Success(response)
    }

    override suspend fun getPokemon(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemon(pokemonName)
        } catch (e: Exception) {
            return Resource.Error(message = "Something went wrong")
        }
        return Resource.Success(response)
    }

}