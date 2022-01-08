package com.jetpack.tmdbclient.data.repository.tvshow

import com.jetpack.tmdbclient.data.model.artist.ArtistList
import com.jetpack.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}
