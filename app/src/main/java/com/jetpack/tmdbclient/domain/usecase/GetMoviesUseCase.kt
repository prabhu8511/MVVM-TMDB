package com.jetpack.tmdbclient.domain.usecase

import com.jetpack.tmdbclient.data.model.movie.Movie
import com.jetpack.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>? = movieRepository.getMovies()

}