package com.codewithmohsen.dummyviewtask.di

import com.codewithmohsen.dummyviewtask.view.MoviesFragment
import com.codewithmohsen.dummyviewtask.view.PlayerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeMoviesFragment(): MoviesFragment
    @ContributesAndroidInjector
    abstract fun contributePlayerFragment(): PlayerFragment
}