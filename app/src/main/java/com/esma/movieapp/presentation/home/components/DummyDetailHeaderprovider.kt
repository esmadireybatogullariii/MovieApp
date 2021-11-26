package com.esma.movieapp.presentation.home.components

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.esma.movieapp.domain.model.DetailHeader

class DummyDetailHeaderprovider : PreviewParameterProvider<DetailHeader> {
    override val values: Sequence<DetailHeader>
        get() = listOf(
            DetailHeader(
                posterPath = "https://static.bershka.net/4/photos2/2021/I/0/1/p/6505/551/800/6505551800_1_1_3.jpg",
                title = "Esma Show",
                voteAverage = 10.00,
                type = "Tv Show"
            )
        ).asSequence()
    override val count: Int
        get() = values.count()
}