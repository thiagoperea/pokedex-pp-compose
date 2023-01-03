package com.thiagoperea.pokedexppcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.PokeDetailScreen
import com.thiagoperea.pokedexppcompose.ui.feature.poke_list.PokeListScreen
import com.thiagoperea.pokedexppcompose.ui.theme.PokedexComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexComposeTheme {
                val pokedexNavController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { paddingValues ->

                    NavHost(
                        modifier = Modifier.padding(paddingValues),
                        navController = pokedexNavController,
                        startDestination = AppScreens.pokelist,
                        builder = {
                            composable(
                                route = AppScreens.pokelist,
                                content = {
                                    PokeListScreen(
                                        onNavigateToDetails = { pokeId -> pokedexNavController.navigate(AppScreens.getPokeDetails(pokeId)) }
                                    )
                                }
                            )

                            composable(
                                route = AppScreens.pokeDetails,
                                arguments = listOf(navArgument("id") { type = NavType.IntType }),
                                content = {
                                    PokeDetailScreen(
                                        onNavigateBack = { pokedexNavController.navigateUp() }
                                    )
                                }
                            )
                        }
                    )
                }
            }
        }
    }
}

object AppScreens {

    const val pokelist = "pokelist"
    const val pokeDetails = "pokedetails/{id}"

    fun getPokeDetails(id: Int) = "pokedetails/$id"
}