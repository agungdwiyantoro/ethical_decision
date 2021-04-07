package com.example.mycomputer.a200ribu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by My Computer on 1/15/2018.
 */

public class opening extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.opening, container,false);



        //    WebView desc = (WebView) viewGroup.findViewById(R.id.web_view);
//      desc.setBackgroundColor(Color.TRANSPARENT);
  //    desc.loadUrl("file:///android_asset/angel_devil.html");

        return viewGroup;
    }
}
