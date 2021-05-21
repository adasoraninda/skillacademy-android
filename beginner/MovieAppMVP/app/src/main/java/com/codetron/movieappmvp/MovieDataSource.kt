package com.codetron.movieappmvp

import retrofit2.Call
import retrofit2.http.GET

interface MovieDataSource {

    @GET("/3/discover/movie?api_key=${BuildConfig.API_KEY}")
    fun discoverMovie(): Call<MovieResponse>

} 