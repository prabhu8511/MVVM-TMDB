package com.jetpack.tmdbclient.data.model.tvshow


import com.google.gson.annotations.SerializedName
import com.jetpack.tmdbclient.data.model.tvshow.TvShow

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>,

    )