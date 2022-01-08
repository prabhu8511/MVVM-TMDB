package com.jetpack.tmdbclient.data.repository.artist

import com.jetpack.tmdbclient.data.model.artist.Artist


interface ArtistLocalDataSource {
    suspend fun getArtistListFromDB():List<Artist>
    suspend fun saveArtistListToDB(artists:List<Artist>)
    suspend fun clearAll()
}