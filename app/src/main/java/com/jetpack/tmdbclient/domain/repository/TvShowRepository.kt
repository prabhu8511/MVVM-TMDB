package com.jetpack.tmdbclient.domain.repository

import com.jetpack.tmdbclient.data.model.artist.Artist
import com.jetpack.tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}