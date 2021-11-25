package com.esma.movieapp.presentation.tv_show_detail

import com.esma.movieapp.domain.model.TvShowDetail

data class TvShowDetailState(val isLoading : Boolean =false,
                             val tvShow: TvShowDetail?= null,
                             val error: String = "")
