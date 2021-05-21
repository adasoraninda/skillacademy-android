package com.codetron.movieappmvp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListMoviePresenter(private val view:ListMovieView){

    fun discoverMovie(){

        view.onShowLoading()

        val datasource = NetworkProvider.providesHttpAdapter().create(MovieDataSource::class.java)
        datasource.discoverMovie().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                view.onHideLoading()

                val movies = response.body()?.results ?: emptyList()
                view.onResponse(results = movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                view.onHideLoading()
               view.onFailure(t)
            }
        })

    }

}