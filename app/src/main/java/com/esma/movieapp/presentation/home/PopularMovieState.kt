package com.esma.movieapp.presentation.home

import com.esma.movieapp.domain.model.PopularMovie

class PopularMovieState(
    val isLoading: Boolean = false,
    val popularMovies: List<PopularMovie>? = emptyList(),
    val error: String = ""
)