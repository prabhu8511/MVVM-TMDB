package com.jetpack.tmdbclient.presentation.di.core

import com.jetpack.tmdbclient.data.api.TMDBService
import com.jetpack.tmdbclient.data.repository.artist.ArtistRemoteDataSource
import com.jetpack.tmdbclient.data.repository.artist.ArtistRemoteDataSourceImpl
import com.jetpack.tmdbclient.data.repository.movie.MovieRemoteDataSourceImpl
import com.jetpack.tmdbclient.data.repository.movie.MovieRemoteDatasource
import com.jetpack.tmdbclient.data.repository.tvshow.TvShowRemoteDataSource
import com.jetpack.tmdbclient.data.repository.tvshow.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule (private val apiKey: String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDatasource {
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }


}