package com.jetpack.tmdbclient.data.repository.tvshow

import android.util.Log
import com.jetpack.tmdbclient.data.model.artist.Artist
import com.jetpack.tmdbclient.data.model.tvshow.TvShow
import com.jetpack.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowsCacheDataSource: TvShowCacheDataSource
) : TvShowRepository{
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShow = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShow)
        tvShowsCacheDataSource.saveTvShowsToCache(newListOfTvShow)
        return newListOfTvShow
    }

    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if(body!=null){
                tvShowList = body.tvShows
            }
        } catch (e: Exception) {
            Log.i("MyTAG", e.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        } catch (e: Exception) {
            Log.i("MyTAG", e.message.toString())
        }
        return if(tvShowList.isNotEmpty()) tvShowList else {
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
            tvShowList
        }

    }

    suspend fun getTvShowFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowsCacheDataSource.getTvShowsFromCache()
        } catch (e: Exception) {
            Log.i("MyTAG", e.message.toString())
        }
        return if(tvShowList.isNotEmpty()) tvShowList else {
            tvShowList = getTvShowFromDB()
            tvShowsCacheDataSource.saveTvShowsToCache(tvShowList)
            tvShowList
        }

    }
}