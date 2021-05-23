package com.codewithmohsen.dummyviewtask.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codewithmohsen.dummyviewtask.vm.AppViewModelFactory
import com.codewithmohsen.dummyviewtask.vm.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    abstract fun bindMoviesViewModel(moviesViewModel: MoviesViewModel): ViewModel
}