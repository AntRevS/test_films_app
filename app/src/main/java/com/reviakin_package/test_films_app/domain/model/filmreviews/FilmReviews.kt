package com.reviakin_package.test_films_app.domain.model.filmreviews

import com.google.gson.annotations.SerializedName
import com.reviakin_package.test_films_app.domain.model.filmreviews.other.Results

data class FilmReviews(
    @SerializedName("results") var results : List<Results>
)