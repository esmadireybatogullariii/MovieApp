package com.esma.movieapp.domain.use_case.get_popular_movies

import com.esma.movieapp.commons.Resource
import com.esma.movieapp.data.remote.dto.toPopularMovie
import com.esma.movieapp.domain.model.PopularMovie
import com.esma.movieapp.domain.repository.MovieApiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MovieApiRepository
){
    operator fun invoke(): Flow<Resource<List<PopularMovie>>> = flow {
        try {
            emit(Resource.Loading<List<PopularMovie>>())
            val popularMovie = repository.getPopularMovies().results.map { movie ->
                movie.toPopularMovie()
            }
            emit(Resource.Success<List<PopularMovie>>(popularMovie))

        } catch(e : HttpException){
            emit(Resource.Error<List<PopularMovie>>(e.localizedMessage ?: "Error occured"))

        } catch (e: IOException){
            emit(Resource.Error<List<PopularMovie>>("Check internet connection"))

        }
    }
}
