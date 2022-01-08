package com.jetpack.tmdbclient.presentation.di.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jetpack.tmdbclient.R
import com.jetpack.tmdbclient.data.model.artist.Artist
import com.jetpack.tmdbclient.data.model.tvshow.TvShow
import com.jetpack.tmdbclient.databinding.ListItemBinding

class TvShowAdapter(): RecyclerView.Adapter<TvShowViewHolder>() {
    private val tvShowList = ArrayList<TvShow>()

    fun setList(shows:List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(shows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return TvShowViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }
}



class TvShowViewHolder(val binding: ListItemBinding):
    RecyclerView.ViewHolder(binding.root){

    fun bind(tvShow: TvShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        val posterURL = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

    }

}