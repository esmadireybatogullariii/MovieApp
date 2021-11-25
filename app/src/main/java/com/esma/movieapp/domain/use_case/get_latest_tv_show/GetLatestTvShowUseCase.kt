package com.esma.movieapp.domain.use_case.get_latest_tv_show

import com.esma.movieapp.commons.Resource
import com.esma.movieapp.data.remote.dto.toLatestTvShow
import com.esma.movieapp.domain.model.LatestTvShow
import com.esma.movieapp.domain.repository.MovieApiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetLatestTvShowUseCase @Inject constructor(
    private val repository: MovieApiRepository
){
    operator fun invoke(): Flow<Resource<LatestTvShow>> = flow {
        try {
            emit(Resource.Loading<LatestTvShow>())
            val latestTvShow = repository.getLatestTvShow().toLatestTvShow()
            emit(Resource.Success<LatestTvShow>(latestTvShow))

        } catch(e : HttpException){
            emit(Resource.Error<LatestTvShow>(e.localizedMessage ?: "Error occured"))

        } catch (e: IOException){
            emit(Resource.Error<LatestTvShow>("Check internet connection"))

        }
    }
}
