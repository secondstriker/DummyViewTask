package com.codewithmohsen.dummyviewtask.di

import android.app.Application
import com.codewithmohsen.dummyviewtask.DummyViewApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules =
        [AndroidInjectionModule::class,
        AppModule::class,
        ViewModelModule::class,
        ActivitiesModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(dummyViewApp: DummyViewApp)
}
