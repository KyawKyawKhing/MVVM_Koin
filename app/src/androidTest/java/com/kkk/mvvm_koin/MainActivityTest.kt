package com.kkk.mvvm_koin

import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import com.kkk.mvvm_koin.CustomAssertions.Companion.hasItemCount
import com.kkk.mvvm_koin.CustomMatchers.Companion.withItemCount
import com.kkk.mvvm_koin.ui.activity.MainActivity
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun checkNoticeList() {
        Espresso.onView(ViewMatchers.withId(R.id.rvNotice))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun countPrograms() {
        Espresso.onView(ViewMatchers.withId(R.id.rvNotice))
                .check(ViewAssertions.matches(withItemCount(10)))
    }

    @Test
    fun countProgramsWithViewAssertion() {
        Espresso.onView(ViewMatchers.withId(R.id.rvNotice))
                .check(hasItemCount(10))
    }
}