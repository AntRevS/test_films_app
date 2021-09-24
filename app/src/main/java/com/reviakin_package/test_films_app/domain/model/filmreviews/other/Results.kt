package com.reviakin_package.test_films_app.domain.model.filmreviews.other

import com.google.gson.annotations.SerializedName

data class Results (
    @SerializedName("display_title") var displayTitle : String,
    @SerializedName("multimedia") var multimedia : Multimedia,
    @SerializedName("summary_short") var summaryShort : String
)