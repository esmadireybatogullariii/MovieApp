package com.esma.movieapp.presentation.home

import com.esma.movieapp.domain.model.PopularTvShow

class PopularTvShowState(
    val isLoading: Boolean = false,
    val popularTvShows: List<PopularTvShow>? = emptyList(),
    val error: String = ""
)