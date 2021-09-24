package com.reviakin_package.test_films_app.presentation.filmreviews

import androidx.lifecycle.MutableLiveData
import com.reviakin_package.test_films_app.domain.model.filmreviews.other.Results

class FilmReviewViewModel(val results: Results) {

    private val TAG = FilmReviewViewModel::class.java.simpleName
    val reviewData = MutableLiveData<Results>()

    init {
        reviewData.value = results
    }
}