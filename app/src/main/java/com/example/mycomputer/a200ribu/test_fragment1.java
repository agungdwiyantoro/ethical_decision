package com.example.mycomputer.a200ribu;

/**
 * Created by My Computer on 1/13/2018.
 */
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

public class test_fragment1 extends Fragment implements View.OnClickListener, ViewPager.OnPageChangeListener{



    private static final int NUM_PAGES = 2;

    ViewPager viewPager;

    screen_slide x;

    public static test_fragment1 newInstance(Bundle args) {
        test_fragment1 fragment = new test_fragment1();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment1, container,false);

        WebView desc = (WebView) viewGroup.findViewById(R.id.web_view);
        desc.setBackgroundColor(Color.TRANSPARENT);
        desc.loadUrl("file:///android_asset/utilitarianisme.html");

        return viewGroup;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager =  view.findViewById(R.id.viewPager_fragment1);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        viewPager.addOnPageChangeListener(this);

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

            args.putInt(ChildFragment.POSITION_KEY, position);
            args.putInt(ChildFragment.FRAGMENT_POSITION_KEY, 0);
            return ChildFragment.newInstance(args);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return (position+1) + "/" + NUM_PAGES;
        }



    }

}

 /*
        @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }


    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if(seekBar.getId()==R.id.seekbar_uq1){
            Toast.makeText(getActivity(), ""+ seekBar.getProgress(),
                    Toast.LENGTH_SHORT).show();
            editor.putInt(f1q1, seekBar.getProgress());
            //seekbar_f1q1.setProgress(seekBar.getProgress());
        }
        else if(seekBar.getId() == R.id.seekBar_uq2){
            Toast.makeText(getActivity(), ""+ seekBar.getProgress(),
                    Toast.LENGTH_SHORT).show();
            editor.putInt(f1q2, seekBar.getProgress());
          //  seekbar_f1q2.setProgress(seekBar.getProgress());
        }




        editor.apply();


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


    private class ScreenSlideAdapter extends FragmentStatePagerAdapter {

        public ScreenSlideAdapter(FragmentManager fm) {
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
*/



