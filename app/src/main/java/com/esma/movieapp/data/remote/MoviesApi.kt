package com.esma.movieapp.data.remote

import com.esma.movieapp.data.remote.dto.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")api_key : String = "0921a11ff74eb51180882534314e79af") : PopularMoviesDto

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key")api_key : String = "0921a11ff74eb51180882534314e79af") : PopularTvShowsDto

    @GET("tv/latest")
    suspend fun getLatestTvShow(@Query("api_key")api_key : String = "0921a11ff74eb51180882534314e79af") : LatestTvShowDto

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") movieId : String, @Query("api_key")api_key : String = "0921a11ff74eb51180882534314e79af") : MovieDetailDto

    @GET("tv/{tv_id}")
    suspend fun getTvShowDetail(@Path("tv_id") tvId : String, @Query("api_key")api_key : String = "0921a11ff74eb51180882534314e79af") : TvShowDetailDto
}