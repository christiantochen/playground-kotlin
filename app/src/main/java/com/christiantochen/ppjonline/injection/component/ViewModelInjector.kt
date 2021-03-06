package com.christiantochen.ppjonline.injection.component

import com.christiantochen.ppjonline.injection.module.NetworkModule
import com.christiantochen.ppjonline.ui.login.LoginViewModel
import dagger.Component
import javax.inject.Singleton


/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified LoginViewModel.
     * @param loginViewModel LoginViewModel in which to inject the dependencies
     */
    fun inject(loginViewModel: LoginViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}