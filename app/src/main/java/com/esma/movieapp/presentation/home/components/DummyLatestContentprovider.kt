package com.esma.movieapp.presentation.home.components

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.esma.movieapp.domain.model.LatestTvShow

class DummyLatestContentprovider : PreviewParameterProvider<LatestTvShow> {
    override val values: Sequence<LatestTvShow>
        get() = listOf(
            LatestTvShow(
                "https://static.bershka.net/4/photos2/2021/I/0/1/p/6505/551/800/6505551800_1_1_3.jpg",
                "Esma Show",
            )
        ).asSequence()
    override val count: Int
        get() = values.count()
}