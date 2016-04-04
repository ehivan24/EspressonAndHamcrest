package com.ada.edwingsantos.espressonandhamcrest;


import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class HamcrestTest {
    @Rule
    public final ActivityRule<MainActivity> main = new ActivityRule<>(MainActivity.class);

    /**
     * Testing if the textview is Displayed
     */


    @Test
    public void checkIfTextViewAvailable(){
        onView(withId(R.id.textView))
        .check(matches(isDisplayed()));
    }

    /**
     * @note       This class has no class.
     * @attention  Should only be used by those who
     *             know what they are doing.
     * @warning    Not certified for use within mission
     *             critical or life sustaining systems.
     */

    /**
     * @bug        Division by zero does not work.
     * @todo       Finish writing the class.
     */

}
