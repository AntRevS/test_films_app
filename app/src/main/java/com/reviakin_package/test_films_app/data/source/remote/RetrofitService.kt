package com.reviakin_package.test_films_app.data.source.remote

import com.reviakin_package.test_films_app.BuildConfig
import com.reviakin_package.test_films_app.domain.model.filmreviews.FilmReviews
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitService {

    @GET("svc/movies/v2/reviews/all.json?api-key=${BuildConfig.API_KEY}")
    fun getReviews() : Single<FilmReviews>
    
}