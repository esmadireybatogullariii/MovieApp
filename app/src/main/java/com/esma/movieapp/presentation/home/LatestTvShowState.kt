package com.esma.movieapp.presentation.home

import com.esma.movieapp.domain.model.LatestTvShow

class LatestTvShowState(
    val isLoading: Boolean = false,
    val latestTvShow: LatestTvShow? = null,
    val error: String = ""
)