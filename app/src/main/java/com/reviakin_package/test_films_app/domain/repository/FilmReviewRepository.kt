package com.reviakin_package.test_films_app.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.reviakin_package.test_films_app.domain.model.filmreviews.FilmReviews
import com.reviakin_package.test_films_app.domain.model.filmreviews.other.Results
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface FilmReviewRepository {

    fun letFilmReviewsFlow(pagingConfig: PagingConfig): Flow<PagingData<Results>>

}