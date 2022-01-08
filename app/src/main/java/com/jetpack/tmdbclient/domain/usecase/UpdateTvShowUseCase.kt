package com.jetpack.tmdbclient.domain.usecase

import com.jetpack.tmdbclient.data.model.tvshow.TvShow
import com.jetpack.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowUseCase (private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.updateTvShows()
}