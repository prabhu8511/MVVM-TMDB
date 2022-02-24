package com.jetpack.tmdbclient.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.jetpack.tmdbclient.data.model.movie.Movie
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieDao: MovieDao
    private lateinit var tmdbDatabase: TMDBDatabase

    @Before
    fun setUp() {
        tmdbDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()

        movieDao = tmdbDatabase.movieDao()
    }

    @After
    fun tearDown() {
        tmdbDatabase.close()
    }

    @Test
    fun saveMoviesTest() = runBlocking {
        val movies = listOf(
            Movie(1, "overview1", 2.5, "date1","releaseDate","title1"),
            Movie(2, "overview2", 4.5, "date2","releaseDate","title2"),
            Movie(3, "overview3", 3.5, "date3","releaseDate","title3")
        )

        movieDao.saveMovies(movies)
        val allMovies = movieDao.getMovies()

        Truth.assertThat(allMovies).isEqualTo(movies)
    }

    @Test
    fun deleteMoviesTest() = runBlocking {
        val movies = listOf(
            Movie(1, "overview1", 2.5, "date1","releaseDate","title1"),
            Movie(2, "overview2", 4.5, "date2","releaseDate","title2"),
            Movie(3, "overview3", 3.5, "date3","releaseDate","title3")
        )

        movieDao.saveMovies(movies)
        movieDao.deleteAllMovies()
        val allMovies = movieDao.getMovies()

        Truth.assertThat(allMovies).isEmpty()
    }
}