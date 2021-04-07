package com.example.mycomputer.a200ribu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import static com.example.mycomputer.a200ribu.fragment6.FRAGMENT6;
import static com.example.mycomputer.a200ribu.screen_slide.KEY;

/**
 * Created by My Computer on 2/8/2018.
 */

public class log extends Activity {
    SharedPreferences FRAGMENT6_S;

    SharedPreferences FRAGMENT_SHIT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log);

        TableLayout tl = findViewById(R.id.table_layout_log);


        FRAGMENT6_S = getSharedPreferences(FRAGMENT6, Context.MODE_PRIVATE);
        FRAGMENT_SHIT = getSharedPreferences(KEY, Context.MODE_PRIVATE);


        ImageView back_button = findViewById(R.id.back_icon);

        Button close = new Button(this);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back_hasil = new Intent(log.this, log2.class);
                startActivity(back_hasil);
                finish();
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TableRow.LayoutParams table_row_pertanyaan = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        table_row_pertanyaan.weight = 1;
        table_row_pertanyaan.bottomMargin = 10;
        table_row_pertanyaan.topMargin = 30;

        TableRow.LayoutParams table_row_seekbar = new TableRow.LayoutParams( ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        table_row_seekbar.weight = 1;


        TableRow.LayoutParams table_row_label_LEFT = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        table_row_label_LEFT.weight = 1;
        table_row_label_LEFT.width = 0;
        table_row_label_LEFT.bottomMargin = 50;
        //table_row_label_LEFT.gravity = Gravity.START;

        TableRow.LayoutParams table_row_label_RIGHT = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        table_row_label_RIGHT.weight = 1;
        table_row_label_RIGHT.width = 0;
        table_row_label_RIGHT.bottomMargin = 50;
        //table_row_label_RIGHT.gravity = Gravity.END;

        TableRow.LayoutParams Button_close= new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        Button_close.topMargin = 30;

        TextView [] pertanyaan = new TextView[36];
        TextView [] kiri = new TextView[36];
        TextView [] kanan = new TextView[36];
        TableRow [] tr = new TableRow[37];
        SeekBar [] s = new SeekBar[36];

        Button kiri_teonom = new Button(this);
        Button kanan_teonom = new Button(this);

        kanan_teonom.setLayoutParams(table_row_label_RIGHT);
        kiri_teonom.setLayoutParams(table_row_label_RIGHT);

        kanan_teonom.setText(R.string.teonom_button_right);
        kiri_teonom.setText(R.string.teonom_button);

        kanan_teonom.setTypeface(Typeface.DEFAULT_BOLD);
        kiri_teonom.setTypeface(Typeface.DEFAULT_BOLD);

        kanan_teonom.setTextColor(getResources().getColor(R.color.white));
        kiri_teonom.setTextColor(getResources().getColor(R.color.white));

        close.setLayoutParams(Button_close);
        close.setText(R.string.close);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            kiri_teonom.setBackground(getResources().getDrawable(R.drawable.teonom_button));
            kanan_teonom.setBackground(getResources().getDrawable(R.drawable.teonom_button_right));
        }


        int frag_1_0 = FRAGMENT_SHIT.getInt(KEY+0+0,0);
        int frag_1_1 = FRAGMENT_SHIT.getInt(KEY+0+1,0);
        int frag_2_0 = FRAGMENT_SHIT.getInt(KEY+1+0,0);
        int frag_2_1  = FRAGMENT_SHIT.getInt(KEY+1+1,0);
        int frag_3_0  = FRAGMENT_SHIT.getInt(KEY+2+0,0);
        int frag_3_1 = FRAGMENT_SHIT.getInt(KEY+2+1,0);
        int frag_3_2 = FRAGMENT_SHIT.getInt(KEY+2+2,0);
        int frag_3_3 = FRAGMENT_SHIT.getInt(KEY+2+3,0);
        int frag_4_0 = FRAGMENT_SHIT.getInt(KEY+3+0,0);
        int frag_4_1 = FRAGMENT_SHIT.getInt(KEY+3+1,0);
        int frag_5_0 = FRAGMENT_SHIT.getInt(KEY+4+0,0);
        int frag_5_1 = FRAGMENT_SHIT.getInt(KEY+4+1,0);



        String[] question = getResources().getStringArray(R.array.pertanyaan_log);

        int temp =1;
        for(int i = 0; i < 36 ; i++){
            pertanyaan[i] = new TextView(this);
            kiri[i]  = new TextView(this);
            kanan[i]  = new TextView(this);
            s[i] = new SeekBar(this);
            tr[i] = new TableRow(this);


            pertanyaan[i].setLayoutParams(table_row_pertanyaan);
            pertanyaan[i].setPadding(5,5,5,5);
            pertanyaan[i].setBackgroundColor(getResources().getColor(R.color.TransLightSteelBlue));

            s[i].setLayoutParams(table_row_seekbar);
            s[i].setProgressDrawable(getResources().getDrawable(R.drawable.progress_color));
            s[i].setThumb(getResources().getDrawable(R.drawable.triangle));

            kanan[i].setTypeface(Typeface.DEFAULT_BOLD);
                kanan[i].setGravity(Gravity.START);

            kanan[i].setLayoutParams(table_row_label_RIGHT);


            kiri[i].setTypeface(Typeface.DEFAULT_BOLD);

            kiri[i].setGravity(Gravity.END);

            kiri[i].setLayoutParams(table_row_label_RIGHT);


            if(i == temp){
                s[i].setEnabled(false);
                s[i].setMax(10);

                if(i==31){
                    s[i].setVisibility(View.GONE);

                    if(frag_5_0==0){
                        kiri_teonom.setEnabled(false);
                    }
                    else{
                        kanan_teonom.setEnabled(false);
                    }
                    tr[i].addView(kiri_teonom);
                    tr[i].addView(kanan_teonom);

                }
                if(temp==34){
                    s[1].setProgress(frag_1_0);
                    s[4].setProgress(frag_1_1);
                    s[7].setProgress(frag_2_0);
                    s[10].setProgress(frag_2_1);
                    s[13].setProgress(frag_3_0);
                    s[16].setProgress(frag_3_1);
                    s[19].setProgress(frag_3_2);
                    s[22].setProgress(frag_3_3);
                    s[25].setProgress(frag_4_0);
                    s[28].setProgress(frag_4_1);
                    s[34].setProgress(frag_5_1);
                }

                tr[i].addView(s[i]);

                temp  = temp + 3;

            }
            else if(i%3==0){
                pertanyaan[i].setText(question[i]);
                tr[i].addView(pertanyaan[i]);
            }
            else{

                if(i==32){
                    kanan[i].setVisibility(View.GONE);
                    kiri[i].setVisibility(View.GONE);
                }
                else {
                    kanan[i].setText(question[(i - 1)]);
                    kiri[i].setText(question[i]);
                    tr[i].addView(kanan[i]);
                    tr[i].addView(kiri[i]);
                }
            }

            tl.addView(tr[i]);

        }

        tr[36] = new TableRow(this);
        tr[36].addView(close);
        tl.addView(tr[36]);
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


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
