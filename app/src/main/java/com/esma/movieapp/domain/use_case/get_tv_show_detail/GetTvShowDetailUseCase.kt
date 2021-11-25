package com.esma.movieapp.domain.use_case.get_tv_show_detail

import com.esma.movieapp.commons.Resource
import com.esma.movieapp.data.remote.dto.toTvShowDetail
import com.esma.movieapp.domain.model.TvShowDetail
import com.esma.movieapp.domain.repository.MovieApiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTvShowDetailUseCase @Inject constructor(
    private val repository: MovieApiRepository
){
    operator fun invoke(tvShowId : String): Flow<Resource<TvShowDetail>> = flow {
        try {
            emit(Resource.Loading<TvShowDetail>())
            val tvShowDetail = repository.getTvShowDetail(tvShowId).toTvShowDetail()
            emit(Resource.Success<TvShowDetail>(tvShowDetail))

        } catch(e : HttpException){
            emit(Resource.Error<TvShowDetail>(e.localizedMessage ?: "Error occured"))

        } catch (e: IOException){
            emit(Resource.Error<TvShowDetail>("Check internet connection"))

        }
    }
}
