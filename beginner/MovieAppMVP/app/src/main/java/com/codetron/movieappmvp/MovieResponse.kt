package com.codetron.movieappmvp

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val results: List<Movie>
)

data class Movie(
    @SerializedName("title")
    val title: String,

    @SerializedName("overview")
    val overview: String
) 