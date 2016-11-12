package com.example.a1027.week151105.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a1027.week151105.R;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener {

    MemberService service;

    EditText et_id, et_pw, et_name, et_email, et_phone, et_addr;
    Button bt_submit, bt_cancel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        service = new MemberServiceImpl(this.getApplicationContext());

        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        et_name = (EditText) findViewById(R.id.et_name);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_addr = (EditText) findViewById(R.id.et_addr);
        bt_submit = (Button) findViewById(R.id.bt_submit);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);

        bt_submit.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_submit:
//                String id = et_id.getText().toString();
//                String pw = et_pw.getText().toString();
//                String name = et_name.getText().toString();
//                String email = et_email.getText().toString();
//                String phone = et_phone.getText().toString();
//                String addr = et_addr.getText().toString();

                MemberDTO params = new MemberDTO();
                params.setId(et_id.getText().toString());
                params.setPw(et_pw.getText().toString());
                params.setName(et_name.getText().toString());
                params.setEmail(et_email.getText().toString());
                params.setPhone(et_phone.getText().toString());
                params.setAddr(et_addr.getText().toString());

                service.join(params);
                break;
            case R.id.bt_cancel:

                break;
        }
    }
}










