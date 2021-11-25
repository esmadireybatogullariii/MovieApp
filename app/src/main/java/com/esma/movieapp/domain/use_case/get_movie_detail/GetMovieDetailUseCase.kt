package com.esma.movieapp.domain.use_case.get_movie_detail

import com.esma.movieapp.commons.Resource
import com.esma.movieapp.data.remote.dto.toMovieDetail
import com.esma.movieapp.domain.model.MovieDetail
import com.esma.movieapp.domain.repository.MovieApiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val repository: MovieApiRepository
){
    operator fun invoke(movieId : String): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading<MovieDetail>())
            val movieDetail = repository.getMovieDetail(movieId).toMovieDetail()
            emit(Resource.Success<MovieDetail>(movieDetail))

        } catch(e : HttpException){
            emit(Resource.Error<MovieDetail>(e.localizedMessage ?: "Error occured"))

        } catch (e: IOException){
            emit(Resource.Error<MovieDetail>("Check internet connection"))

        }
    }
}
