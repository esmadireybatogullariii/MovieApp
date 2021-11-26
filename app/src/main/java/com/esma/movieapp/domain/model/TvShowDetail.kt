package com.esma.movieapp.domain.model

data class TvShowDetail(
    val firstAirDate: String,
    val name: String,
    val numberOfEpisodes: Int,
    val numberOfSeasons: Int,
    val overview: String,
    val posterPath: String,
    val voteAverage: Double
)

fun TvShowDetail.toDetailHeader(): DetailHeader {
    return DetailHeader(
        title = name,
        posterPath = posterPath,
        voteAverage = voteAverage,
        type = "TvShow"
    )
}