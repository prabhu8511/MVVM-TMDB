package com.jetpack.tmdbclient.data.repository.artist

import android.util.Log
import com.jetpack.tmdbclient.data.model.artist.Artist
import com.jetpack.tmdbclient.data.model.movie.Movie
import com.jetpack.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource
): ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtist = getArtistFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistListToDB(newListOfArtist)
        artistCacheDataSource.saveArtistListToCache(newListOfArtist)
        return newListOfArtist
    }


    suspend fun getArtistFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtist()
            val body = response.body()
            if(body!=null){
                artistList = body.people
            }
        } catch (e: Exception) {
            Log.i("MyTAG", e.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistListFromDB()
        } catch (e: Exception) {
            Log.i("MyTAG", e.message.toString())
        }
        return if(artistList.isNotEmpty()) artistList else {
            artistList = getArtistFromAPI()
            artistLocalDataSource.saveArtistListToDB(artistList)
            artistList
        }

    }

    suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistListFromCache()
        } catch (e: Exception) {
            Log.i("MyTAG", e.message.toString())
        }
        return if(artistList.isNotEmpty()) artistList else {
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistListToCache(artistList)
            artistList
        }

    }
}