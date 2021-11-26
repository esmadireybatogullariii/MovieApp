package com.esma.movieapp.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esma.movieapp.commons.Resource
import com.esma.movieapp.domain.use_case.get_latest_tv_show.GetLatestTvShowUseCase
import com.esma.movieapp.domain.use_case.get_popular_movies.GetPopularMoviesUseCase
import com.esma.movieapp.domain.use_case.get_popular_tv_shows.GetPopularTvShowsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel

class HomeViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getPopularTvShowsUseCase: GetPopularTvShowsUseCase,
    private val getLatestTvShowUseCase: GetLatestTvShowUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _movieState = mutableStateOf(PopularMovieState())
    val movieState: State<PopularMovieState> = _movieState
    private val _tvShowState = mutableStateOf(PopularTvShowState())
    val tvShowState: State<PopularTvShowState> = _tvShowState
    private val _latestTvShowState = mutableStateOf(LatestTvShowState())
    val latestTvShowState: State<LatestTvShowState> = _latestTvShowState

    init {
        getPopularTvShows()
        getPopularMovies()
        getLatestTvShow()
    }

    private fun getPopularMovies() {
        getPopularMoviesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _movieState.value = PopularMovieState(popularMovies = result.data)

                }
                is Resource.Error -> {
                    _movieState.value =
                        PopularMovieState(error = result.message ?: "İçerik Yüklenemedi")

                }
                is Resource.Loading -> {
                    _movieState.value = PopularMovieState(isLoading = true)

                }
            }

        }.launchIn(viewModelScope)
    }

    private fun getPopularTvShows() {
        getPopularTvShowsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _tvShowState.value = PopularTvShowState(popularTvShows = result.data)

                }
                is Resource.Error -> {
                    _tvShowState.value =
                        PopularTvShowState(error = result.message ?: "İçerik Yüklenemedi")

                }
                is Resource.Loading -> {
                    _tvShowState.value = PopularTvShowState(isLoading = true)

                }
            }

        }.launchIn(viewModelScope)
    }

    private fun getLatestTvShow() {
        getLatestTvShowUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _latestTvShowState.value = LatestTvShowState(latestTvShow = result.data)

                }
                is Resource.Error -> {
                    _latestTvShowState.value =
                        LatestTvShowState(error = result.message ?: "İçerik Yüklenemedi")

                }
                is Resource.Loading -> {
                    _latestTvShowState.value = LatestTvShowState(isLoading = true)

                }
            }

        }.launchIn(viewModelScope)
    }
}