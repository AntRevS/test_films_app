package com.reviakin_package.test_films_app.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.reviakin_package.test_films_app.domain.usecase.ReviewsPagingSource
import com.reviakin_package.test_films_app.data.source.remote.RetrofitService
import com.reviakin_package.test_films_app.domain.model.filmreviews.other.Results
import com.reviakin_package.test_films_app.domain.repository.FilmReviewRepository
import kotlinx.coroutines.flow.Flow

class FilmReviewsRepositoryImpl(
    private val retrofitService: RetrofitService
) : FilmReviewRepository {

    override fun letFilmReviewsFlow(pagingConfig: PagingConfig): Flow<PagingData<Results>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { ReviewsPagingSource(retrofitService) }
        ).flow
    }


}