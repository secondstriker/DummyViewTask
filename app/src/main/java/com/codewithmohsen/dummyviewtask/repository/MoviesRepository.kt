package com.codewithmohsen.dummyviewtask.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codewithmohsen.dummyviewtask.model.Movie
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val movies: List<Movie>) {

    private val moviesLiveData = MutableLiveData<List<Movie>>()

    init {
        moviesLiveData.value = movies
    }

    fun getMovies(): LiveData<List<Movie>> = moviesLiveData
}