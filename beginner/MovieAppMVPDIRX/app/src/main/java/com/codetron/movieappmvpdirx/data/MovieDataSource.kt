package com.codetron.movieappmvpdirx.data

import com.codetron.movieappmvpdirx.BuildConfig
import io.reactivex.Single
import retrofit2.http.GET

interface MovieDataSource {

    @GET("/3/discover/movie?api_key=${BuildConfig.API_KEY}")
    fun discoverMovie(): Single<MovieResponse>

} 