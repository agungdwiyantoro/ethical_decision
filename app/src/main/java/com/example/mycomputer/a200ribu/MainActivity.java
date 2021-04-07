package com.example.mycomputer.a200ribu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.titile_opening);
        Button button_continue = findViewById(R.id.button_continue);
        WebView opening_desc = findViewById(R.id.webView);

        WebView opening_desc2 = findViewById(R.id.webView2);

        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent home = new Intent(MainActivity.this, screen_slide.class);
                Intent home = new Intent(MainActivity.this, essays.class);
                startActivity(home);
                finish();
            }
        });

        opening_desc.setBackgroundColor(Color.TRANSPARENT);
        opening_desc.loadUrl("file:///android_asset/description_opening.html");


        opening_desc2.setBackgroundColor(Color.TRANSPARENT);
        opening_desc2.loadUrl("file:///android_asset/description_opening_part_2.html");


        
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(MainActivity.this);
        }
        builder.setMessage("Keluar Aplikasi ?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {


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

    @Override
    public void finish() {
        super.finish();
      //  System.out.println("Fuck you nigga soldier.kidd");
        overridePendingTransitionEnter();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransitionExit();
    }

    /**
     * Overrides the pending Activity transition by performing the "Enter" animation.
     */
    protected void overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.act_slide_from_right, R.anim.act_tran_slide_to_left);
    }

    /**
     * Overrides the pending Activity transition by performing the "Exit" animation.
     */
    protected void overridePendingTransitionExit() {
        overridePendingTransition(R.anim.act_slide_from_left, R.anim.act_trans_slide_to_right);
    }
}
