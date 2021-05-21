package com.codetron.movieappmvpdirx.presenter

import com.codetron.movieappmvpdirx.data.Movie

interface ListMovieView {

    fun onShowLoading()
    fun onHideLoading()
    fun onResponse(results: List<Movie>)
    fun onFailure(error: Throwable)

}