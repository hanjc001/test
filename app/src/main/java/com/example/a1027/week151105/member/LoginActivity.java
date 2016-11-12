package com.example.a1027.week151105.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a1027.week151105.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    MemberService service;
    EditText et_id, et_pw;
    Button bt_submit, bt_cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        service = new MemberServiceImpl(this.getApplicationContext());
        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        bt_submit = (Button) findViewById(R.id.bt_submit);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);

        bt_submit.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_submit:
                MemberDTO params = new MemberDTO();
                params.setId(et_id.getText().toString());
                params.setPw(et_pw.getText().toString());
                //service.login(params);

                if(service.login(params)) {
                    Toast.makeText(LoginActivity.this, "로그인성공", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LoginActivity.this, "로그인실패", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_cancel:
                break;
        }
    }
}
