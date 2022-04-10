package com.example.finalweatherproject.di.domain.modules

import android.content.Context
import com.example.finalweatherproject.data.PreferenceProvider
import com.example.finalweatherproject.di.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule(val context: Context) {
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides

    fun providePreferences(context: Context) = PreferenceProvider(context)

    @Singleton
    @Provides
    fun provideInteractor(preferenceProvider: PreferenceProvider) = Interactor(preferences = preferenceProvider)
}