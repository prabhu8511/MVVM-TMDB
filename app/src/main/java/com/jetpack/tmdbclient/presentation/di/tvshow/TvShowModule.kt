package com.jetpack.tmdbclient.presentation.di.tvshow

import com.jetpack.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.jetpack.tmdbclient.domain.usecase.UpdateTvShowUseCase
import com.jetpack.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }

}