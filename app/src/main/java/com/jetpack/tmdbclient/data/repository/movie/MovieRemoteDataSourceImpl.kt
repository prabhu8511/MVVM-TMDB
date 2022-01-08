package com.jetpack.tmdbclient.data.repository.movie

import com.jetpack.tmdbclient.data.api.TMDBService
import com.jetpack.tmdbclient.data.model.movie.MovieList
import com.jetpack.tmdbclient.data.repository.movie.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String ): MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}