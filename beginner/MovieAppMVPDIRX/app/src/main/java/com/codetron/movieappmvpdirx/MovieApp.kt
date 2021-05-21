package com.codetron.movieappmvpdirx

import android.app.Application
import com.codetron.movieappmvpdirx.di.component.DaggerApplicationComponent

class MovieApp : Application() {

    val appComponent by lazy { DaggerApplicationComponent.builder().create(this) }

}