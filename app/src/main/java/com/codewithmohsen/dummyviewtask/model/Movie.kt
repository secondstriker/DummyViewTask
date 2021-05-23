package com.codewithmohsen.dummyviewtask.model

data class Movie(var id: Int, var title: String, var yearPublished: Int, var description: String, var posterId: Int? = null)