package com.jetpack.tmdbclient.data.repository.tvshow

import com.jetpack.tmdbclient.data.model.artist.Artist
import com.jetpack.tmdbclient.data.model.tvshow.TvShow

class TvShowsCacheDataSourceImpl: TvShowCacheDataSource {

    private var tvShowsList = ArrayList<TvShow>()

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowsList.clear()
        tvShowsList  = ArrayList(tvShows)
    }

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowsList
    }
}