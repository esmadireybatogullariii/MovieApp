package com.esma.movieapp.data.repository

import com.esma.movieapp.data.remote.MoviesApi
import com.esma.movieapp.data.remote.dto.*
import com.esma.movieapp.domain.repository.MovieApiRepository
import javax.inject.Inject

class MovieApiRepositoryImpl @Inject constructor(
    private val api : MoviesApi) : MovieApiRepository{
    override suspend fun getPopularMovies(): PopularMoviesDto {
        return api.getPopularMovies()
    }

    override suspend fun getPopularTvShows(): PopularTvShowsDto {
        return api.getPopularTvShows()
    }

    override suspend fun getLatestTvShow(): LatestTvShowDto {
        return api.getLatestTvShow()
    }

    override suspend fun getMovieDetail(movieId: String): MovieDetailDto {
        return api.getMovieDetail(movieId)
    }

    override suspend fun getTvShowDetail(tvId: String): TvShowDetailDto {
        return api.getTvShowDetail(tvId)
    }

}