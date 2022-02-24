package com.jetpack.tmdbclient.data.repository.movie

import com.jetpack.tmdbclient.data.model.movie.Movie
import com.jetpack.tmdbclient.domain.repository.MovieRepository

class FakeMovieRepository:MovieRepository {
    private val movies = mutableListOf<Movie>()

    init {
        movies.add(Movie(1, "overview1", 2.5, "date1","releaseDate","title1"))
        movies.add(Movie(2, "overview2", 4.5, "date2","releaseDate","title2"))
    }

    override suspend fun getMovies(): List<Movie> {
        return movies
    }

    override suspend fun updateMovies(): List<Movie> {
        movies.clear()
        movies.add(Movie(3, "overview3", 2.5, "date4","releaseDate","title4"))
        movies.add(Movie(4, "overview4", 4.5, "date5","releaseDate","title5"))
        return movies
    }
}