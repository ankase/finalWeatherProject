package com.example.finalweatherproject

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkIfTextEnterIsCorrect() {
    onView(withId(R.id.search_view)).perform(typeText("Irkutsk"))
    closeSoftKeyboard()
    }

    @Test
    fun allMenuDestinationsShouldWork() {
        onView(withId(R.id.menu_navigation)).perform(click())
        onView(withId(R.id.settings_fragment_root)).check(matches(isDisplayed()))

        onView(withId(R.id.search_view)).perform(click())
        onView(withId(R.id.searchFragment)).check(matches(isDisplayed()))
    }
}