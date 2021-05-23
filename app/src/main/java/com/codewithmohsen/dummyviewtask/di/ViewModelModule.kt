package com.codewithmohsen.dummyviewtask.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

//    @Binds
//    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(RestaurantsViewModel::class)
//    abstract fun bindSearchMoviesViewModel(restaurantsViewModel: RestaurantsViewModel): ViewModel
}