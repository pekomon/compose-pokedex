package com.example.pekomon.composepokedex.pokemondetail

import androidx.lifecycle.ViewModel
import com.example.pekomon.composepokedex.data.network.response.pokemon.Pokemon
import com.example.pekomon.composepokedex.repository.PokemonRepository
import com.example.pekomon.composepokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    suspend fun getPokemonInfo(
        pokemonName: String
    ): Resource<Pokemon> {
        return repository.getPokemon(pokemonName = pokemonName)
    }
}