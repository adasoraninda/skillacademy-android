package com.codetron.movieappmvpdi.di.module

import android.app.Activity
import com.codetron.movieappmvpdi.di.scope.Presentation
import com.codetron.movieappmvpdi.presenter.ListMovieActivity
import com.codetron.movieappmvpdi.presenter.ListMovieView
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