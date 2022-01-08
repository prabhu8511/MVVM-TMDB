package com.jetpack.tmdbclient.presentation.di.core

import com.jetpack.tmdbclient.data.repository.artist.ArtistCacheDataSource
import com.jetpack.tmdbclient.data.repository.artist.ArtistLocalDataSource
import com.jetpack.tmdbclient.data.repository.artist.ArtistRemoteDataSource
import com.jetpack.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.jetpack.tmdbclient.data.repository.movie.MovieCacheDataSource
import com.jetpack.tmdbclient.data.repository.movie.MovieLocalDataSource
import com.jetpack.tmdbclient.data.repository.movie.MovieRemoteDatasource
import com.jetpack.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.jetpack.tmdbclient.data.repository.tvshow.TvShowCacheDataSource
import com.jetpack.tmdbclient.data.repository.tvshow.TvShowLocalDataSource
import com.jetpack.tmdbclient.data.repository.tvshow.TvShowRemoteDataSource
import com.jetpack.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.jetpack.tmdbclient.domain.repository.ArtistRepository
import com.jetpack.tmdbclient.domain.repository.MovieRepository
import com.jetpack.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistCacheDataSource,
            artistLocalDataSource
        )


    }
}