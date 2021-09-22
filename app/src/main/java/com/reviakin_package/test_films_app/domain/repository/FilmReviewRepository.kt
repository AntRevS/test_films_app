package com.reviakin_package.test_films_app.domain.repository

import com.reviakin_package.test_films_app.domain.model.filmreviews.FilmReviews
import io.reactivex.Single

interface FilmReviewRepository {

    fun getAll() : Single<FilmReviews>

}