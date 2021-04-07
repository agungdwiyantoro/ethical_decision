package com.example.mycomputer.a200ribu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

import static com.example.mycomputer.a200ribu.fragment6.FRAGMENT6;

/**
 * Created by My Computer on 1/13/2018.
 */

public class test_screen_slide extends FragmentActivity implements test_ChildFragment.for_position{


    ViewPager viewpager;
    Button button_continue;

    GifImageView imageView_1, imageView_2;
    TextView textView_1, textView_2;
    static int imageview;
    Button show_question;
    static int x = 0;

    int[]gambar_1 = {R.drawable.family, R.drawable.final_justice, R.drawable.justice, R.drawable.godhand, R.drawable.caring, R.drawable.instrucone};
    int[]gambar_2 = {R.drawable.chart, R.drawable.instructwo};
    public int[]fragment_index = {2, 2, 4, 2, 2};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_screen_slide);

        Button back_icon = findViewById(R.id.back_icon);

        imageView_1 = (GifImageView) findViewById(R.id.image_1);
        imageView_2 = (GifImageView)  findViewById(R.id.image_2);

        textView_1 = findViewById(R.id.text_view_1);
        textView_2 = findViewById(R.id.text_view_2);

        show_question = findViewById(R.id.question);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            //imageView_1.setBackground(getResources().getDrawable(gambar_1[0]));
            imageView_1.setBackgroundResource(gambar_1[imageview]);
        }

        viewpager = findViewById(R.id.view_pager);
        viewpager.setPageTransformer(false, new ZoomOutPageTransformer());
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
    public void get_position(int position, int imageview) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            System.out.println("position screen slide " + position);
            this.imageview = imageview;
            imageView_1.setBackgroundResource(gambar_1[imageview]);



//            imageView_2.setBackground(getResources().getDrawable(gambar_2[position]));
            viewpager.setCurrentItem(position);
        }
    }


    private class ScreenSlideAdapter extends FragmentPagerAdapter {


        ScreenSlideAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
      //      System.out.println("POSITION ESSAY " + position);

            Bundle args = new Bundle();


            x= position;
            args.putInt("test_sc", x);
            //  args.putInt(ChildFragment.FRAGMENT_POSITION_KEY, 0);
            return  test_ChildFragment.newInstance(args);
            //return fragment_choice(0);
        }

        @Override
        public int getCount() {
            return fragment_index[x];
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return (position+1) + "/" + fragment_index[position];
        }


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
