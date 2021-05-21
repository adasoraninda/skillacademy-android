package com.codetron.movieappmvpdirx.di.module

import android.app.Activity
import com.codetron.movieappmvpdirx.di.scope.Presentation
import com.codetron.movieappmvpdirx.presenter.ListMovieActivity
import com.codetron.movieappmvpdirx.presenter.ListMovieView
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface ListMovieViewModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @Presentation
        fun bindListMovieActivity(activity: Activity): ListMovieActivity {
            return activity as ListMovieActivity
        }

    }

    @Binds
    @Presentation
    fun bindListMovieView(activity: ListMovieActivity): ListMovieView

}