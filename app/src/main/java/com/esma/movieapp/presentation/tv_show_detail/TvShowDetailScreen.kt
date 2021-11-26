package com.esma.movieapp.presentation.tv_show_detail

import androidx.compose.foundation.background
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
import com.esma.movieapp.presentation.home.components.DetailHeader
import com.esma.movieapp.utils.formatDateBetweenPatterns

@Composable
fun TvShowDetailScreen(
    navController: NavController,
    viewModel: TvShowDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .wrapContentHeight()
                .fillMaxWidth()
        ) {

            Row(Modifier.fillMaxWidth()) {
                state.tvShow?.let {
                    DetailHeader(detailHeader = state.detailHeader, onClose = {
                        navController.navigate(Screen.HomeScreen.route)
                    })
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "Seasons", color = Color.Gray, fontSize = 14.sp)
                    Text(
                        text = state.tvShow?.numberOfSeasons.toString(),
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
                Column {
                    Text(text = "Total Episodes", color = Color.Gray, fontSize = 14.sp)
                    Text(
                        text = state.tvShow?.numberOfEpisodes.toString(),
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp),
                text = "First Air Date",
                color = Color.Gray,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp),
                text = state.tvShow?.firstAirDate?.formatDateBetweenPatterns(
                    "yyyy-MM-dd",
                    "dd.MM.yyyy"
                ) ?: "",
                color = Color.White,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp),
                text = "Description",
                color = Color.Gray,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp),
                text = state.tvShow?.overview ?: "",
                color = Color.White,
                fontSize = 14.sp
            )

            Box {
                if (state.error.isNotBlank()) {
                    Text(
                        text = state.error,
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                            .align(Alignment.Center)
                    )
                }
                if (state.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
        }


    }
}




