package com.jetpack.tmdbclient.presentation.di

import com.jetpack.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.jetpack.tmdbclient.presentation.di.movie.MovieSubComponent
import com.jetpack.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}