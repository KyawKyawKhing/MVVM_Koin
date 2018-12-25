package com.kkk.mvvm_koin

import android.support.test.espresso.NoMatchingViewException
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers
import android.support.v7.widget.RecyclerView
import android.view.View
import org.hamcrest.CoreMatchers
import org.hamcrest.Description
import org.hamcrest.Matcher

class CustomMatchers {
    companion object {
        fun withItemCount(count: Int): Matcher<View> {
            return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
                override fun describeTo(description: Description?) {
                    description?.appendText("RecyclerView with item count: $count")
                }

                override fun matchesSafely(item: RecyclerView?): Boolean {
                    return item?.adapter?.itemCount == count
                }
            }
        }
    }
}

class CustomAssertions {
    companion object {
        fun hasItemCount(count: Int): ViewAssertion {
            return RecyclerViewItemCountAssertion(count)
        }
    }

    private class RecyclerViewItemCountAssertion(private val count: Int) : ViewAssertion {

        override fun check(view: View, noViewFoundException: NoMatchingViewException?) {
            if (noViewFoundException != null) {
                throw noViewFoundException
            }

            if (view !is RecyclerView) {
                throw IllegalStateException("The asserted view is not RecyclerView")
            }

            if (view.adapter == null) {
                throw IllegalStateException("No adapter is assigned to RecyclerView")
            }

            ViewMatchers.assertThat("RecyclerView item count", view.adapter?.itemCount, CoreMatchers.equalTo(count))
        }
    }
}