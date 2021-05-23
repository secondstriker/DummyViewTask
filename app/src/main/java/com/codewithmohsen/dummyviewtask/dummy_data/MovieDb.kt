package com.codewithmohsen.dummyviewtask.dummy_data

import com.codewithmohsen.dummyviewtask.model.Movie

object MovieDb {

    fun getMovies(): List<Movie> {
        return mutableListOf(
            Movie(
                1,
                "The Godfather 1",
                1972,
                "description of the godfather 1 movie"
            ),
            Movie(
                2,
                "Gladiator",
                2000,
                "description for gladiator"
            ),
            Movie(3,
            "BraveHeart",
            2003,
            "description for braveheart")
        )
    }
}