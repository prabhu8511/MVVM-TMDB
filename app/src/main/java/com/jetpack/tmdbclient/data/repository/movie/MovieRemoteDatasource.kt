package com.jetpack.tmdbclient.data.repository.movie

import com.jetpack.tmdbclient.data.model.movie.Movie
import com.jetpack.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {

    suspend fun getMovies():Response<MovieList>
}