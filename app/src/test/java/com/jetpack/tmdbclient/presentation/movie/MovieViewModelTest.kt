package com.jetpack.tmdbclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.jetpack.tmdbclient.data.model.movie.Movie
import com.jetpack.tmdbclient.data.repository.movie.FakeMovieRepository
import com.jetpack.tmdbclient.domain.usecase.GetMoviesUseCase
import com.jetpack.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.jetpack.tmdbclient.getOrAwaitValue
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieViewModel: MovieViewModel

    @Before
    fun setUp() {
       val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepository)
        movieViewModel = MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
    }

    @Test
    fun getMovies_returnCurrentList(){
         val movies = mutableListOf<Movie>()
         movies.add(Movie(1, "overview1", 2.5, "date1","releaseDate","title1"))
         movies.add(Movie(2, "overview2", 4.5, "date2","releaseDate","title2"))
         val currentList = movieViewModel.getMovies().getOrAwaitValue()
        Truth.assertThat(currentList).isEqualTo(currentList)

    }

    @Test
    fun getUpdatedMovies_returnUpdatedList(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(3, "overview3", 2.5, "date4","releaseDate","title4"))
        movies.add(Movie(4, "overview4", 4.5, "date5","releaseDate","title5"))
        val currentList = movieViewModel.updateMovies().getOrAwaitValue()
        Truth.assertThat(currentList).isEqualTo(movies)

    }
}