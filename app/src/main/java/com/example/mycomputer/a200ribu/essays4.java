package com.example.mycomputer.a200ribu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class essays4 extends Fragment implements View.OnClickListener, ViewPager.OnPageChangeListener{



    private static final int NUM_PAGES = 2;

    ViewPager viewPager;

    screen_slide x;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.pagestripviewpager, container,false);

     //   WebView desc = (WebView) viewGroup.findViewById(R.id.web_view);
     //   desc.setBackgroundColor(Color.TRANSPARENT);
      //  desc.loadUrl("file:///android_asset/utilitarianisme.html");

        return viewGroup;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onClick(View v) {

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

    public static class MyAdapter extends FragmentPagerAdapter {

        MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public Fragment getItem(int position) {
            Bundle args = new Bundle();

           args.putInt("iffy", position);
           // args.putInt(ChildFragment.FRAGMENT_POSITION_KEY, 0);

            return ChildFragment.newInstance(args);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return (position+1) + "/" + NUM_PAGES;
        }



    }

}
