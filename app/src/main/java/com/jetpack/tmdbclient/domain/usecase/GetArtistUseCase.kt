package com.jetpack.tmdbclient.domain.usecase

import com.jetpack.tmdbclient.data.model.artist.Artist
import com.jetpack.tmdbclient.domain.repository.ArtistRepository

class GetArtistUseCase (private val artistRepository: ArtistRepository){

    suspend fun execute():List<Artist>? = artistRepository.getArtists()
}