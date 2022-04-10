package com.example.finalweatherproject.di.domain

import com.example.finalweatherproject.di.domain.modules.DomainModule
import com.example.finalweatherproject.viewmodel.SettingsFragmentViewModel
import dagger.Component

import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DomainModule::class
    ]
)
interface AppComponent {

    fun inject(settingsFragmentViewModel: SettingsFragmentViewModel)
}