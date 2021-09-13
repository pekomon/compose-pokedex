package com.example.pekomon.composepokedex.di

import com.example.pekomon.composepokedex.data.network.PokemonApi
import com.example.pekomon.composepokedex.repository.PokemonRepository
import com.example.pekomon.composepokedex.repository.PokemonRepositoryImpl
import com.example.pekomon.composepokedex.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokemonApi
    ) : PokemonRepository {
        return PokemonRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun providePokemonApi(): PokemonApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokemonApi::class.java)
    }
}