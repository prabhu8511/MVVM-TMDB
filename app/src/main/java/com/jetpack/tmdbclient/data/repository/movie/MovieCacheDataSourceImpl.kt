package com.jetpack.tmdbclient.data.repository.movie

import com.jetpack.tmdbclient.data.model.movie.Movie
import com.jetpack.tmdbclient.data.repository.movie.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList  = ArrayList(movies)
    }

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }
}