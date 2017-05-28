package com.curve.nandhakishore.deltaone;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    int red = 0, green = 0, blue = 0;
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        red = settings.getInt("Red",0);
        green = settings.getInt("Green",0);
        blue = settings.getInt("Blue",0);

        final View appLayout = findViewById(R.id.colorlayout);
        Button bRed = (Button) findViewById(R.id.button_Red);
        Button bGreen = (Button) findViewById(R.id.button_Green);
        Button bBlue = (Button) findViewById(R.id.button_Blue);
        Button bReset = (Button) findViewById(R.id.button_Reset);
        final TextView tRed = (TextView) findViewById(R.id.textView_Red);
        final TextView tGreen = (TextView) findViewById(R.id.textView_Green);
        final TextView tBlue = (TextView) findViewById(R.id.textView_Blue);

        tRed.setText(String.valueOf(red));
        tGreen.setText(String.valueOf(green));
        tBlue.setText(String.valueOf(blue));
        appLayout.setBackgroundColor(Color.rgb(red,green,blue));
        tRed.setTextColor(Color.rgb(255-red,255-green,255-blue));
        tGreen.setTextColor(Color.rgb(255-red,255-green,255-blue));
        tBlue.setTextColor(Color.rgb(255-red,255-green,255-blue));

        bRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(red==255)
                    red = 0;
                else
                    red++;
                tRed.setText(String.valueOf(red));
                appLayout.setBackgroundColor(Color.rgb(red,green,blue));
                tRed.setTextColor(Color.rgb(255-red,255-green,255-blue));
                tGreen.setTextColor(Color.rgb(255-red,255-green,255-blue));
                tBlue.setTextColor(Color.rgb(255-red,255-green,255-blue));
            }
        });

        bGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(green==255)
                    green=0;
                else
                    green++;
                tGreen.setText(String.valueOf(green));
                appLayout.setBackgroundColor(Color.rgb(red,green,blue));
                tRed.setTextColor(Color.rgb(255-red,255-green,255-blue));
                tGreen.setTextColor(Color.rgb(255-red,255-green,255-blue));
                tBlue.setTextColor(Color.rgb(255-red,255-green,255-blue));

            }
        });

        bBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(blue==255)
                    blue=0;
                else
                    blue++;
                tBlue.setText(String.valueOf(blue));
                appLayout.setBackgroundColor(Color.rgb(red,green,blue));
                tRed.setTextColor(Color.rgb(255-red,255-green,255-blue));
                tGreen.setTextColor(Color.rgb(255-red,255-green,255-blue));
                tBlue.setTextColor(Color.rgb(255-red,255-green,255-blue));
            }
        });

        bReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                red = blue = green = 0;
                tRed.setText(String.valueOf(red));
                tGreen.setText(String.valueOf(green));
                tBlue.setText(String.valueOf(blue));
                appLayout.setBackgroundColor(Color.rgb(red,green,blue));
                tRed.setTextColor(Color.rgb(255-red,255-green,255-blue));
                tGreen.setTextColor(Color.rgb(255-red,255-green,255-blue));
                tBlue.setTextColor(Color.rgb(255-red,255-green,255-blue));
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("Red", red);
        editor.putInt("Green", green);
        editor.putInt("Blue", blue);
        editor.commit();
    }

}

