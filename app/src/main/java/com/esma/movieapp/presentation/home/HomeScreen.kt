package com.esma.movieapp.presentation.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.esma.movieapp.presentation.Screen
import com.esma.movieapp.presentation.home.components.LatestContent
import com.esma.movieapp.presentation.home.components.PosterItem

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val movieState = viewModel.movieState.value
    val tvShowState = viewModel.tvShowState.value
    val latestTvShowState = viewModel.latestTvShowState.value

    Box {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .wrapContentHeight()
                .fillMaxWidth()
        ) {

            Row(Modifier.fillMaxWidth()) {
                latestTvShowState.latestTvShow?.let { LatestContent(latestTvShow = it) }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp),
                text = "Popular Movies",
                color = Color.White,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                Modifier
                    .horizontalScroll(rememberScrollState(), true)
                    .wrapContentWidth()

            ) {
                movieState.popularMovies?.forEach {
                    PosterItem(
                        posterPath = it.posterPath,
                        id = it.id,
                        type = it.type,
                        onItemClick = { id, type ->
                            navController.navigate(Screen.MovieDetailScreen.route + "/${id}")
                        })
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp),
                text = "Popular Tv Shows",
                color = Color.White,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                Modifier
                    .horizontalScroll(rememberScrollState(), true)
                    .wrapContentWidth()

            ) {
                tvShowState.popularTvShows?.forEach {
                    PosterItem(
                        posterPath = it.posterPath ?: "",
                        id = it.id,
                        type = it.type,
                        onItemClick = { id, type ->
                            navController.navigate(Screen.TvShowDetailScreen.route + "/${id}")
                        })
                }
            }
        }
        Box(Modifier.align(Alignment.Center)) {
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


}




