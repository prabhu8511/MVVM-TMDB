package com.jetpack.tmdbclient.presentation.di.artist

import com.jetpack.tmdbclient.domain.usecase.GetArtistUseCase
import com.jetpack.tmdbclient.domain.usecase.UpdateArtistUseCase
import com.jetpack.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistUseCase,
        updateArtistsUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }

}