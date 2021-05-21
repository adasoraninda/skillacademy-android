package com.codetron.movieappmvpdi.presenter

import com.codetron.movieappmvpdi.data.Movie

interface ListMovieView {

    fun onShowLoading()
    fun onHideLoading()
    fun onResponse(results: List<Movie>)
    fun onFailure(error: Throwable)

}