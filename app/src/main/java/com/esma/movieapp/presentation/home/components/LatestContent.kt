package com.esma.movieapp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.esma.movieapp.commons.Constants
import com.esma.movieapp.domain.model.LatestTvShow


@Composable
fun LatestContent(
   latestTvShow: LatestTvShow
) {
    Box(modifier = Modifier
        .height(362.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberImagePainter("https://image.tmdb.org/t/p/w500/1BIoJGKbXjdFDAqUEiA2VHqkK1Z.jpg"),
            //Constants.BASE_IMAGE_URL + latestTvShow.posterPath),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Row(Modifier.fillMaxSize() ,horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom
        ) {
            Column() {
                Text(text = latestTvShow.name)
                Text(text = "TV Show")
                Text(text = "Latest Content")
            }
            Button(onClick = {  }) {
                Text(text = "Watch",color = Color.White)
                
            }
        }

    }

}