package com.reviakin_package.test_films_app.di

import com.google.gson.Gson
import com.reviakin_package.test_films_app.data.repository.FilmReviewsRepositoryImpl
import com.reviakin_package.test_films_app.data.source.remote.RetrofitService
import com.reviakin_package.test_films_app.domain.repository.FilmReviewRepository
import com.reviakin_package.test_films_app.utils.Constants
import com.reviakin_package.test_films_app.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory
    ) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideGson() : Gson{
        return Gson()
    }

    @Provides
    @Singleton
    fun provideRxJavaCallAdapterFactory() : RxJava2CallAdapterFactory{
        return RxJava2CallAdapterFactory.create()
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
}