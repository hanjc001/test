package com.example.a1027.week151105.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.a1027.week151105.R;

public class JoinActivity extends AppCompatActivity {


    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);


        service = new MemberServiceImpl(this.getApplicationContext());
    }
}
