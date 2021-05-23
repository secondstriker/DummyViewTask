package com.codewithmohsen.dummyviewtask.di

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.codewithmohsen.dummyviewtask.dummy_data.MovieDb
import com.codewithmohsen.dummyviewtask.model.Movie
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context{
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideMovieDb(): List<Movie>{
        return MovieDb.getMovies()
    }
}