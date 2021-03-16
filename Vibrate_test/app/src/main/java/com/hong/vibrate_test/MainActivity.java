package com.hong.vibrate_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Vibrator vib =(Vibrator)getSystemService(VIBRATOR_SERVICE);
        switch (v.getId()) {
            case R.id.button1:
                vib.vibrate(5);
                break;
            case R.id.button2:
                vib.vibrate(10);
                break;
            case R.id.button3:
                vib.vibrate(15);
                break;
            case R.id.button4:
                vib.vibrate(20);
                break;
        }
    }
}