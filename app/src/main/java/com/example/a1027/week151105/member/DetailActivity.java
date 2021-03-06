package com.example.a1027.week151105.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a1027.week151105.R;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    MemberServiceImpl service;

    ImageView iv_photo;
    TextView tv_name, tv_id, tv_pw, tv_email, tv_phone, tv_addr;
    Button bt_call, bt_message, bt_map, bt_movie, bt_update, bt_list;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        service = new MemberServiceImpl(this.getApplicationContext());

        iv_photo = (ImageView) findViewById(R.id.iv_photo);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_pw = (TextView) findViewById(R.id.tv_pw);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_addr = (TextView) findViewById(R.id.tv_addr);



        // 리스트 화면에서 아이템 클릭시 id값을 가져온다
        id = this.getIntent().getExtras().getString("id");
        MemberDTO member = service.detail(id);
        if (member != null) {
            tv_name.setText(member.getName());
            tv_id.setText(member.getId());
            tv_email.setText(member.getEmail());
            tv_addr.setText(member.getAddr());
            tv_pw.setText(member.getPw());
            tv_phone.setText(member.getPhone());
            //iv_photo.setImageResource(member.getPhoto());
        } else {
            Log.d("아이디가 존재", "하지 않음");
        }


        bt_call = (Button) findViewById(R.id.bt_call);
        bt_message = (Button) findViewById(R.id.bt_message);
        bt_map = (Button) findViewById(R.id.bt_map);
        bt_movie = (Button) findViewById(R.id.bt_movie);
        bt_update = (Button) findViewById(R.id.bt_update);
        bt_list = (Button) findViewById(R.id.bt_list);

        bt_call.setOnClickListener(this);
        bt_message.setOnClickListener(this);
        bt_map.setOnClickListener(this);
        bt_movie.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_list.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_call:
                break;
            case R.id.bt_message:
                break;
            case R.id.bt_map:
                break;
            case R.id.bt_movie:
                break;
            case R.id.bt_update:
                Intent intent = new Intent(DetailActivity.this, UpdateActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.bt_list:

                break;

        }
    }
}
