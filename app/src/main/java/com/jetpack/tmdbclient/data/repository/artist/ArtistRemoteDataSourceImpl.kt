package com.jetpack.tmdbclient.data.repository.artist

import com.jetpack.tmdbclient.data.api.TMDBService
import com.jetpack.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
) : ArtistRemoteDataSource{
    override suspend fun getArtist(): Response<ArtistList> {
        return tmdbService.getPopularArtist(apiKey)
    }

}