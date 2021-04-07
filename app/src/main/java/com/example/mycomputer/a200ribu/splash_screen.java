package com.example.mycomputer.a200ribu;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by My Computer on 1/19/2018.
 */

public class splash_screen extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

   //     TextView title = findViewById(R.id.title);
    //    TextView title_bawah = findViewById(R.id.title_bawah);
    //    AssetManager am = getApplicationContext().getAssets();

//        Typeface typeface = Typeface.createFromAsset(getAssets(),  "fonts/prototype.ttf");



        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {

            @Override

            public void run() {

                startActivity(new Intent(splash_screen.this, MainActivity.class));

                finish();

            }

        }, 3000L); //3000 L = 3 detik



      //  title.setTypeface(typeface);
      //  title_bawah.setTypeface(typeface);


     //  thread.run();

    }
}
