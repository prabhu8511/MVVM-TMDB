package com.jetpack.tmdbclient.data.model.artist


import com.google.gson.annotations.SerializedName
import com.jetpack.tmdbclient.data.model.artist.Artist

data class ArtistList(
    @SerializedName("results")
    val people: List<Artist>

)