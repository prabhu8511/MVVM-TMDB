package com.jetpack.tmdbclient.data.repository.artist

import com.jetpack.tmdbclient.data.db.ArtistDao
import com.jetpack.tmdbclient.data.model.artist.Artist
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistListFromDB(): List<Artist> {
        return artistDao.getArtistList()
    }

    override suspend fun saveArtistListToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtistList(artists)
        }

    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtist()
        }

    }
}