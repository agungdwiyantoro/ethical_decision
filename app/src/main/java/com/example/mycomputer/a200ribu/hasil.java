package com.example.mycomputer.a200ribu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import pl.droidsonroids.gif.GifImageView;

import static com.example.mycomputer.a200ribu.fragment2.f2q1;
import static com.example.mycomputer.a200ribu.fragment6.FRAGMENT6;
import static com.example.mycomputer.a200ribu.screen_slide.KEY;
import static com.example.mycomputer.a200ribu.screen_slide.SCREENSLIDE;

/**
 * Created by My Computer on 1/15/2018.
 */

public class hasil extends Activity {
    SharedPreferences FRAGMENT6_S;

    SharedPreferences FRAGMENT_SHIT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil);
        Button evaluasi_button = findViewById(R.id.button_evaluasi);
        TextView score = findViewById(R.id.score);
        final TextView comment = findViewById(R.id.comment);
        final Button log = findViewById(R.id.button_log);

        FRAGMENT6_S = getSharedPreferences(FRAGMENT6, Context.MODE_PRIVATE);
        FRAGMENT_SHIT = getSharedPreferences(KEY, Context.MODE_PRIVATE);

        Bundle extras = getIntent().getExtras();

        int bullshit =extras.getInt("NIGGA");
        String hasil_text =Integer.toString( bullshit  );

        final GifImageView hasil_gambar = findViewById(R.id.gambar_hasil);





        String hasil_comment = null;
        int warna = R.color.yellow;
        if(bullshit < 500){
            hasil_comment = getString(R.string.hasil_1);
            hasil_gambar.setImageResource(R.drawable.buruk);
            warna = R.color.red;
        }
        else if(bullshit >= 500 && bullshit <800){
            hasil_comment = getString(R.string.hasil_2);
            hasil_gambar.setImageResource(R.drawable.medium);
            warna = R.color.Orange;
        }
        else if(bullshit >= 800){
            hasil_comment = getString((R.string.hasil_3));
            hasil_gambar.setImageResource(R.drawable.bagus);
            warna = R.color.green;
        }


        final Handler handler = new Handler();


        comment.setText(hasil_comment);

        Animation a = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        a.reset();
        score.setTextColor(ContextCompat.getColor(hasil.this, warna));
        score.setText( hasil_text);
        score.clearAnimation();
        score.startAnimation(a);
        comment.clearAnimation();
        comment.startAnimation(a);



        evaluasi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(hasil.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(hasil.this);
                }
                builder.setTitle("Evaluasi Ulang?")
                        .setMessage("Mengevaluasi ulang akan menghapus hasil ini")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete

                                FRAGMENT6_S.edit().clear().apply();
                                FRAGMENT_SHIT.edit().clear().apply();

                                dialog.dismiss();
                                Intent home = new Intent(hasil.this, MainActivity.class);
                                startActivity(home);
                                finish();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();


            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent log = new Intent(hasil.this, log2.class);
                    startActivity(log);

            }
        });
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(hasil.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(hasil.this);
        }
        builder.setMessage("Keluar Aplikasi ?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {


                        FRAGMENT6_S.edit().clear().apply();
                        FRAGMENT_SHIT.edit().clear().apply();

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



}

