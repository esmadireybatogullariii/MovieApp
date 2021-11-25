package com.esma.movieapp.presentation

sealed class Screen(val route : String){
    object HomeScreen : Screen("home_screen")
    object MovieDetailScreen : Screen("movie_detail_screen")
    object TvShowDetailScreen : Screen("tv_show_detail_screen")
}
