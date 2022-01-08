package com.jetpack.tmdbclient.data.repository.artist

import com.jetpack.tmdbclient.data.model.artist.Artist
import com.jetpack.tmdbclient.data.model.movie.Movie

interface ArtistCacheDataSource {

    suspend fun saveArtistListToCache(artists:List<Artist>)
    suspend fun getArtistListFromCache():List<Artist>
}