package com.esma.movieapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class PopularTvShowsDto(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<TvShow>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)