package com.example.a1027.week151105.intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.a1027.week151105.R;
import com.example.a1027.week151105.member.LoginActivity;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt_regist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        bt_regist = (Button) findViewById(R.id.bt_regist);
        bt_regist.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // 클릭하면 로그인 화면으로 이동
        //Intent intent = new Intent(IntroActivity.this, IntroActivity.class);
        //this.startActivity(intent);
        this.startActivity(new Intent(IntroActivity.this, LoginActivity.class));
    }
}
