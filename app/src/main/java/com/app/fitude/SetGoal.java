package com.app.fitude;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by Shravan on 6/18/2017.
 */
public class SetGoal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this));




    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SetGoal LifeCycle", "Activity shown on screen");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SetGoal LifeCycle", "Activity Resumed on screen");

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
        Log.d("SetGoal LifeCycle", "Activity Paused");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SetGoal LifeCycle", "Activity Stopped");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SetGoal LifeCycle", "Activity Destroyed");
        finish();

    }



}
