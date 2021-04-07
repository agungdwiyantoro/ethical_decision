package com.example.mycomputer.a200ribu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import static com.example.mycomputer.a200ribu.fragment6.FRAGMENT6;
import static com.example.mycomputer.a200ribu.screen_slide.KEY;

/**
 * Created by My Computer on 2/8/2018.
 */

public class log2 extends Activity {
    SharedPreferences FRAGMENT6_S;

    SharedPreferences FRAGMENT_SHIT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log2);


        FRAGMENT6_S = getSharedPreferences(FRAGMENT6, Context.MODE_PRIVATE);
        FRAGMENT_SHIT = getSharedPreferences(KEY, Context.MODE_PRIVATE);
        Button log2_next = findViewById(R.id.button_next);

        log2_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log2 = new Intent(log2.this, log.class);
                startActivity(log2);
                finish();
            }
        });

        ImageView back_button = findViewById(R.id.back_icon);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
/*
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String essay1_string = sp.getString(essays.k_essay_1, "null");

        SharedPreferences sp2 = PreferenceManager.getDefaultSharedPreferences(this);
        String essay1_string2 = sp2.getString(essays2.k_essay_2, "null");

        SharedPreferences sp3 = PreferenceManager.getDefaultSharedPreferences(this);
        String essay1_string3 = sp3.getString(pagestripviewpager.k_essay_3, "null");

        SharedPreferences sp4 = PreferenceManager.getDefaultSharedPreferences(this);
        String essay1_string4 = sp4.getString(essays4.k_essay_4_1, "null");


        SharedPreferences sp4_2 = PreferenceManager.getDefaultSharedPreferences(this);
        String essay1_string4_2 = sp4_2.getString(essays4.k_essay_4_2, "null");


        SharedPreferences sp4_3 = PreferenceManager.getDefaultSharedPreferences(this);
        String essay1_string4_3 = sp4_3.getString(essays4.k_essay_4_3, "null");


        SharedPreferences sp4_4 = PreferenceManager.getDefaultSharedPreferences(this);
        String essay1_string4_4 = sp4_4.getString(essays4.k_essay_4_4, "null");

        TextView jawaban1 = findViewById(R.id.jawaban1);
        TextView jawaban2 = findViewById(R.id.jawaban2);
        TextView jawaban3 = findViewById(R.id.jawaban3);
        TextView jawaban4 = findViewById(R.id.jawaban4_1);
        TextView jawaban4_2 = findViewById(R.id.jawaban4_2);
        TextView jawaban4_3 = findViewById(R.id.jawaban4_3);
        TextView jawaban4_4 = findViewById(R.id.jawaban4_4);

        jawaban1.setText(essay1_string);
        jawaban2.setText(essay1_string2);
        jawaban3.setText(essay1_string3);
        jawaban4.setText(essay1_string4);
        jawaban4_2.setText(essay1_string4_2);
        jawaban4_3.setText(essay1_string4_3);
        jawaban4_4.setText(essay1_string4_4);

*/

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // FRAGMENT6_S.edit().clear().apply();
      //  FRAGMENT_SHIT.edit().clear().apply();

    }


    @Override
    public void finish() {
        super.finish();
        //  System.out.println("Fuck you nigga soldier.kidd");
        overridePendingTransitionEnter();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransitionExit();
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
