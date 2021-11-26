package com.esma.movieapp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.esma.movieapp.commons.Constants
import com.esma.movieapp.domain.model.LatestTvShow

@Preview
@Composable
fun LatestContent(
    @PreviewParameter(DummyLatestContentprovider::class) latestTvShow: LatestTvShow
) {
    Box(
        modifier = Modifier
            .height(362.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberImagePainter(Constants.BASE_IMAGE_URL + latestTvShow.posterPath),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Row(
            Modifier
                .align(Alignment.BottomCenter)
                .height(90.dp)
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        )
                    )
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier
                    .padding(16.dp, 0.dp, 0.dp, 0.dp)
                    .fillMaxWidth(.6f)
            ) {
                Text(text = latestTvShow.name, color = Color.White, fontSize = 18.sp)
                Text(text = "TV Show", color = Color.Gray, fontSize = 16.sp)
                Text(text = "Latest Content", color = Color.Red, fontSize = 12.sp)
            }
            Button(modifier = Modifier
                .padding(16.dp)
                .width(92.dp), onClick = {}, content = {
                Text(text = "Watch")
            }, shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
            )


        }

    }

}