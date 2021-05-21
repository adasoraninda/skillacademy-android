package com.codetron.movieappmvpdirx.di.module

import com.codetron.movieappmvpdirx.data.MovieDataSource
import com.codetron.movieappmvpdirx.di.scope.Presentation
import com.codetron.movieappmvpdirx.presenter.ListMoviePresenter
import com.codetron.movieappmvpdirx.presenter.ListMovieView
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