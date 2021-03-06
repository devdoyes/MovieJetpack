package com.masscode.moviejetpack.data.source.remote.response

import com.masscode.moviejetpack.data.source.local.entity.Movie
import com.squareup.moshi.Json

data class MovieResponse(
    val page: Int,
    @Json(name = "results") val movies: List<Movie>,
    @Json(name = "total_pages") val pages: Int
)