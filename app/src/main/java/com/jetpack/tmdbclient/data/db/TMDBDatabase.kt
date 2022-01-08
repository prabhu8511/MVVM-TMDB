package com.jetpack.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jetpack.tmdbclient.data.model.artist.Artist
import com.jetpack.tmdbclient.data.model.movie.Movie
import com.jetpack.tmdbclient.data.model.tvshow.TvShow

@Database(entities = [Movie::class,Artist::class, TvShow::class],
version = 1,
exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}