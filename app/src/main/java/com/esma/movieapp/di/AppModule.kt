package com.esma.movieapp.di

import com.esma.movieapp.commons.Constants
import com.esma.movieapp.data.remote.MoviesApi
import com.esma.movieapp.data.repository.MovieApiRepositoryImpl
import com.esma.movieapp.domain.repository.MovieApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMoviesApi(): MoviesApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(MoviesApi::class.java)
    }
    @Provides
    @Singleton
    fun provideMoviesRepository(api : MoviesApi): MovieApiRepository {
        return MovieApiRepositoryImpl(api)
    }

}