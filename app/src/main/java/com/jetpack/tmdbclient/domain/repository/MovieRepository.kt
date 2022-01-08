package com.jetpack.tmdbclient.domain.repository

import com.jetpack.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies() : List<Movie>?
}