package com.example.mycomputer.a200ribu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class essayChildFragment extends Fragment {

    int index;
    TextView tv_pertanyaan;
    EditText et_pertanyaan;
    Button button_continue, plus, minus;

    EditText[]tv;
    static int max_editText, counter;
    data_string ds;

    DATABASE_HELPER_ESSAY dhe;
    public static essayChildFragment newInstance(Bundle index) {
        essayChildFragment fragment = new essayChildFragment();
        fragment.setArguments(index);
        return fragment;
    }

    int[]id_pertanyaan = {R.string.b1, R.string.b2, R.string.b3, R.string.b4};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.essaychildfragment, container, false);
        dhe = new DATABASE_HELPER_ESSAY(getContext());

        tv_pertanyaan = root.findViewById(R.id.tv_pertanyaan);
        et_pertanyaan = root.findViewById(R.id.et_essay);

        max_editText = 10;

System.out.println("MASUK ONCREATE ESSAY");
      //  et_pertanyaan_string = et_pertanyaan.getText().toString();
        index = getArguments().getInt("test");
        tv_pertanyaan.setText(id_pertanyaan[index]);
        tv = new EditText[10];
      //  Bundle args = new Bundle();
      //  args.putString("effay", et_pertanyaan_string);
        //dhe.delete_all();

        button_continue = root.findViewById(R.id.button_continue);
        plus = root.findViewById(R.id.plus);
        minus = root.findViewById(R.id.minus);
        final LinearLayout layout= root.findViewById(R.id.linear_layout);
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        System.out.println("COUNTER IS " + counter + " max " + max_editText);

        if(index==3){
            et_pertanyaan.setVisibility(View.GONE);
            plus.setVisibility(View.VISIBLE);
            minus.setVisibility(View.VISIBLE);


            for(counter =0 ; counter < max_editText ; counter++) {
                System.out.println("COUNTER IS " + counter + " max " + max_editText);
                tv[counter] = new EditText(getContext());
                tv[counter].setHint("Urutan " + String.valueOf(counter+1));
                tv[counter].setLayoutParams(layoutParams);
                tv[counter].setInputType(InputType.TYPE_CLASS_TEXT);

                if(counter>=3) {

                    tv[counter].setNextFocusDownId(R.id.button_continue);

                }
                else
                {
                    tv[counter].setImeOptions(EditorInfo.IME_ACTION_NEXT);
                }
                layout.addView(tv[counter]);

                if(counter>3){
                    tv[counter].setVisibility(View.GONE);
                }

            }
//            tv[3].requestFocus();


            counter=3;
        }
        else
        {
            minus.setVisibility(View.GONE);
            plus.setVisibility(View.GONE);
            et_pertanyaan.setVisibility(View.VISIBLE);
        }

       // onGetDataString();

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter=counter+1;
                //max_editText=max_editText+1;
                tv[counter].setVisibility(View.VISIBLE);
                //tv[counter].setNextFocusDownId(R.id.button_continue);
                tv[counter].requestFocus();
                System.out.println("COUNTER IS " + counter);
            }
        });


        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(counter==1){


                    System.out.println("COUNTER IS " + counter);
                }
                else{
                    tv[counter].setVisibility(View.GONE);
                  //  tv[counter].setNextFocusDownId(R.id.button_continue);
                    tv[counter].requestFocus();
                    counter=counter-1;
                }


                System.out.println("COUNTER IS " + counter);
            }
        });

        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dhe.deleteData(index);
               if(index==3)
               {
                   for(int x = 0 ; x <= counter ; x++) {
                       //dhe.deleteData(index);
                       dhe.insertData(index, tv[x].getText().toString(), x);
                       System.out.println(dhe.getData(index,x).getString(1) +  " and " + index);

                   }
               }
               else
               {
                   dhe.insertData(index, et_pertanyaan.getText().toString(), index);
                   System.out.println(dhe.getData(index,index).getString(1) +  " and " + index);

               }
               buttonPressed(index+1);


//                Toast.makeText(getContext(),  "Jawaban Anda Sudah Disimpan", Toast.LENGTH_SHORT).show();


               // System.out.println("index is " + index);

                //      Bundle bundle = new Bundle();
          //      bundle.putInt("iffy", index+1);
              //  new essay_pager_content.MyAdapter(getChildFragmentManager()).getItem(index+1);
           //     new essayChildFragment().newInstance(bundle);
                // Intent menu_utama = new Intent(getContext(), screen_slide.class);
                //  startActivity(menu_utama);
            }
        });






//        System.out.println("POSITION IS " + getArguments().get("iffy"));

      //  dhe.insertData(index, et_pertanyaan.getText().toString(), getArguments().getInt("iffy"));
     //   System.out.println(dhe.getData(index).getString(1) +  " and " + getArguments().getInt("iffy"));
     /*  Button button_continue = root.findViewById(R.id.button_continue);

        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        */
        return root;
    }



             @Override
             public void onDetach() {
                 super.onDetach();
                 ds=null;
             }

             @Override
             public void onAttach(Context context) {
                 super.onAttach(context);
                 try{


                     ds=(data_string) getActivity();



                 }catch(ClassCastException e){
                     throw new ClassCastException(getActivity().toString() + "oh boi");
                 }
             }

    public interface data_string{
        void onGetDataString(int index);

    }

    public void buttonPressed(int index){
        if(ds!=null)
            ds.onGetDataString(index);


    }
}
