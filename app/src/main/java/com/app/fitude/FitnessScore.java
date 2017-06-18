package com.app.fitude;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Shravan on 6/18/2017.
 */
public class FitnessScore extends Activity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        tv = (TextView)findViewById(R.id.textView8);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String age = preferences.getString("age", "");
        String gender = preferences.getString("gender", "");
        String isSmoker = preferences.getString("isSmoker", "");
        String height = preferences.getString("height", "");
        String weight = preferences.getString("weight", "");
        String isSuger = preferences.getString("isSuger", "");
        String isPSuger = preferences.getString("isPSuger", "");
        String bp = preferences.getString("bp", "");
        String isbpmed = preferences.getString("isbpmed", "");
        String ischol = preferences.getString("ischol", "");
        String ispheart = preferences.getString("ispheart", "");

        String score = this.calculateFitnessScore(age,gender,isSmoker,height,weight,isSuger,isPSuger,bp,isbpmed,ischol,ispheart);
        tv.setText("Fitness Score : \n"+score+" / 1000");

        Button btn = (Button)findViewById(R.id.SetGoal);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Fitness Score LifeCycle", "Activity shown on screen");

    }
    public String calculateFitnessScore(String age,String gender,String isSmoker,String height,String weight,String isSuger,String isPSuger,String bp,String isbpmed,String ischol,String ispheart){
        int score = 0;
        // For Male
        if(gender.equals("male")){
            // Age
            if(Integer.parseInt(age) < 40 ){
                score = score+175; // Out of 200
            } else {
                score = score+150; // Out of 200
            }

            // Calculate BMI  -- Weight in KG / Height in M Squared
            double bmi = Double.parseDouble(weight)/((Double.parseDouble(height)/100) * (Double.parseDouble(height)/100));
            if(bmi < 18){
                score = score +60; // out of 100
            } else if (bmi >=18 && bmi <24 ){
                score = score + 80; // out of 100
            } else if (bmi >= 24){
                score = score + 50; // out of 100
            }

            // Check if this person smokes
            if(isSmoker.equals("false")){
                score = score + 80; // out of 100
            } else {
                score = score + 40; // out of 100
            }

            // Check if this person has Diabetes
            if(isSuger.equals("false")){
                score = score + 80; // out of 100
            } else {
                score = score + 60; // out of 100
            }

            // Check if this person's Parent has Diabetes
            if(isPSuger.equals("false")){
                score = score + 80; // out of 100
            } else {
                score = score + 70; // out of 100
            }

            // Check if this person has Systolic BP
            if(Integer.parseInt(bp)>140){
                score = score + 60; // out of 100
            } else {
                score = score + 80; // out of 100
            }

            // Check if this person  has BP Med
            if(isbpmed.equals("false")){
                score = score + 80; // out of 100
            } else {
                score = score + 50; // out of 100
            }


            // Check if this person has Cholesterol check
            if(ischol.equals("false")){
                score = score + 80; // out of 100
            } else {
                score = score + 40; // out of 100
            }

            // Check if this person;s has Heart attacks before 60
            if(ispheart.equals("false")){
                score = score + 80; // out of 100
            } else {
                score = score + 50; // out of 100
            }

            return String.valueOf(score);

        } // For Female
        else if (gender.equals("female")){
            // Age
            if(Integer.parseInt(age) < 40 ){
                score = score+150; // Out of 200
            } else {
                score = score+125; // Out of 200
            }

            // Calculate BMI  -- Weight in KG / Height in M Squared
            double bmi = Double.parseDouble(weight)/((Double.parseDouble(height)/100) * (Double.parseDouble(height)/100));
            if(bmi < 18){
                score = score +60; // out of 100
            } else if (bmi >=18 && bmi <24 ){
                score = score + 80; // out of 100
            } else if (bmi >= 24){
                score = score + 50; // out of 100
            }

            // Check if this person smokes
            if(isSmoker.equals("false")){
                score = score + 80; // out of 100
            } else {
                score = score + 40; // out of 100
            }

            // Check if this person has Diabetes
            if(isSuger.equals("false")){
                score = score + 80; // out of 100
            } else {
                score = score + 60; // out of 100
            }

            // Check if this person's Parent has Diabetes
            if(isPSuger.equals("false")){
                score = score + 80; // out of 100
            } else {
                score = score + 70; // out of 100
            }

            // Check if this person has Systolic BP
            if(Integer.parseInt(bp)>140){
                score = score + 60; // out of 100
            } else {
                score = score + 80; // out of 100
            }

            // Check if this person  has BP Med
            if(isbpmed.equals("false")){
                score = score + 80; // out of 100
            } else {
                score = score + 50; // out of 100
            }

            // Check if this person has Cholesterol check
            if(ischol.equals("false")){
                score = score + 80; // out of 100
            } else {
                score = score + 40; // out of 100
            }

            // Check if this person;s has Heart attacks before 60
            if(ispheart.equals("false")){
                score = score + 80; // out of 100
            } else {
                score = score + 50; // out of 100
            }
            return String.valueOf(score);

        }
        return "Invalid Data, Try Calulating Fitness Score Again !";
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Fitness Score LifeCycle", "Activity Resumed on screen");

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
        Log.d("Fitness Score LifeCycle", "Activity Paused");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Fitness Score LifeCycle", "Activity Stopped");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Fitness Score LifeCycle", "Activity Destroyed");
        finish();

    }
}
