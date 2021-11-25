package com.esma.movieapp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.esma.movieapp.commons.Constants

@Composable
fun PosterItem(
    posterPath: String,
    id: Int,
    type: String,
    onItemClick: (id: Int, type: String) -> Unit

) {
    Column(modifier = Modifier
        .height(225.dp)
        .width(150.dp)
        .clickable { onItemClick(id, type) }) {
        Image(
            painter = rememberImagePainter(Constants.BASE_IMAGE_URL + posterPath),
            contentDescription = null,
        )

    }

}