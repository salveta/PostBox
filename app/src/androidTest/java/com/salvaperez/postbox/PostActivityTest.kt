package com.salvaperez.postbox

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import com.salvaperez.postbox.assertions.RecyclerViewMatcher
import com.salvaperez.postbox.idlingResources.EspressoTestingIdlResource
import com.salvaperez.postbox.ui.detail.DetailActivity
import com.salvaperez.postbox.ui.home.PostActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PostActivityTest {

    private var mIdlingResource: IdlingResource? = null

    @Rule
    @JvmField
    var activityRule = IntentsTestRule<PostActivity>(PostActivity::class.java)

    @Before
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoTestingIdlResource.idlingResource)
        mIdlingResource = activityRule.activity.getIdlingResource()
    }

    @Test
    fun click_item_open_film_detail() {
        onView(withRecyclerView(R.id.rvPosts).atPosition(0)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.rvPosts))
            .check(ViewAssertions.matches(ViewMatchers.hasDescendant(ViewMatchers.withId(R.id.constraintPost))))
            .perform(ViewActions.click())
        Intents.intended(IntentMatchers.hasComponent(DetailActivity::class.java.name))
    }

    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoTestingIdlResource.idlingResource)
    }

    private fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
        return RecyclerViewMatcher(recyclerViewId)
    }
}