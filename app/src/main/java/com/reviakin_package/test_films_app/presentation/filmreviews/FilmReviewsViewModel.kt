package com.reviakin_package.test_films_app.presentation.filmreviews

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.reviakin_package.test_films_app.domain.model.filmreviews.FilmReviews
import com.reviakin_package.test_films_app.domain.model.filmreviews.other.Results
import com.reviakin_package.test_films_app.domain.repository.FilmReviewRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class FilmReviewsViewModel @Inject constructor(
    private val reviewsRepository: FilmReviewRepository,
    private val defaultConfig: PagingConfig
) : ViewModel() {

    private val TAG = FilmReviewsViewModel::class.java.simpleName

    fun loadReviews() : Flow<PagingData<Results>> {
        return reviewsRepository.letFilmReviewsFlow(defaultConfig)
            .cachedIn(viewModelScope)
    }
}