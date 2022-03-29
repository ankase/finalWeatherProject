package com.example.finalweatherproject.di.domain

import com.example.finalweatherproject.data.PreferenceProvider

class Interactor(private val preferences: PreferenceProvider) {

    fun saveDefaultCategoryToPreferences(category: String) {
        preferences.saveDefaultCategory(category)
    }

    fun getDefaultCategoryFromPreferences() = preferences.geDefaultCategory()
}
