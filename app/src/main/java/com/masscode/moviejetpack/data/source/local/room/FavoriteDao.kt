package com.masscode.moviejetpack.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.masscode.moviejetpack.data.source.local.entity.Movie
import com.masscode.moviejetpack.data.source.local.entity.TvShow

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM movie_entity")
    fun getMovies(): DataSource.Factory<Int, Movie>

    @Query("SELECT * FROM tv_entity")
    fun getTvShows(): LiveData<List<TvShow>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAllMovie(movies: List<Movie>)

    @Transaction
    @Query("SELECT * FROM movie_entity WHERE id = :movieId")
    fun getMovieById(movieId: Int): LiveData<Movie>

    @Update
    suspend fun updateMovie(movie: Movie)

    @Query("SELECT * FROM movie_entity WHERE isFavorite = 1")
    fun getFavoriteMovies(): DataSource.Factory<Int, Movie>

}