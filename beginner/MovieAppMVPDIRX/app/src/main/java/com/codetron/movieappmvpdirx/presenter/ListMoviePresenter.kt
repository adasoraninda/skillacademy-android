package com.codetron.movieappmvpdirx.presenter

import com.codetron.movieappmvpdirx.data.MovieDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class ListMoviePresenter(
    private val view: ListMovieView,
    private val dataSource: MovieDataSource
) {

    private val disposables by lazy { CompositeDisposable() }

    fun discoverMovie() {

        view.onShowLoading()

        dataSource.discoverMovie()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                view.onHideLoading()
                view.onResponse(response.results)
            }, { error ->
                view.onHideLoading()
                view.onFailure(error)
            }).addTo(disposables)

    }

    fun onDetach() {
        disposables.clear()
    }

}