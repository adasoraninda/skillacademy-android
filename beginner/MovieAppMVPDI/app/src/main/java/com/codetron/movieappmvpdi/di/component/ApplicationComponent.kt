package com.codetron.movieappmvpdi.di.component

import android.app.Activity
import android.app.Application
import com.codetron.movieappmvpdi.di.module.ListMoviePresenterModule
import com.codetron.movieappmvpdi.di.scope.Presentation
import com.codetron.movieappmvpdi.presenter.ListMovieActivity
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