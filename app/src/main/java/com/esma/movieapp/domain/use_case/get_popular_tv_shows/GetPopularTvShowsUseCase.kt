package com.esma.movieapp.domain.use_case.get_popular_tv_shows

import com.esma.movieapp.commons.Resource
import com.esma.movieapp.data.remote.dto.toPopularTvShow
import com.esma.movieapp.domain.model.PopularTvShow
import com.esma.movieapp.domain.repository.MovieApiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPopularTvShowsUseCase @Inject constructor(
    private val repository: MovieApiRepository
){
    operator fun invoke(): Flow<Resource<List<PopularTvShow>>> = flow {
        try {
            emit(Resource.Loading<List<PopularTvShow>>())
            val popularTvShow = repository.getPopularTvShows().results.map { show ->
                show.toPopularTvShow()
            }
            emit(Resource.Success<List<PopularTvShow>>(popularTvShow))

        } catch(e : HttpException){
            emit(Resource.Error<List<PopularTvShow>>(e.localizedMessage ?: "Error occured"))

        } catch (e: IOException){
            emit(Resource.Error<List<PopularTvShow>>("Check internet connection"))

        }
    }
}
