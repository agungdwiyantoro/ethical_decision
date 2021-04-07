package com.example.mycomputer.a200ribu;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.Toast;



/**
 * Created by My Computer on 1/14/2018.
 */

public class fragment6 extends Fragment implements View.OnClickListener{

    public static final String FRAGMENT6 = "fragment6" ;
    public static final String f6q1 = "f6q1";
    public static final String f6q2 = "f6q2";
    public static final String f6q3 = "f6q3";
    public static final String f6q4 = "f6q4";
    public static final String f6q5 = "f6q5";

    SharedPreferences sharedpreferences;
    public SharedPreferences.Editor editor_f6;


    public EditText getUtilitarianisme() {
        return utilitarianisme;
    }

    public EditText getDeontologi() {
        return deontologi;
    }

    public EditText getRight() {
        return right;
    }

    public EditText getVirtue() {
        return virtue;
    }

    public EditText getTeonom() {
        return teonom;
    }

    EditText utilitarianisme;
    EditText deontologi;
    EditText right;
    EditText virtue;
    EditText teonom;

    boolean toggle;
   // TableLayout forms;
   // Button show_hide_form;
    screen_slide sc;

    Button OK, Edit;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment6, container,false);

        sc = (screen_slide) getActivity();
        toggle = false;

        WebView desc = (WebView) viewGroup.findViewById(R.id.web_view);
        WebView desc2 = (WebView) viewGroup.findViewById(R.id.web_view2);
        WebView desc3 = (WebView) viewGroup.findViewById(R.id.web_view3);

        OK = viewGroup.findViewById(R.id.OK);
        OK.setOnClickListener(this);

        Edit = viewGroup.findViewById(R.id.Edit);
        Edit.setOnClickListener(this);
      //  show_hide_form = viewGroup.findViewById(R.id.button_question);

        utilitarianisme = viewGroup.findViewById(R.id.et_utilitarianisme);
        deontologi = viewGroup.findViewById(R.id.et_deontologi);
        right = viewGroup.findViewById(R.id.et_right);
        virtue = viewGroup.findViewById(R.id.et_virtue);
        teonom = viewGroup.findViewById(R.id.et_teonom);


    //   forms = viewGroup.findViewById(R.id.table_layout);

//      show_hide_form.setOnClickListener(this);


        desc.setBackgroundColor(Color.TRANSPARENT);
        desc.loadUrl("file:///android_asset/desc_fragment_6.html");


        desc2.setBackgroundColor(Color.TRANSPARENT);
        desc2.loadUrl("file:///android_asset/desc_fragment_6_1.html");



        desc3.setBackgroundColor(Color.TRANSPARENT);
        desc3.loadUrl("file:///android_asset/desc_fragment_6_2.html");



        return viewGroup;
    }


    @Override
    public void onPause() {
        super.onPause();
        /*

        int total = int_utilitarianisme + int_deontologi + int_right + int_virtue + int_teonom;
        sharedpreferences = getActivity().getSharedPreferences(FRAGMENT6, Context.MODE_PRIVATE);
        editor_f6 = sharedpreferences.edit();
        editor_f6.putInt(f6q1, total);
        editor_f6.apply();
        */
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("Nigga on STOP");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("Nigga on DESTROY VIEW");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Nigga on DESTROY");
    }


    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("Nigga on DETACH");


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.OK:
                int total = Integer.parseInt(utilitarianisme.getText().toString())
                        + Integer.parseInt(deontologi.getText().toString())
                        + Integer.parseInt(right.getText().toString())
                        + Integer.parseInt(virtue.getText().toString())
                        + Integer.parseInt(teonom.getText().toString());


                if(total<100||total>100){
                    Toast.makeText(getActivity(), "jumlah harus 100", Toast.LENGTH_SHORT).show();

                }
                else{
                    sc.getContinue_button().setVisibility(View.VISIBLE);
                    OK.setVisibility(View.GONE);
                    Edit.setVisibility(View.VISIBLE);
                    utilitarianisme.setEnabled(false);
                    deontologi.setEnabled(false);
                    right.setEnabled(false);
                    virtue.setEnabled(false);
                    teonom.setEnabled(false);


                }

                break;
            case R.id.Edit:

                sc.getContinue_button().setVisibility(View.GONE);
                OK.setVisibility(View.VISIBLE);
                Edit.setVisibility(View.GONE);
                utilitarianisme.setEnabled(true);
                deontologi.setEnabled(true);
                right.setEnabled(true);
                virtue.setEnabled(true);
                teonom.setEnabled(true);

                break;
        }
      //  System.out.println("Nigga on PAUSE");



        /*
        if(!toggle){
            show_hide_form.setText(R.string.button_show_form);
            sc.getContinue_button().setVisibility(View.GONE);
            forms.setVisibility(View.VISIBLE);

            toggle = true;
        }
        else
        {
            show_hide_form.setText(R.string.button_hide_form);
            sc.getContinue_button().setVisibility(View.VISIBLE);

            forms.setVisibility(View.GONE);

            toggle = false;
        }

        */
    }
}