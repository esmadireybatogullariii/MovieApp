package com.esma.movieapp.presentation.home

import com.esma.movieapp.domain.model.LatestTvShow
import com.esma.movieapp.domain.model.PopularMovie
import com.esma.movieapp.domain.model.PopularTvShow
import com.esma.movieapp.domain.model.TvShowDetail

class PopularMovieState(
    val isLoading: Boolean = false,
    val popularMovies: List<PopularMovie>? = emptyList(),
    val error: String = ""
)