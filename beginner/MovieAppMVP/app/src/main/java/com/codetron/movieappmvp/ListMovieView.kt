package com.codetron.movieappmvp

interface ListMovieView {

    fun onShowLoading()
    fun onHideLoading()
    fun onResponse(results: List<Movie>)
    fun onFailure(error: Throwable)

}