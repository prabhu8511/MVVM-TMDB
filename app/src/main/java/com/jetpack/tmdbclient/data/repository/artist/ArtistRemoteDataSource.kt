package com.jetpack.tmdbclient.data.repository.artist

import com.jetpack.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtist(): Response<ArtistList>
}