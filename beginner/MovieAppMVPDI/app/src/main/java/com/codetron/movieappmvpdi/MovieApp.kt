package com.codetron.movieappmvpdi

import android.app.Application
import com.codetron.movieappmvpdi.di.component.DaggerApplicationComponent

class MovieApp : Application() {

    val appComponent by lazy { DaggerApplicationComponent.builder().create(this) }

}