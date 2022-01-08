package com.jetpack.tmdbclient.presentation.di.core

import com.jetpack.tmdbclient.data.db.ArtistDao
import com.jetpack.tmdbclient.data.db.MovieDao
import com.jetpack.tmdbclient.data.db.TvShowDao
import com.jetpack.tmdbclient.data.repository.artist.ArtistLocalDataSource
import com.jetpack.tmdbclient.data.repository.artist.ArtistLocalDataSourceImpl
import com.jetpack.tmdbclient.data.repository.movie.MovieLocalDataSource
import com.jetpack.tmdbclient.data.repository.movie.MovieLocalDataSourceImpl
import com.jetpack.tmdbclient.data.repository.tvshow.TvShowLocalDataSource
import com.jetpack.tmdbclient.data.repository.tvshow.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao : ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}