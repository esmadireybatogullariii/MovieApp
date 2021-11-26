package com.esma.movieapp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.esma.movieapp.commons.Constants
import com.esma.movieapp.domain.model.DetailHeader
import com.esma.movieapp.utils.toColor

@Preview
@Composable
fun DetailHeader(
    @PreviewParameter(DummyDetailHeaderprovider::class) detailHeader: DetailHeader?,
    onClose: (() -> Unit)? = null
) {
    Box(
        modifier = Modifier
            .height(362.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberImagePainter(Constants.BASE_IMAGE_URL + detailHeader?.posterPath),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Box(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopEnd)
                .clickable {
                    onClose?.invoke()
                }
        ) {
            Box(
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .clip(CircleShape)
                    .background(color = Color.Black)
                    .align(Alignment.Center)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "X",
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }

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
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                Modifier
                    .padding(16.dp, 0.dp, 0.dp, 0.dp)
                    .fillMaxWidth(.6f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Box(
                        Modifier
                            .width(30.dp)
                            .height(30.dp)
                            .clip(CircleShape)
                            .background(color = detailHeader?.voteAverage?.toColor() ?: Color.Blue)
                    ) {
                        Box(
                            modifier = Modifier
                                .width(28.dp)
                                .height(28.dp)
                                .clip(CircleShape)
                                .background(color = Color.Black)
                                .align(Alignment.Center)
                        ) {
                            Text(
                                modifier = Modifier.align(Alignment.Center),
                                text = detailHeader?.voteAverage?.toString() ?: "",
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp
                            )
                        }

                    }
                }
                Column(
                    Modifier.padding(16.dp, 0.dp, 0.dp, 0.dp)
                ) {
                    Text(text = detailHeader?.title ?: "", color = Color.White, fontSize = 18.sp)
                    Text(text = detailHeader?.type ?: "", color = Color.Gray, fontSize = 14.sp)
                }
            }
            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .width(92.dp),
                onClick = {},
                content = {
                    Text(text = "Watch")
                },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
            )

        }

    }

}