package com.reviakin_package.test_films_app.presentation.filmreviews

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.reviakin_package.test_films_app.R
import com.reviakin_package.test_films_app.databinding.FragmentFilmReviewsBinding
import com.reviakin_package.test_films_app.domain.model.filmreviews.other.Results
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FilmReviewsFragment : Fragment() {

    private lateinit var fragmentFilmReviewsBinding: FragmentFilmReviewsBinding
    private var adapter: FilmReviewsAdapter? = null

    private val viewModel : FilmReviewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = FilmReviewsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentFilmReviewsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_film_reviews, container, false)
        fragmentFilmReviewsBinding.reviewsViewModel = viewModel
        fragmentFilmReviewsBinding.recyclerReviews.adapter = adapter

        lifecycleScope.launch {
            viewModel.loadReviews().distinctUntilChanged().collectLatest {
                adapter?.submitData(it)
            }
        }

        return fragmentFilmReviewsBinding.root
    }


    override fun onDetach() {
        super.onDetach()
        adapter = null
    }

    companion object{

        val FRAGMENT_NAME = FilmReviewsFragment::class.java.simpleName

        fun newInstance() =
            FilmReviewsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}