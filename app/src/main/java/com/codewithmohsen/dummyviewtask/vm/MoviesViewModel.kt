package com.codewithmohsen.dummyviewtask.vm

import androidx.lifecycle.ViewModel
import com.codewithmohsen.dummyviewtask.repository.MoviesRepository
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    private val repo: MoviesRepository): ViewModel() {

        fun getMovies() = repo.getMovies()
}