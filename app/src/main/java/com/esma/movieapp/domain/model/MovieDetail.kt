package com.esma.movieapp.domain.model

data class MovieDetail(
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,

    )

fun MovieDetail.toDetailHeader(): DetailHeader {
    return DetailHeader(
        title = title,
        posterPath = posterPath,
        voteAverage = voteAverage,
        type = "Movie"
    )
}