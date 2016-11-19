package com.example.a1027.week151105.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a1027.week151105.R;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {

    MemberService service;
    EditText et_pw, et_email, et_phone, et_addr;
    Button bt_confirm, bt_cancel;
    //String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        service = new MemberServiceImpl(this.getApplicationContext());
        // 리스트 화면에서 아이템 클릭시 id값을 가져온다
        //id = this.getIntent().getExtras().getString("id");

        et_pw = (EditText) findViewById(R.id.et_pw);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_addr = (EditText) findViewById(R.id.et_addr);
        bt_confirm = (Button) findViewById(R.id.bt_confirm);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);

        bt_confirm.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_confirm:
                // UPDATE
                MemberDTO params = new MemberDTO();

                params.setPw(et_pw.getText().toString());
                params.setEmail(et_email.getText().toString());
                params.setPhone(et_phone.getText().toString());
                params.setAddr(et_addr.getText().toString());
                //service.update(id);
                break;
            case R.id.bt_cancel:

                break;
        }
    }
}
