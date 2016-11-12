package com.example.a1027.week151105.member;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */


// 데이터베이스를 위해 존재하는 클래스 - SQL

public class MemberDAO extends SQLiteOpenHelper {



    public MemberDAO(Context context) {
        super(context, "", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void insert(MemberDTO param){

        Log.d("DAO ID ", param.getId());
        Log.d("DAO PW ", param.getPw());
        Log.d("DAO NAME ", param.getName());
        Log.d("DAO E-MAIL ", param.getEmail());
        Log.d("DAO PHONE ", param.getPhone());
        Log.d("DAO ADDR ", param.getAddr());

        String sql = "";
        SQLiteDatabase db = this.getWritableDatabase();  // SQLite 데이터베이스를 사용하기 위해 SQLiteOpenHelper 상속
        db.execSQL(sql);
    }; // join

    public int selectCount(){
        int count = 0;
        return count;
    }; // count

    public MemberDTO selectOne(String id){
        MemberDTO member = new MemberDTO();
        return member;
    }; // detail

    public ArrayList<MemberDTO> selectList(){
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        return list;
    }; // list


    // 로그인
    public MemberDTO login(MemberDTO param){

        Log.d("[Login]DAO ID ", param.getId());
        Log.d("[Login]DAO PW ", param.getPw());

        MemberDTO member = new MemberDTO();
//        String sql = "";
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(sql, null); // rawQuery
        return member;
    };



    public void update(MemberDTO param){

    };

    public void delete(MemberDTO param){

    };
}
