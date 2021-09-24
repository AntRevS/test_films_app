package com.reviakin_package.test_films_app.domain.usecase

import android.util.Log
import androidx.paging.PagingSource
import com.reviakin_package.test_films_app.data.source.remote.RetrofitService
import com.reviakin_package.test_films_app.domain.model.filmreviews.FilmReviews
import com.reviakin_package.test_films_app.domain.model.filmreviews.other.Results
import com.reviakin_package.test_films_app.utils.Constants.DEFAULT_PAGE_SIZE
import retrofit2.HttpException
import java.io.IOException

class ReviewsPagingSource(
    val retrofitService: RetrofitService
) : PagingSource<Int, Results>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Results> {
        val page = params.key ?: 1
        return try{
            val reviews = retrofitService.getReviews(page)
            val response = reviews.results
            LoadResult.Page(
                response, prevKey = if(page == 1) null else page - DEFAULT_PAGE_SIZE,
                nextKey = if(!reviews.hasMore) null else page + DEFAULT_PAGE_SIZE
            )
        }catch (e: IOException){
            return LoadResult.Error(e)
        }catch (e: HttpException){
            return LoadResult.Error(e)
        }
    }
}