package com.esma.movieapp.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.esma.movieapp.presentation.home.components.LatestContent
import com.esma.movieapp.presentation.home.components.PosterItem
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val movieState = viewModel.movieState.value
    val tvShowState = viewModel.tvShowState.value
    val latestTvShowState = viewModel.latestTvShowState.value
    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxSize()) {

            Row(Modifier.fillMaxWidth()) {
                latestTvShowState.latestTvShow?.let { LatestContent(latestTvShow = it) }
            }
            Row() {
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(movieState.popularMovies ?: emptyList()) { movies ->
                        PosterItem(
                            posterPath = movies.posterPath,
                            id = movies.id,
                            type = movies.type,
                            onItemClick = { id, type ->
                                /*
                    when(type){
                        "Movie" -> {
                            navController.navigate(Screen.MovieDetailScreen.route + "/${id}")

                        }
                        "TvShow" -> {
                            navController.navigate(Screen.TvShowDetailScreen.route + "/${id}")

                        }
                    }*/
                            })

                    }
                }
            }
            Row() {
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(tvShowState.popularTvShows ?: emptyList()) { tvShows ->
                        tvShows.posterPath?.let {
                            PosterItem(
                                posterPath = it,
                                id = tvShows.id,
                                type = tvShows.type,
                                onItemClick = { id, type ->
                                    /*
                                    when(type){
                                        "Movie" -> {
                                            navController.navigate(Screen.MovieDetailScreen.route + "/${id}")

                                        }
                                        "TvShow" -> {
                                            navController.navigate(Screen.TvShowDetailScreen.route + "/${id}")

                                        }
                                    }*/
                                })
                        }

                    }
                }
            }

            }

            if (tvShowState.error.isNotBlank()) {
                Text(
                    text = tvShowState.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .align(Alignment.Center)
                )
            }
            if (tvShowState.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }



