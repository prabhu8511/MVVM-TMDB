package com.jetpack.tmdbclient.data.model.movie


import com.google.gson.annotations.SerializedName
import com.jetpack.tmdbclient.data.model.movie.Movie

data class MovieList(
    @SerializedName("results")
    val results: List<Movie>
)