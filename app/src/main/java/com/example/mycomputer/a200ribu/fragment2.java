package com.example.mycomputer.a200ribu;

/**
 * Created by My Computer on 1/13/2018.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class fragment2 extends Fragment implements View.OnClickListener, ViewPager.OnPageChangeListener/*implements SeekBar.OnSeekBarChangeListener*/ {

    private static final int NUM_PAGES = 2;
    public static final String f2q1 = "f2q1";
    public static final String f2q2 = "f2q2";

    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    ViewPager viewPager;
    screen_slide x;
    boolean toggle;

    Button question;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        toggle = false;
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment2, container,false);

      //  question = viewGroup.findViewById(R.id.question);

//        question.setOnClickListener(this);

        x = (screen_slide) getActivity();

        return viewGroup;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        System.out.println("OnPageSelectedNigga");

        if(position==(NUM_PAGES-1)){
            x.getContinue_button().setVisibility(View.VISIBLE);
        }

        else{
            x.getContinue_button().setVisibility(View.GONE);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        if(!toggle){
            question.setText(R.string.button_hide_question);
            viewPager.setVisibility(View.VISIBLE);
            x.getContinue_button().setVisibility(View.GONE);
            toggle = true;
        }
        else{
            question.setText(R.string.button_show_question);
            x.getContinue_button().setVisibility(View.VISIBLE);
            viewPager.setVisibility(View.GONE);
            toggle = false;
        }

    }


    public static class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public Fragment getItem(int position) {
            Bundle args = new Bundle();
            args.putInt(ChildFragment.POSITION_KEY, position);
            args.putInt(ChildFragment.FRAGMENT_POSITION_KEY, 1);
            return ChildFragment.newInstance(args);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return (position+1) + "/" + 2;
        }

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager =  view.findViewById(R.id.viewPager_utilitarianisme_question);
        viewPager.setAdapter(new fragment2.MyAdapter(getChildFragmentManager()));
        viewPager.addOnPageChangeListener(this);

    }

}
