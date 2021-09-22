package com.reviakin_package.test_films_app.domain.usecase

import com.reviakin_package.test_films_app.domain.model.filmreviews.FilmReviews
import com.reviakin_package.test_films_app.domain.repository.FilmReviewRepository
import com.reviakin_package.test_films_app.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetAllReviewsUseCase @Inject constructor(
    private val repository: FilmReviewRepository
) : SingleUseCase<FilmReviews>(){

    override fun buildUseCaseSingle(): Single<FilmReviews> {
        return repository.getAll()
    }
}