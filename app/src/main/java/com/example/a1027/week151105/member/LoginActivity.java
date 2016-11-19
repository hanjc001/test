package com.example.a1027.week151105.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a1027.week151105.R;

import static android.R.attr.id;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    MemberService service;
    EditText et_id, et_pw;
    Button bt_login, bt_join;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        service = new MemberServiceImpl(this.getApplicationContext());
        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);

        bt_login = (Button) findViewById(R.id.bt_login);
        bt_join = (Button) findViewById(R.id.bt_join);

        bt_login.setOnClickListener(this);
        bt_join.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                MemberDTO params = new MemberDTO();
                params.setId(et_id.getText().toString());
                params.setPw(et_pw.getText().toString());
                //service.login(params);

                if(service.login(params)) {
                    Toast.makeText(LoginActivity.this, "로그인성공", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                    intent.putExtra("id", id);
                    this.startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "로그인실패", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_join:
                this.startActivity(new Intent(LoginActivity.this, JoinActivity.class));
                break;
        }
    }
}
