package com.jetpack.tmdbclient.domain.usecase

import com.jetpack.tmdbclient.data.model.artist.Artist
import com.jetpack.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistUseCase (private val artistRepository: ArtistRepository){

    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}