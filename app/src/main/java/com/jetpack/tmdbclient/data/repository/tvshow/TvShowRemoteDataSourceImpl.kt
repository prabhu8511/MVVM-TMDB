package com.jetpack.tmdbclient.data.repository.tvshow

import com.jetpack.tmdbclient.data.api.TMDBService
import com.jetpack.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}