package com.esma.movieapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.esma.movieapp.presentation.home.HomeScreen
import com.esma.movieapp.presentation.movie_detail.MovieDetailScreen
import com.esma.movieapp.presentation.theme.MovieAppTheme
import com.esma.movieapp.presentation.tv_show_detail.TvShowDetailScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.Black) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.route
                    ) {
                        composable(
                            route = Screen.HomeScreen.route
                        ) {
                            HomeScreen(navController)
                        }
                        composable(
                            route = Screen.MovieDetailScreen.route + "/{movieId}"
                        ) {
                            MovieDetailScreen(navController)
                        }
                        composable(
                            route = Screen.TvShowDetailScreen.route + "/{showId}"
                        ) {
                            TvShowDetailScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}