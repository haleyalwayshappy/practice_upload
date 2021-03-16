package com.hong.otherwheel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.igalata.bubblepicker.rendering.BubblePicker;

public class MainActivity extends AppCompatActivity {
    BubblePicker bubblePicker;
    String[] name = {
            "불안","흥분","환희","행복",
            "기쁨","평화","진정","이완",
            "졸림","피곤","지루","우울",
            "슬픔","좌절","화남","긴장"
    };

int[] images={
        R.mipmap.img1,
        R.mipmap.img2,
        R.mipmap.img3,
        R.mipmap.img4,
        R.mipmap.img5,
        R.mipmap.img6,
        R.mipmap.img7,
        R.mipmap.img8,
        R.mipmap.img9,
        R.mipmap.img10,
        R.mipmap.img11,
        R.mipmap.img12,
        R.mipmap.img13,
        R.mipmap.img14,
        R.drawable.img15,
        R.drawable.img16,
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}