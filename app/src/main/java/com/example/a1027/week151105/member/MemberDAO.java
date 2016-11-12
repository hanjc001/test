package com.example.a1027.week151105.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.a1027.week151105.global.Member;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */


// 데이터베이스를 위해 존재하는 클래스 - SQL

public class MemberDAO extends SQLiteOpenHelper {



    public MemberDAO(Context context) {
        super(context, "han.db", null, 1); // 데이터베이스 생성
        this.getWritableDatabase(); //  데이베이스 속성 설정

        Log.d("### DB 생성 ###", "=== SUCCESS ===");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // 테이블 생성
//        String sql = "CREATE TABLE "+ Member.TABLE+"\n" +
//                "(\n" +
//                Member.ID+" text primary key,\n" +
//                Member.PW+" text,\n" +
//                Member.EMAIL+" text,\n" +
//                Member.PHONE+" text,\n" +
//                Member.PHOTO+" text,\n" +
//                Member.ADDR+" text" +
//                ");";


        db.execSQL("CREATE TABLE IF NOT EXISTS"+ Member.TABLE+"\n" +
                "(\n" +
                Member.ID+" text primary key,\n" +
                Member.PW+" text,\n" +
                Member.NAME+" text,\n" +
                Member.EMAIL+" text,\n" +
                Member.PHONE+" text,\n" +
                Member.PHOTO+" text,\n" +
                Member.ADDR+" text" +
                ");");

        //db.execSQL("INSERT INTO "+ Member.TABLE+" ("+Member.ID+","+Member.PW+", "+Member.NAME+", "+Member.EMAIL+", "+Member.PHONE+", "+Member.PHOTO+", "+Member.ADDR+") VALUES ('test02', '222', 'han test', 'han@test.com', '010-1111-2222', 'default.jpeg', 'seoul');");

        //Log.d("### MEMBER TABLE 생성 ###", "=== SUCCESS ===");
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

//        String sql = "";
//        SQLiteDatabase db = this.getWritableDatabase();  // SQLite 데이터베이스를 사용하기 위해 SQLiteOpenHelper 상속
//        db.execSQL(sql);
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
        String sql = "select "+Member.PW+" from "+Member.TABLE+" where "+Member.ID+"='"+param.getId()+"';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null); // rawQuery
        if (cursor.moveToNext()) {
            member.setPw(cursor.getString(0));
        }
        Log.d("### PW ###", member.getPw());
        return member;
    };



    public void update(MemberDTO param){

    };

    public void delete(MemberDTO param){

    };
}
