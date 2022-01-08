package com.jetpack.tmdbclient.presentation.di.core

import com.jetpack.tmdbclient.data.repository.artist.ArtistCacheDataSource
import com.jetpack.tmdbclient.data.repository.artist.ArtistCacheDataSourceImpl
import com.jetpack.tmdbclient.data.repository.movie.MovieCacheDataSource
import com.jetpack.tmdbclient.data.repository.movie.MovieCacheDataSourceImpl
import com.jetpack.tmdbclient.data.repository.tvshow.TvShowCacheDataSource
import com.jetpack.tmdbclient.data.repository.tvshow.TvShowsCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowsCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}