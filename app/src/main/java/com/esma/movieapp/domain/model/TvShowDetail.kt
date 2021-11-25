package com.esma.movieapp.domain.model

data class TvShowDetail(val firstAirDate: String,
                        val name: String,
                        val numberOfEpisodes: Int,
                        val numberOfSeasons: Int,
                        val overview: String,
                        val posterPath: String,
                        val voteAverage: Double)

