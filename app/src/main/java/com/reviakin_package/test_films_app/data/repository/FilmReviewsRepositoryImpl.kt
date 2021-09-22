package com.reviakin_package.test_films_app.data.repository

import com.reviakin_package.test_films_app.data.source.remote.RetrofitService
import com.reviakin_package.test_films_app.domain.model.filmreviews.FilmReviews
import com.reviakin_package.test_films_app.domain.repository.FilmReviewRepository
import io.reactivex.Single

class FilmReviewsRepositoryImpl(
    private val retrofitService: RetrofitService
) : FilmReviewRepository {

    override fun getAll(): Single<FilmReviews> {
        return retrofitService.getReviews()
    }
}