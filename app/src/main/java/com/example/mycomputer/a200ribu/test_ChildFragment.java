package com.example.mycomputer.a200ribu;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The child fragment is no different than any other fragment other than it is now being maintained by
 * a child FragmentManager.
 */
public class test_ChildFragment extends Fragment implements OnClickListener, SeekBar.OnSeekBarChangeListener {

    public static final String POSITION_KEY = "FragmentPositionKey";
    public static final String FRAGMENT_POSITION_KEY = "FragmentPositionKey2";
    public static final String KEY = "KEY";
    static int position;

    static int fragment_slide;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;


    Button button_teonom_left;
    Button button_teonom_right;
    Button button_continue;

    public for_position fr;
    test_screen_slide tsc;

    static int akumulasi;
    public static test_ChildFragment newInstance(Bundle args) {
        test_ChildFragment fragment = new test_ChildFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        position = getArguments().getInt("test_sc");//getArguments().getInt(POSITION_KEY);
       // fragment_slide = 0;//getArguments().getInt(FRAGMENT_POSITION_KEY);

akumulasi=0;
fragment_slide = 0;
tsc = new test_screen_slide();


      //  x.getContinue_button().setEnabled(false);


        View root = inflater.inflate(R.layout.test_fragment_child, container, false);
        TextView right_label = (TextView) root.findViewById(R.id.tv_label_right);
        TextView left_label = (TextView) root.findViewById(R.id.tv_label_left);
        TextView question_label = (TextView) root.findViewById(R.id.tv_pertanyaan);
        button_teonom_left = (Button) root.findViewById(R.id.left_label);
        button_teonom_right = (Button) root.findViewById(R.id.right_label);

        TableRow teonom = (TableRow) root.findViewById(R.id.row_button_teonom);
        TableRow teonom_seekbar = (TableRow) root.findViewById(R.id.row_seekbar_teonom);
        TableRow label_seekbar = (TableRow) root.findViewById(R.id.label_seekbar);
        SeekBar seekBar = (SeekBar) root.findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(this);

        button_continue = root.findViewById(R.id.button_continue);
        button_continue.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


            //    fragment_index = getArguments().getInt("imageview");
                System.out.println("fragment_slide " + fragment_slide);
                System.out.println("Fragment index " + tsc.fragment_index[fragment_slide]);
                System.out.println("position " + position);
                System.out.println("akumulasi " + akumulasi);

                if(akumulasi<= (tsc.fragment_index[fragment_slide]-1)){
                  // getPosition(0,fragment_slide);
                    position++;
                    akumulasi++;
                    System.out.println("if");





                }
                else {

                  //  position = 0;
                    akumulasi = 0;
                    fragment_slide++;
                    System.out.println("else");
                  //   System.out.println("AKumulasi " + akumulasi);
//

                }

                getPosition(akumulasi, fragment_slide);

            }
        });

    ///    sharedpreferences = getActivity().getSharedPreferences(KEY, Context.MODE_PRIVATE);
      ///  editor = sharedpreferences.edit();

        if(position==0 && fragment_slide==4){
            teonom.setVisibility(View.VISIBLE);
            teonom_seekbar.setVisibility(View.GONE);
            label_seekbar.setVisibility(View.GONE);
        }
        else{
            teonom.setVisibility(View.GONE);
            teonom_seekbar.setVisibility(View.VISIBLE);
//            editor.putInt(KEY + fragment_slide + position, seekBar.getProgress());
          //  editor.apply();

        }

        TypedArray question = getResources().obtainTypedArray(R.array.questions);
        TypedArray answers_right = getResources().obtainTypedArray(R.array.answers_right);
        TypedArray answers_left = getResources().obtainTypedArray(R.array.answers_left);

        String[][] question_array = new String[question.length()][question.length()];
        String[][] answer_array_right = new String[question.length()][question.length()];
        String[][] answer_array_left = new String[question.length()][question.length()];

        question_array[fragment_slide] = getResources().getStringArray(question.getResourceId(fragment_slide, 0));
        answer_array_right[fragment_slide] = getResources().getStringArray(answers_right.getResourceId(fragment_slide, 0));
        answer_array_left[fragment_slide] = getResources().getStringArray(answers_left.getResourceId(fragment_slide, 0));

        String[] string_question = question_array[fragment_slide];
        String[] string_answer_right = answer_array_right[fragment_slide];
        String[] string_answer_left = answer_array_left[fragment_slide];


        right_label.setText(string_answer_right[position]);
        left_label.setText(string_answer_left[position]);
        question_label.setText(string_question[position]);

        button_teonom_left.setOnClickListener(this);
        button_teonom_right.setOnClickListener(this);

        question.recycle();
        answers_right.recycle();
        answers_left.recycle();

        return root;
    }



    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        if (position == 0) {
            Toast.makeText(getActivity(), "" + seekBar.getProgress(),
                    Toast.LENGTH_SHORT).show();
            editor.putInt(KEY + fragment_slide + position, seekBar.getProgress());


        } else if (position == 1) {
            Toast.makeText(getActivity(), "" + seekBar.getProgress(),
                    Toast.LENGTH_SHORT).show();
            editor.putInt(KEY + fragment_slide + position, seekBar.getProgress());

        }

        if(fragment_slide==2){
            if (position == 2) {
                Toast.makeText(getActivity(), "" + seekBar.getProgress(),
                        Toast.LENGTH_SHORT).show();
                editor.putInt(KEY + fragment_slide + position, seekBar.getProgress());


            } else if (position == 3) {
                Toast.makeText(getActivity(), "" + seekBar.getProgress(),
                        Toast.LENGTH_SHORT).show();
                editor.putInt(KEY + fragment_slide + position, seekBar.getProgress());
            }
        }
        editor.apply();
    }

    @Override
    public boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            fr = (for_position) getActivity();

        }catch (ClassCastException e){
            throw new ClassCastException(e.getMessage());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fr = null;
    }

    @Override
    public void onClick(View v) {
        int value = 0;
        switch (v.getId()) {
            case R.id.right_label:
                button_teonom_right.setEnabled(false);
                button_teonom_left.setEnabled(true);
                value = 1;
                break;
            case R.id.left_label:
                button_teonom_left.setEnabled(false);
                button_teonom_right.setEnabled(true);
                value = 0;
                break;
        }

        System.out.println("value is " + value);
        editor.putInt(KEY + 4 + 0, value);
        editor.apply();
    }

    interface for_position{
        void get_position(int position, int imageview1);
    }


    void getPosition(int position, int imageview1){
        if(fr!=null){
            fr.get_position(position,imageview1);
        }
    }

}
