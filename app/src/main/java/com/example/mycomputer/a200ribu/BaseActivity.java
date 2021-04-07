package com.example.mycomputer.a200ribu;

import android.app.Activity;
import android.content.Intent;

public class BaseActivity extends Activity {

    @Override
    public void finish() {
        super.finish();
        overridePendingTransitionExit();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransitionEnter();
    }

    /**
     * Overrides the pending Activity transition by performing the "Enter" animation.
     */
    protected void overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.act_slide_from_right, R.anim.act_tran_slide_to_left);
    }

    /**
     * Overrides the pending Activity transition by performing the "Exit" animation.
     */
    protected void overridePendingTransitionExit() {
        overridePendingTransition(R.anim.act_slide_from_left, R.anim.act_trans_slide_to_right);
    }

}
