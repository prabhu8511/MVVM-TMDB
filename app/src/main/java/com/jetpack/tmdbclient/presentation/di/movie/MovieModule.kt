package com.jetpack.tmdbclient.presentation.di.movie

import com.jetpack.tmdbclient.domain.usecase.GetMoviesUseCase
import com.jetpack.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.jetpack.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}