package com.example.mycomputer.a200ribu;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class essays extends FragmentActivity implements essayChildFragment.data_string, ViewPager.OnPageChangeListener{


    Button back_button;
    ViewPager viewpager;
    Button button_continue;


  static int x = 0;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.essays);

        viewpager = findViewById(R.id.view_pager);
       // back_button = findViewById(R.id.back_icon);
        //button_continue = findViewById(R.id.button_continue);


       Button back_icon = findViewById(R.id.back_icon);

        viewpager.setPageTransformer(false,new ZoomOutPageTransformer());
        PagerAdapter pagerAdapter = new ScreenSlideAdapter(getSupportFragmentManager());
        viewpager.setAdapter(pagerAdapter);




        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(x>=0&&x<=3) {

                    x--;
                    viewpager.setCurrentItem(x);

                }
                else{
                    x = 0;
                }
            }
        });

    }

    @Override
    public void onGetDataString(int index) {
      //
       x=index;

        if(x>3){

            Intent to_screen_slide = new Intent(essays.this, screen_slide.class);
            startActivity(to_screen_slide);
            finish();
        }
        else {
            System.out.println("FUCK NUT" + x+ " s " + viewpager.getCurrentItem());
            viewpager.setCurrentItem(x);

            ///new ScreenSlideAdapter(getSupportFragmentManager()).getPageTitle(index);
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    private class ScreenSlideAdapter extends FragmentPagerAdapter {


        ScreenSlideAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            System.out.println("POSITION ESSAY " + position);

            Bundle args = new Bundle();


            x= position;
            args.putInt("test", x);
          //  args.putInt(ChildFragment.FRAGMENT_POSITION_KEY, 0);
            return  essayChildFragment.newInstance(args);
            //return fragment_choice(0);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return (position+1) + "/" + 4;
        }


    }




    private Fragment fragment_choice(int index){
        Fragment fragment = null;
        switch (index){
            case 0 : fragment = new essayChildFragment();
                break;
        }
        return fragment;
    }
    private int getItem(int i) {
        return viewpager.getCurrentItem() + i;
    }

    private int backItem(int i) {
        return viewpager.getCurrentItem() - i;
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransitionEnter();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransitionExit();
    }

    protected void overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.act_slide_from_right, R.anim.act_tran_slide_to_left);
    }

    protected void overridePendingTransitionExit() {
        overridePendingTransition(R.anim.act_slide_from_left, R.anim.act_trans_slide_to_right);
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(essays.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(essays.this);
        }
        builder.setMessage("Keluar Aplikasi ?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
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

    }

  class ZoomOutPageTransformer implements ViewPager.PageTransformer {
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


}
