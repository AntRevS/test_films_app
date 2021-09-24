package com.reviakin_package.test_films_app.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.reviakin_package.test_films_app.BuildConfig
import com.reviakin_package.test_films_app.R
import com.reviakin_package.test_films_app.presentation.filmreviews.FilmReviewsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Test_films_app)
        setContentView(R.layout.activity_main)

        navigateToFilmReviewsPage()
    }

    private fun navigateToFilmReviewsPage(){
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.main_container,
                FilmReviewsFragment.newInstance(),
                FilmReviewsFragment.FRAGMENT_NAME
            ).commitAllowingStateLoss()
    }
}