package com.codetron.movieappmvpdi.presenter

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.codetron.movieappmvpdi.MovieApp
import com.codetron.movieappmvpdi.data.Movie
import com.codetron.movieappmvpdi.databinding.ActivityMainBinding
import javax.inject.Inject

class ListMovieActivity : AppCompatActivity(), ListMovieView {

    @Inject
    lateinit var presenter: ListMoviePresenter

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding

    private val moviesAdapter by lazy { MoviesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MovieApp).appComponent.withActivity(this).build().inject(this)
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        initListMovie()

        presenter.discoverMovie()
    }

    private fun initListMovie() {
        binding?.rvMovies?.adapter = moviesAdapter
        binding?.rvMovies?.addItemDecoration(
            DividerItemDecoration(
                this@ListMovieActivity,
                DividerItemDecoration.VERTICAL
            )
        )
        binding?.rvMovies?.setHasFixedSize(true)
    }

    companion object {
        private val TAG = ListMovieActivity::class.java.simpleName
    }

    override fun onShowLoading() {
        binding?.pbHome?.visibility = View.VISIBLE
    }

    override fun onHideLoading() {
        binding?.pbHome?.visibility = View.GONE
    }

    override fun onResponse(results: List<Movie>) {
        moviesAdapter.setMovies(results)
    }

    override fun onFailure(error: Throwable) {
        Log.e(TAG, "${error.printStackTrace()}")
    }

}