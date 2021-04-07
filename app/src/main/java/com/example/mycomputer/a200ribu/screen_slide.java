package com.example.mycomputer.a200ribu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.example.mycomputer.a200ribu.fragment2.f2q1;
import static com.example.mycomputer.a200ribu.fragment6.FRAGMENT6;
import static com.example.mycomputer.a200ribu.fragment6.f6q1;
import static com.example.mycomputer.a200ribu.fragment6.f6q2;
import static com.example.mycomputer.a200ribu.fragment6.f6q3;
import static com.example.mycomputer.a200ribu.fragment6.f6q4;
import static com.example.mycomputer.a200ribu.fragment6.f6q5;

/**
 * Created by My Computer on 1/13/2018.
 */

public class screen_slide extends FragmentActivity implements View.OnClickListener {
    private static final int NUM_PAGES = 7;
    private ViewPager viewPager;

    public Button getContinue_button() {
        return continue_button;
    }

    private Button continue_button;
    private TextView textView_bar;

    private Dialog mydialog;

    private boolean pass = true;
    SharedPreferences FRAGMENT6_S;

    SharedPreferences FRAGMENT_SHIT;
    public static final String SCREENSLIDE = "screenSlide" ;
    public static final String KEY = "KEY";




    private String[]cases_string = {"Rerangka Pengambilan Keputusan Etis","Utilitarianisme", "Deontologi", "Right atau Keadilan", "Virtue atau Kebajikan", "Teonom","Ukur Pendekatan"};
    private static int index;
    fragment6 f6;
    int f6_total;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_slide);

        FRAGMENT6_S = getSharedPreferences(FRAGMENT6, Context.MODE_PRIVATE);
        FRAGMENT_SHIT = getSharedPreferences(KEY, Context.MODE_PRIVATE);



        textView_bar =  findViewById(R.id.tv_bar_approach);
        viewPager =  findViewById(R.id.view_pager);
        Button about = findViewById(R.id.about);



        mydialog = new Dialog(screen_slide.this);
        mydialog.setContentView(R.layout.about);
        mydialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //viewPager.setPageTransformer(false, new ZoomOutPageTransformer());
      //  PagerAdapter pagerAdapter = new ScreenSlideAdapter(getSupportFragmentManager());


      //  viewPager.setAdapter(pagerAdapter);


        textView_bar.setText(cases_string[index]);

        Button back_button = (Button) findViewById(R.id.back_icon);
        continue_button = (Button) findViewById(R.id.button_continue);


        back_button.setOnClickListener(this);


        continue_button.setOnClickListener(this);

       about.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button_continue :


             //   System.out.println("ITEM " + viewPager.getCurrentItem() );


               // viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                /*
                index = getItem(1);

                if(index > 0 && index < 6){
                    getContinue_button().setVisibility(View.GONE);
                }

                if(index <0) {
                    index = 0;
                }

                else if(index>6){

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

                    System.out.println("frag " + frag_1_0);
                    System.out.println("frag " + frag_1_1);
                    System.out.println("frag " + frag_2_0);
                    System.out.println("frag " + frag_2_1);
                    System.out.println("frag " + frag_3_0);
                    System.out.println("frag " + frag_3_1);
                    System.out.println("frag " + frag_3_2);
                    System.out.println("frag " + frag_3_3);
                    System.out.println("frag " + frag_4_0);
                    System.out.println("frag " + frag_4_1);
                    System.out.println("frag " + frag_5_0);
                    System.out.println("frag " + frag_5_1);



                    int frag_6_0 = FRAGMENT6_S.getInt(f6q1,0);
                    int frag_6_1 = FRAGMENT6_S.getInt(f6q2,0);
                    int frag_6_2 = FRAGMENT6_S.getInt(f6q3,0);
                    int frag_6_3 = FRAGMENT6_S.getInt(f6q4,0);
                    int frag_6_4 = FRAGMENT6_S.getInt(f6q5,0);
                    f6_total = frag_6_0 + frag_6_1 + frag_6_2 + frag_6_3 + frag_6_4;

                    System.out.println("FRAGMENT 6 total " + f6_total);

                //    FRAGMENT_SHIT.edit().apply();
               //     FRAGMENT6_S.edit().clear().apply();
//


                    int nilai_frag1 = (frag_1_0 + frag_1_1) / 2;
                    int nilai_frag2 = (frag_2_0 + frag_2_1) / 2;
                    int nilai_frag3_ganti = 0;

                    if(frag_3_2 < frag_3_3){
                        nilai_frag3_ganti = frag_3_3;
                    }
                    else if (frag_3_2 > frag_3_3){
                        nilai_frag3_ganti = frag_3_2;
                    }
                    else{
                        nilai_frag3_ganti = frag_3_2;
                    }
                    int nilai_frag3 = (frag_3_0 + frag_3_1 + nilai_frag3_ganti) / 3;

                    int nilai_frag4 = (frag_4_0 + frag_4_1) / 2;
                    int nilai_frag5 = ((frag_5_0*10) + frag_5_1) / 2;

                    int nilai_bobot_f1 = nilai_frag1 * 20;
                    int nilai_bobot_f2 = nilai_frag2 * 20;
                    int nilai_bobot_f3 = nilai_frag3 * 20;
                    int nilai_bobot_f4 = nilai_frag4 * 20;
                    int nilai_bobot_f5 = nilai_frag5 * 20;

                    System.out.println("bobot " + nilai_bobot_f1);
                    System.out.println("bobot " + nilai_bobot_f2);
                    System.out.println("bobot " + nilai_bobot_f3);
                    System.out.println("bobot " + nilai_bobot_f4);
                    System.out.println("bobot " + nilai_bobot_f5);

                    int nilaiAkhir = (nilai_bobot_f1 + nilai_bobot_f2 + nilai_bobot_f3 + nilai_bobot_f4 + nilai_bobot_f5);

                    System.out.println("NILAI AKHIR is " + nilaiAkhir);
                //    FRAGMENT6_S = getSharedPreferences(FRAGMENT6, Context.MODE_PRIVATE);

/*
                    int_utilitarianisme = Integer.parseInt(f6.getUtilitarianisme().getText().toString());
                    int_deontologi = Integer.parseInt(f6.getDeontologi().getText().toString());
                    int_right= Integer.parseInt(f6.getRight().toString());
                    int_virtue = Integer.parseInt(f6.getVirtue().getText().toString());
                    int_teonom = Integer.parseInt(f6.getTeonom().getText().toString());

                    int total = int_utilitarianisme + int_deontologi + int_right + int_virtue + int_teonom;

                    System.out.println("total is fucking " + total);
                    if(total > 100 || total < 100){
                        Toast.makeText(this, "Total nilai harus 100", Toast.LENGTH_SHORT).show();
                        //FRAGMENT6_S.edit().clear().apply();
                        //pass = false;
                        textView_bar.setText(cases_string[6]);

                        viewPager.setCurrentItem(6, true);
                        //index = 5;

                    }
                    else {

                        Intent shit = new Intent(screen_slide.this, hasil.class);

                        shit.putExtra("NIGGA", nilaiAkhir);

                        startActivity(shit);


                        index = 6;
                        finish();
           //      }
                }




                   if (index == 6) {


                       continue_button.setText(R.string.view_result);



                       continue_button.setVisibility(View.GONE);
                }

            //    if(pass) {

                    textView_bar.setText(cases_string[index]);

                    viewPager.setCurrentItem(index, true);
                System.out.println("INDEX IS " + index);
         //       }

        */
                break;

            case R.id.back_icon :
                index = backItem(1);
                if(index > 0 && index < 6){

                    getContinue_button().setVisibility(View.VISIBLE);
                }

                if(index <=0) {
                    index = 0;
                    Intent back_home = new Intent(screen_slide.this, MainActivity.class);
                    startActivity(back_home);
                    finish();
                }

                else if(index>6){
                    index=6;
                }
                textView_bar.setText(cases_string[index]);
            //    viewPager.setCurrentItem(index, true);
                if(index!=6){
                    continue_button.setText(R.string.continue_button);


                }
                System.out.println("INDEX IS " + index);
            break;


            case R.id.about :

                mydialog.show();

                break;



        }
    }





    private class ScreenSlideAdapter extends FragmentPagerAdapter {


        ScreenSlideAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragment_choice(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }


    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(@NonNull View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }

        }
    }

    private Fragment fragment_choice(int index){
        Fragment fragment = null;
        switch (index){
            case 0 : fragment = new opening();
            break;
            case 1 : fragment = new fragment1();
            break;
            case 2 : fragment = new fragment2();
            break;
            case 3 : fragment = new fragment3();
            break;
            case 4 : fragment = new fragment4();
            break;
            case 5 : fragment = new fragment5();
            break;
            case 6 : fragment = new fragment6();
            break;
        }
        return fragment;
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private int backItem(int i) {
        return viewPager.getCurrentItem() - i;
    }


    @Override
    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
          //  super.onBackPressed();
            //additional code
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(screen_slide.this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(screen_slide.this);
            }
            builder.setMessage("Keluar Aplikasi ?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                            finish();
                            System.exit(0);
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert).create()
                    .show();
        } else {
           getFragmentManager().popBackStack();
        }

    }

}
