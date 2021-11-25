package com.esma.movieapp.presentation.home

import com.esma.movieapp.domain.model.LatestTvShow
import com.esma.movieapp.domain.model.PopularMovie
import com.esma.movieapp.domain.model.PopularTvShow
import com.esma.movieapp.domain.model.TvShowDetail

class HomeState(
    val isLoading: Boolean = false,
    val popularTvShows: List<PopularTvShow>? = emptyList(),
    val popularMovies: List<PopularMovie>? = emptyList(),
    val latestTvShow: LatestTvShow? = null,
    val error: String = ""
)