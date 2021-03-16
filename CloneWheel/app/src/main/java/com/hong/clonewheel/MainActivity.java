package com.hong.clonewheel;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.widget.Toast;

import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;

public class MainActivity extends AppCompatActivity {
    private final String[] colors = new String[]{"#F53E26", "#FA953E", "#FCC74A", "#E5D63B",
            "#D5D654", "#A4C34D", "#639D3C", "#299C39", "#21812E",
            "#0F596B", "#0A5EA0", "#203BB3", "#3721B9", "#7037A6", "#B2216D", " #F2103C"};
    int size = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WheelView wheelView = (WheelView) findViewById(R.id.wheel_view);
        wheelView.setWheelItemCount(size);

        ShapeDrawable[] shapeDrawables = new ShapeDrawable[size];
        for (int i = 0; i < size; ++i) {
            shapeDrawables[i] = new ShapeDrawable(new OvalShape());
            shapeDrawables[i].getPaint().setColor(Color.parseColor(colors[i]));
        }

        wheelView.setAdapter(new WheelAdapter() {
            @Override
            public Drawable getDrawable(int position) {
                return shapeDrawables[position];
            }

            @Override
            public int getCount() {
                return size;
            }
        });
        wheelView.setOnWheelItemClickListener(new WheelView.OnWheelItemClickListener() {

            @Override
            public void onWheelItemClick(WheelView parent, int position, boolean isSelected) {
                Toast.makeText(MainActivity.this, "You Clicked" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}