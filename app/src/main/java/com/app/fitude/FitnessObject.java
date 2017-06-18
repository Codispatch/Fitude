package com.app.fitude;

/**
 * Created by Shravan on 6/18/2017.
 */
public enum FitnessObject {

    PAGE1(R.string.skin, R.layout.survey_step1),
    PAGE2(R.string.skin, R.layout.survey_step2),
    PAGE3(R.string.skin, R.layout.survey_step3),
    PAGE4(R.string.skin, R.layout.survey_step4),
    PAGE5(R.string.skin, R.layout.survey_step5),
    PAGE6(R.string.skin, R.layout.survey_step6),
    PAGE7(R.string.skin, R.layout.survey_step7),
    PAGE8(R.string.skin, R.layout.survey_step8),
    PAGE9(R.string.skin, R.layout.survey_step9),
    PAGE10(R.string.skin, R.layout.survey_step10);

    private int mTitleResId;
    private int mLayoutResId;

    FitnessObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
