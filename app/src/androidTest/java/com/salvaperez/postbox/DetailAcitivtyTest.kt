package com.salvaperez.postbox

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.salvaperez.postbox.ui.detail.DetailActivity
import com.salvaperez.postbox.utils.mockedPostDataViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class DetailActivityTest{

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<DetailActivity>(DetailActivity::class.java, true, false)


    @Before
    @Throws(Exception::class)
    fun setUp() {
        val intent = Intent()
        intent.putExtra(DetailActivity.DETAIL, mockedPostDataViewModel())
        activityRule.launchActivity(intent)
    }


    @Test
    fun check_intent_is_received_and_show_elements(){
        onView(withId(R.id.txPostTitleDetail)).check(matches(withText("This is title post")))
    }
}