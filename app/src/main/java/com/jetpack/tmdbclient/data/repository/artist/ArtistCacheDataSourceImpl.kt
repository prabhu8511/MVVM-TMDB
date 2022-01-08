package com.jetpack.tmdbclient.data.repository.artist

import com.jetpack.tmdbclient.data.model.artist.Artist
import com.jetpack.tmdbclient.data.model.movie.Movie

class ArtistCacheDataSourceImpl : ArtistCacheDataSource{

    private var artistList = ArrayList<Artist>()

    override suspend fun saveArtistListToCache(artists: List<Artist>) {
        artistList.clear()
        artistList  = ArrayList(artists)
    }

    override suspend fun getArtistListFromCache(): List<Artist> {
        return artistList
    }
}