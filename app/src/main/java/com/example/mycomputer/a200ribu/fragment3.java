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

public class fragment3 extends Fragment implements View.OnClickListener,ViewPager.OnPageChangeListener{




    ViewPager viewPager;
    private static final int NUM_PAGES = 4;
    screen_slide x;

    boolean toggle;
    Button question;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment3, container,false);

        WebView desc = viewGroup.findViewById(R.id.webView);

        desc.setBackgroundColor(Color.TRANSPARENT);
        desc.loadUrl("file:///android_asset/right.html");

        toggle = false;

        WebView desc2 = viewGroup.findViewById(R.id.webView2);

        desc2.setBackgroundColor(Color.TRANSPARENT);
        desc2.loadUrl("file:///android_asset/right2.html");
        question = viewGroup.findViewById(R.id.question);
        question.setOnClickListener(this);
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
        if(!toggle)
        {
            viewPager.setVisibility(View.VISIBLE);
            question.setText(R.string.button_hide_question);
            toggle = true;
        }
        else{
            viewPager.setVisibility(View.GONE);
            question.setText(R.string.button_show_question);
            x.getContinue_button().setVisibility(View.GONE);
            toggle = false;
        }
    }


    public static class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Fragment getItem(int position) {
            Bundle args = new Bundle();
            args.putInt(ChildFragment.POSITION_KEY, position);
            args.putInt(ChildFragment.FRAGMENT_POSITION_KEY, 2);
            return ChildFragment.newInstance(args);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return (position+1) + "/" + 4;
        }

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager =  view.findViewById(R.id.viewPager_utilitarianisme_question);
        viewPager.setAdapter(new fragment3.MyAdapter(getChildFragmentManager()));
        viewPager.addOnPageChangeListener(this);

    }



}
