package com.esma.movieapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.esma.movieapp.presentation.home.HomeScreen
import com.esma.movieapp.presentation.theme.MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme() {
                // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {
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

                        }
                    }
                }
            }
        }
    }