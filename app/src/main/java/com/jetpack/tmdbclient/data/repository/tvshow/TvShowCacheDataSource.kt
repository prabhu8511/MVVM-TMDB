package com.jetpack.tmdbclient.data.repository.tvshow

import com.jetpack.tmdbclient.data.model.artist.Artist
import com.jetpack.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun saveTvShowsToCache(tvShows:List<TvShow>)
    suspend fun getTvShowsFromCache():List<TvShow>
}