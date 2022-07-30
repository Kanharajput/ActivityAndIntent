package com.example.talktoyourself;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;


import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SpinnerTest {

    @Rule           // through this we can access anything from this AnotherOne Activity
    public ActivityScenarioRule powerToAccess = new ActivityScenarioRule<>(AnotherOne.class);


    // there is no such direct way to access resources using ScenarioRule so we have to use this function
    private String[] getResourceArray(int id) {
        Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        return targetContext.getResources().getStringArray(id);
    }

    @Test
    public void testingSpinner() {
        String[] planets_name = getResourceArray(R.array.planets_array);

        // create a loop which run equals to size of the array
        for(int i=0; i<planets_name.length; i++) {
            onView(withId(R.id.spinner)).perform(click());    // finding the spinner and clicking on the spinner to open drop-down menu
            onData(is(planets_name[i])).perform(click());     // find the firt item of planets_name array is there, if there then click on it
            onView(withId(R.id.phone_label))
                        .check(matches(withText(containsString(planets_name[i]))));     // phone label textview having the right text or not
        }
    }
}
