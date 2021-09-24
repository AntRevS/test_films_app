package com.reviakin_package.test_films_app.presentation.filmreviews

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.reviakin_package.test_films_app.R
import com.reviakin_package.test_films_app.databinding.HolderFilmReviewBinding
import com.reviakin_package.test_films_app.domain.model.filmreviews.other.Results
import com.squareup.picasso.Picasso

internal class FilmReviewsAdapter : PagingDataAdapter<Results, RecyclerView.ViewHolder>(REPO_COMPARATOR) {

    companion object{
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Results>(){
            override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean =
                oldItem == newItem
        }
    }

    private val TAG = FilmReviewsAdapter::class.java.simpleName
    private val reviews : MutableList<Results> = ArrayList()
    private val picasso = Picasso.get()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderReviewsBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.holder_film_review, parent, false
        )
        return FilmReviewsViewHolder(holderReviewsBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FilmReviewsViewHolder).onBind(getItem(position)!!)
    }

    inner class FilmReviewsViewHolder(private val dataBinding: ViewDataBinding) : RecyclerView.ViewHolder(dataBinding.root){

        fun onBind(results: Results){
            val holderReviewBinding = dataBinding as HolderFilmReviewBinding
            val reviewViewModel = FilmReviewViewModel(results)
            holderReviewBinding.filmReviewViewModel = reviewViewModel

            picasso.load(results.multimedia.src).into(holderReviewBinding.imageFilm)
        }
    }
}