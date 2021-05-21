package com.codetron.movieappmvpdirx.di.component

import android.app.Activity
import android.app.Application
import com.codetron.movieappmvpdirx.di.module.ListMoviePresenterModule
import com.codetron.movieappmvpdirx.di.scope.Presentation
import com.codetron.movieappmvpdirx.presenter.ListMovieActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Presentation
@Component(
    modules = [ListMoviePresenterModule::class]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        fun withActivity(@BindsInstance activity: Activity): Builder
        fun create(@BindsInstance application: Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(activity: ListMovieActivity)

}