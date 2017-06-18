package com.app.fitude;

/**
 * Created by Shravan on 6/18/2017.
 */
/**
 * Created by Shravan on 6/17/2017.
 */
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    private View mCurrentView;
    // FITNESS SCORE CALCULATING PARAMETER //
    public static int step1_age;
    public static String step2_gender;
    public static boolean step3_survey;
    public static double step4_height;
    public static double step4_weight;
    public static boolean step5_suger;
    public static boolean step6_survey;
    public static int step7_bp;
    public static boolean step8_survey;
    public static boolean step9_survey;
    public static boolean step10_survey;
    // FITNESS SCORE CALCULATING PARAMETER //
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public CustomPagerAdapter(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        FitnessObject modelObject = FitnessObject.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(modelObject.getLayoutResId(), collection, false);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
       Log.d("TAG 1","position :"+position);
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return FitnessObject.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }



    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        mCurrentView = (View)object;
        if(position == 0){
            EditText Q1= (EditText) mCurrentView.findViewById(R.id.survey_q1);
            Log.d("TAG 2","position :"+Q1.getText().toString());
            editor.putString("age",Q1.getText().toString());
            editor.apply();
        }

        if(position == 1){
            RadioButton Q2a= (RadioButton) mCurrentView.findViewById(R.id.survey_q2_a);
            RadioButton Q2b= (RadioButton) mCurrentView.findViewById(R.id.survey_q2_b);
            if(Q2a.isChecked()){
                editor.putString("gender","male");
                editor.apply();
            } else if (Q2b.isChecked()) {
                editor.putString("gender","female");
                editor.apply();
            }
            Log.d("TAG 2","gender"+Q2a.getText().toString());
            Log.d("TAG 2","gender"+Q2b.getText().toString());
        }
        if(position == 2){
            RadioButton Q3a= (RadioButton) mCurrentView.findViewById(R.id.survey_q3_a);
            RadioButton Q3b= (RadioButton) mCurrentView.findViewById(R.id.survey_q3_b);
            if(Q3a.isChecked()){
                editor.putString("isSmoker","true");
                editor.apply();
            } else if (Q3b.isChecked()) {
                editor.putString("isSmoker","false");
                editor.apply();
            }
            Log.d("TAG 2","isSmoker"+Q3a.getText().toString());
            Log.d("TAG 2","isSmoker"+Q3b.getText().toString());
        }
        if(position == 3){
            EditText Q4a = (EditText) mCurrentView.findViewById(R.id.survey_q4a);
            EditText Q4b = (EditText) mCurrentView.findViewById(R.id.survey_q4b);
                editor.putString("height",Q4a.getText().toString());
                editor.putString("weight",Q4b.getText().toString());
                editor.apply();
            Log.d("TAG 2","height"+Q4a.getText().toString());
            Log.d("TAG 2","weight"+Q4b.getText().toString());
        }
        if(position == 4){
            RadioButton Q5a= (RadioButton) mCurrentView.findViewById(R.id.survey_q5a);
            RadioButton Q5b= (RadioButton) mCurrentView.findViewById(R.id.survey_q5b);
            if(Q5a.isChecked()){
                editor.putString("isSuger","true");
                editor.apply();
            } else if (Q5b.isChecked()) {
                editor.putString("isSuger","false");
                editor.apply();
            }
            Log.d("TAG 2","Suger"+Q5a.getText().toString());
            Log.d("TAG 2","Suger"+Q5b.getText().toString());
        }
        if(position == 5){
            RadioButton Q6a= (RadioButton) mCurrentView.findViewById(R.id.survey_q6a);
            RadioButton Q6b= (RadioButton) mCurrentView.findViewById(R.id.survey_q6b);
            if(Q6a.isChecked()){
                editor.putString("isPSuger","true");
                editor.apply();
            } else if (Q6b.isChecked()) {
                editor.putString("isPSuger","false");
                editor.apply();
            }
            Log.d("TAG 2","PSuger"+Q6a.getText().toString());
            Log.d("TAG 2","PSuger"+Q6b.getText().toString());
        }
        if(position == 6){
            EditText Q7= (EditText) mCurrentView.findViewById(R.id.survey_q7);
            Log.d("TAG 2","position :"+Q7.getText().toString());
            editor.putString("bp",Q7.getText().toString());
            editor.apply();
        }
        if(position == 7){
            RadioButton Q8a= (RadioButton) mCurrentView.findViewById(R.id.survey_q8a);
            RadioButton Q8b= (RadioButton) mCurrentView.findViewById(R.id.survey_q8b);
            if(Q8a.isChecked()){
                editor.putString("isbpmed","true");
                editor.apply();
            } else if (Q8b.isChecked()) {
                editor.putString("isbpmed","false");
                editor.apply();
            }
            Log.d("TAG 2","isbpmed"+Q8a.getText().toString());
            Log.d("TAG 2","isbpmed"+Q8b.getText().toString());
        }
        if(position == 8){
            RadioButton Q9a= (RadioButton) mCurrentView.findViewById(R.id.survey_q9a);
            RadioButton Q9b= (RadioButton) mCurrentView.findViewById(R.id.survey_q9b);
            if(Q9a.isChecked()){
                editor.putString("ischol","true");
                editor.apply();
            } else if (Q9b.isChecked()) {
                editor.putString("ischol","false");
                editor.apply();
            }
            Log.d("TAG 2","ischol"+Q9a.getText().toString());
            Log.d("TAG 2","ischol"+Q9b.getText().toString());
        }
        if(position == 9){
            RadioButton Q10a= (RadioButton) mCurrentView.findViewById(R.id.survey_q10a);
            RadioButton Q10b= (RadioButton) mCurrentView.findViewById(R.id.survey_q10b);
            if(Q10a.isChecked()){
                editor.putString("ispheart","true");
                editor.apply();
            } else if (Q10b.isChecked()) {
                editor.putString("ispheart","false");
                editor.apply();
            }
            Log.d("TAG 2","ispheart"+Q10a.getText().toString());
            Log.d("TAG 2","ispheart"+Q10b.getText().toString());
        }
        Button fitbtn = (Button)mCurrentView.findViewById(R.id.fitnessscore);
        View.OnClickListener listener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext.getApplicationContext(),FitnessScore.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);

            }};
        if (fitbtn != null)
            fitbtn.setOnClickListener(listener);




    }

    @Override
    public CharSequence getPageTitle(int position) {
        FitnessObject customPagerEnum = FitnessObject.values()[position];
        return mContext.getString(customPagerEnum.getTitleResId());
    }

}
