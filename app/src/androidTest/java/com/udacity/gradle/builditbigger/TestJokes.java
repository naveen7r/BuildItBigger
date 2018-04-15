package com.udacity.gradle.builditbigger;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.udacity.gradle.builditbigger.listener.EndPointListener;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by Naveen on 4/15/2018.
 */

@RunWith(AndroidJUnit4.class)
public class TestJokes {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule =
            new ActivityTestRule(MainActivity.class, true, true);

    @Test
    public void test() throws InterruptedException {

        final CountDownLatch signal = new CountDownLatch(1);

        MainActivity activity = activityActivityTestRule.getActivity();
        activity.setEndPointListener(new EndPointListener() {
            @Override
            public void onEndPointResult(String result) {
//                assertNull(result);
                assertNotNull(result);
                Log.d("TAG", result);
                signal.countDown();
            }
        });

        Espresso.onView(ViewMatchers.withId(R.id.b_jokes)).perform(ViewActions.click());

        signal.await();
    }
}
