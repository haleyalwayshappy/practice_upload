package com.hong.mulief_real;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaController mediaController;

    Dialog dialog1; // 커스텀 다이얼로그
    Dialog loginDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        findViewById(R.id.kakaologin_btn).setOnClickListener(this);
        findViewById(R.id.login_btn).setOnClickListener(this);  //메인 페이지 버튼 생성 코드


        dialog1 = new Dialog(com.hong.mulief_real.MainActivity.this); //다이얼로그 초기화
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀 제거
        dialog1.setContentView(R.layout.dialog1);  // xml레이아웃
        findViewById(R.id.otherlogin_btn).setOnClickListener(this); // 아더버튼 생성 코드 클릭 리스너

    }

    @Override
    public void onClick(View v) {  //버튼 클릭시 동작
        switch (v.getId()) {
            case R.id.kakaologin_btn:  // 카카오 버튼 실행시
                /**[수정] 카카오 버튼 연동 여기에 */
                Toast.makeText(com.hong.mulief_real.MainActivity.this, "카카오 실행합니다!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_btn:
                Toast.makeText(com.hong.mulief_real.MainActivity.this, "로그인 실행합니다.", Toast.LENGTH_SHORT).show();
                okLogin();
                break;
            case R.id.otherlogin_btn:
                showDialog1();
                break;
        }
    }

    private void okLogin() {

        loginDialog = new Dialog(com.hong.mulief_real.MainActivity.this);
        loginDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        loginDialog.setContentView(R.layout.login_dialog);
        loginDialog.show();  // 다이얼로그 보여주기
        loginDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  // 배경 투명


        EditText etId = findViewById(R.id.et_id);
        EditText etPw = findViewById(R.id.et_password);

        Button backBtn2 = loginDialog.findViewById(R.id.back_btn2);
        backBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginDialog.dismiss();
            }
        });

        Button okLogin = loginDialog.findViewById(R.id.ok_login);
        okLogin.setOnClickListener(new View.OnClickListener() {
            /**[수정] 여기에 로그인 실행 뒤 넘어갈페이지 연결 코드 작성 */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,com.hong.mulief_real.MoodPicker.class);
                startActivity(intent);

            }
        });
    }

    private void showDialog1() {  // 쇼 다이얼로그 메소드
        dialog1.show();  // 다이얼로그 보여주기
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  // 배경 투명


        Button googleBtn = dialog1.findViewById(R.id.google_btn);  //dialog1 에 있는 구글 버튼 생성
        googleBtn.setOnClickListener(new View.OnClickListener() {   // 구글 버튼 눌렀을때
            @Override
            public void onClick(View v) {  //버튼 실행시 동작
                Toast.makeText(com.hong.mulief_real.MainActivity.this, "구글 실행합니다!", Toast.LENGTH_SHORT).show();
            }
        });


        Button facebookBtn = dialog1.findViewById(R.id.facebook_btn);
        facebookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.hong.mulief_real.MainActivity.this, "페이스북 실행합니다!", Toast.LENGTH_SHORT).show();
            }
        });

        Button NaverBtn = dialog1.findViewById(R.id.naver_btn);
        NaverBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(com.hong.mulief_real.MainActivity.this, "네이버 실행합니다!", Toast.LENGTH_SHORT).show();
            }
        });


        Button backBtn = dialog1.findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();  // 다이얼로그 끝내기
            }
        });

    }

    private void init() { // 비디오 재생화면
        VideoView videoView;
        videoView = findViewById(R.id.video_view);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        //비디오 경로 설정
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/comp");
        videoView.setVideoURI(uri);

        videoView.start();
        videoView.setOnCompletionListener(mp -> videoView.start());


    }

}
