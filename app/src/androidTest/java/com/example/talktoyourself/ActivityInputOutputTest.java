package com.example.talktoyourself;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.annotation.ContentView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ActivityInputOutputTest {
    @Rule
    public ActivityScenarioRule mActivityRule = new ActivityScenarioRule(MainActivity.class);

    @Test
    public void activityLaunch() {
        Espresso.onView(withId(R.id.button)).perform(click());
    }

    @Test
    public void inputOutput() {
        Espresso.onView(withId(R.id.placeOfMessage)).perform(typeText("Kanha Tomar"));
        Espresso.onView(withId(R.id.button)).perform(click());
        Espresso.onView(withId(R.id.displayUserMessage2)).check(matches(withText("Kanha Tomar")));
    }
}