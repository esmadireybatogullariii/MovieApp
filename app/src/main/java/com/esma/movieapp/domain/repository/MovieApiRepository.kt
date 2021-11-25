package com.esma.movieapp.domain.repository

import com.esma.movieapp.data.remote.dto.*

interface MovieApiRepository {

        suspend fun getPopularMovies() : PopularMoviesDto

        suspend fun getPopularTvShows() : PopularTvShowsDto

        suspend fun getLatestTvShow() : LatestTvShowDto

        suspend fun getMovieDetail(movieId : String) : MovieDetailDto

        suspend fun getTvShowDetail(tvId : String) : TvShowDetailDto
}