package com.reviakin_package.test_films_app.data.source.remote

import com.reviakin_package.test_films_app.BuildConfig
import com.reviakin_package.test_films_app.domain.model.filmreviews.FilmReviews
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("svc/movies/v2/reviews/all.json?api-key=${BuildConfig.API_KEY}")
    suspend fun getReviews(@Query("offset") id: Int) : FilmReviews

}