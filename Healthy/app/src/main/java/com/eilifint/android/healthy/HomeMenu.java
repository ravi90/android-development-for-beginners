package com.eilifint.android.healthy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HomeMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);
    }

    /**
     * This method opens the Excercise Activity.
     */
    public void openExercise(View view) {
        Intent exercise = new Intent(HomeMenu.this, Exercise.class);
        startActivity(exercise);
    }

    /**
     * This method opens the HealthyFood Activity.
     */
    public void openHealthyFood(View view) {
        Intent exercise = new Intent(HomeMenu.this, HelthyFood.class);
        startActivity(exercise);
    }

    /**
     * This method opens the Breakfast Activity.
     */
    public void openBreakfast(View view) {
        Intent exercise = new Intent(HomeMenu.this, Breakfast.class);
        startActivity(exercise);
    }

    /**
     * This method opens the Sleep Activity.
     */
    public void openSleep(View view) {
        Intent exercise = new Intent(HomeMenu.this, Sleep.class);
        startActivity(exercise);
    }

    /**
     * This method opens the Sleep Activity.
     */
    public void openStress(View view) {
        Intent exercise = new Intent(HomeMenu.this, Stress.class);
        startActivity(exercise);
    }

    /**
     * This method opens the Sleep Activity.
     */
    public void openFeedback(View view) {
        Intent exercise = new Intent(HomeMenu.this, Feedback.class);
        startActivity(exercise);
    }


}
