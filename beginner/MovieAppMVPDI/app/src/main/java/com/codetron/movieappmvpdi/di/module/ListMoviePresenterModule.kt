package com.codetron.movieappmvpdi.di.module

import com.codetron.movieappmvpdi.data.MovieDataSource
import com.codetron.movieappmvpdi.di.scope.Presentation
import com.codetron.movieappmvpdi.presenter.ListMoviePresenter
import com.codetron.movieappmvpdi.presenter.ListMovieView
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [ListMovieViewModule::class, NetworkModule::class])
class ListMoviePresenterModule {

    @Provides
    @Presentation
    fun providesMovieDataSource(retrofit: Retrofit): MovieDataSource {
        return retrofit.create(MovieDataSource::class.java)
    }

    @Provides
    @Presentation
    fun providesMoviePresenter(
        view: ListMovieView,
        dataSource: MovieDataSource
    ): ListMoviePresenter {
        return ListMoviePresenter(view, dataSource)
    }

}