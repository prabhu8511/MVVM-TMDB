package com.jetpack.tmdbclient.data.repository.movie

import com.jetpack.tmdbclient.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun saveMoviesToCache(movies:List<Movie>)
    suspend fun getMoviesFromCache():List<Movie>
}