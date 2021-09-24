package com.reviakin_package.test_films_app.di

import androidx.paging.PagingConfig
import com.google.gson.Gson
import com.reviakin_package.test_films_app.data.repository.FilmReviewsRepositoryImpl
import com.reviakin_package.test_films_app.data.source.remote.RetrofitService
import com.reviakin_package.test_films_app.domain.repository.FilmReviewRepository
import com.reviakin_package.test_films_app.utils.Constants
import com.reviakin_package.test_films_app.utils.Constants.BASE_URL
import com.reviakin_package.test_films_app.utils.Constants.DEFAULT_PAGE_SIZE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory
    ) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideGson() : Gson{
        return Gson()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory() : GsonConverterFactory{
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit) : RetrofitService{
        return retrofit.create(RetrofitService::class.java)
    }

    @Provides
    @Singleton
    fun provideFilmReviewsRepository(retrofitService: RetrofitService) : FilmReviewRepository{
        return FilmReviewsRepositoryImpl(retrofitService)
    }

    @Provides
    @Singleton
    fun provideDefaultPageConfig(): PagingConfig{
        return PagingConfig(pageSize = DEFAULT_PAGE_SIZE, enablePlaceholders = false)
    }
}