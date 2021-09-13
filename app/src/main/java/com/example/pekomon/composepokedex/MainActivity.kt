package com.example.pekomon.composepokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.pekomon.composepokedex.pokemonlist.PokemonListScreen
import com.example.pekomon.composepokedex.ui.navigation.Destinations
import com.example.pekomon.composepokedex.ui.navigation.NavArguments
import com.example.pekomon.composepokedex.ui.theme.ComposePokedexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Destinations.DESTINATION_POKEMON_LIST
                    ) {
                        composable(route = Destinations.DESTINATION_POKEMON_LIST) {
                            // Composables of pokemon list screen
                            PokemonListScreen(navController = navController)
                        }
                        composable(
                            route = "${Destinations.DESTINATION_POKEMON_DETAILS}/{dominantColor}/{pokemonName}",
                            arguments = listOf(
                                navArgument(name = NavArguments.ARG_DOMINANT_COLOR) {
                                    type = NavType.IntType
                                },
                                navArgument(name = NavArguments.ARG_POKEMON_NAME) {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            val dominantColor = remember {
                                val color = it.arguments?.getInt(NavArguments.ARG_DOMINANT_COLOR)
                                color?.let { Color(it) } ?: Color.White
                            }
                            val pokemonName = remember {
                                it.arguments?.getString(NavArguments.ARG_POKEMON_NAME)
                            }
                            // Composables of pokemon details screen
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePokedexTheme {
        //Greeting("Android")
    }
}