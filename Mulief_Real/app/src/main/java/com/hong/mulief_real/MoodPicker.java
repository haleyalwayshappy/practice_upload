package com.hong.mulief_real;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;

public class MoodPicker extends AppCompatActivity {
    private WheelView wheelView;
    private String[] colors = { //컬러 어레이 리스트
            "#F53E26", "#FA953E", "#FCC74A", "#E5D63B",
            "#D5D654", "#A4C34D", "#639D3C", "#299C39",
            "#21812E", "#0F596B", "#0A5EA0", "#203BB3",
            "#3721B9", "#7037A6", "#B2216D", "#F2103C"
    };
    private int[] images = {
            R.drawable.moodimg1, R.drawable.moodimg2, R.drawable.moodimg3, R.drawable.moodimg4,
            R.drawable.moodimg5, R.drawable.moodimg6, R.drawable.moodimg7, R.drawable.moodimg8,
            R.drawable.moodimg9, R.drawable.moodimg10, R.drawable.moodimg11, R.drawable.moodimg12,
            R.drawable.moodimg13, R.drawable.moodimg14, R.drawable.moodimg15, R.drawable.moodimg16
    };
    int size = 16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moodpicker);

        wheelView = findViewById(R.id.wheel_view);
        wheelView.setWheelItemCount(size);

        /**이미지들 넣는 코드 */
        Drawable[] drawables = new Drawable[size];
        for (int i = 0; i < size; i++) {
            drawables[i] = getDrawable(images[i]);
        }

        wheelView.setAdapter(new WheelAdapter() {

            @Override
            public Drawable getDrawable(int position) {

                Drawable drawable = drawables[position];
                return drawable;
            }

            @Override
            public int getCount() {

                return size;

            }
        });
//        /**컬러 넣는 코드 [no  image]*/
//         ShapeDrawable[] shapeDrawables = new ShapeDrawable[size];
//         for (int i = 0; i < size; i++) {
//         //색상 구현
//         shapeDrawables[i] = new ShapeDrawable(new OvalShape());
//         shapeDrawables[i].getPaint().setColor(Color.parseColor(colors[i]));
//         }
//        wheelView.setAdapter(new WheelAdapter() {
//            @Override
//            public Drawable getDrawable(int position) {
//                return shapeDrawables[position];
//            }
//
//            @Override
//            public int getCount() {
//                return size;
//            }
//        });

        wheelView.setOnWheelItemClickListener(new WheelView.OnWheelItemClickListener() {
            @Override
            public void onWheelItemClick(WheelView parent, int position, boolean isSelected) {

                Vibrator vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vib.vibrate(15);

                /**[수정] 터치 되었을 때 다음 페이지로 넘어가기 */

                switch (position) {
                    case 2:
                        Toast.makeText(com.hong.mulief_real.MoodPicker.this, "흥분페이지로 이동", Toast.LENGTH_SHORT).show();
                        // 흥분으로 이동할 페이지 코드 달기
                        break;
                    case 12:
                        Toast.makeText(com.hong.mulief_real.MoodPicker.this, "우울페이지로 이동", Toast.LENGTH_SHORT).show();
                        // 우울로 이동할 페이지 코드 달기
                        break;
                }

            }
        });
    }

}