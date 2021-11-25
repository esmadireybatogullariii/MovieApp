package com.esma.movieapp.presentation.tv_show_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esma.movieapp.commons.Constants
import com.esma.movieapp.commons.Resource
import com.esma.movieapp.domain.model.TvShowDetail
import com.esma.movieapp.domain.use_case.get_movie_detail.GetMovieDetailUseCase
import com.esma.movieapp.domain.use_case.get_tv_show_detail.GetTvShowDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel

class TvShowDetailViewModel @Inject constructor(
    private val getTvShowDetailUseCase: GetTvShowDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(TvShowDetailState())
    val state: State<TvShowDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_TV_SHOW_ID)?.let { tvShowId ->
            getMovieDetail(tvShowId)

        }
    }

    private fun getMovieDetail(tvShowId: String) {
        getTvShowDetailUseCase(tvShowId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = TvShowDetailState(tvShow = result.data)

                }
                is Resource.Error -> {
                    _state.value =
                        TvShowDetailState(error = result.message ?: "Unexpected error occured")

                }
                is Resource.Loading -> {
                    _state.value = TvShowDetailState(isLoading = true)

                }
            }

        }.launchIn(viewModelScope)
    }

}