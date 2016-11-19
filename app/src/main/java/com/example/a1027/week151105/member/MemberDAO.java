package com.example.a1027.week151105.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.a1027.week151105.global.Member;

import java.util.ArrayList;

import static com.example.a1027.week151105.global.Member.ADDR;
import static com.example.a1027.week151105.global.Member.EMAIL;
import static com.example.a1027.week151105.global.Member.ID;
import static com.example.a1027.week151105.global.Member.NAME;
import static com.example.a1027.week151105.global.Member.PHONE;
import static com.example.a1027.week151105.global.Member.PHOTO;
import static com.example.a1027.week151105.global.Member.PW;
import static com.example.a1027.week151105.global.Member.TABLE;


/**
 * Created by 1027 on 2016-11-12.
 */


// 데이터베이스를 위해 존재하는 클래스 - SQL

public class MemberDAO extends SQLiteOpenHelper {



    public MemberDAO(Context context) {
        super(context, "han2.db", null, 1); // 데이터베이스 생성
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


        db.execSQL("CREATE TABLE IF NOT EXISTS "+ Member.TABLE+"\n" +
                "(\n" +
                ID+" text primary key,\n" +
                PW+" text,\n" +
                NAME+" text,\n" +
                EMAIL+" text,\n" +
                PHONE+" text,\n" +
                PHOTO+" text,\n" +
                ADDR+" text" +
                ");");

        db.execSQL("INSERT INTO "+ Member.TABLE+" ("+Member.ID+","+Member.PW+", "+Member.NAME+", "+Member.EMAIL+", "+Member.PHONE+", "+Member.PHOTO+", "+Member.ADDR+") VALUES ('test02', '222', 'han1', 'han@test.com', '010-1111-2222', 'default.jpeg', 'seoul');");
        db.execSQL("INSERT INTO "+ Member.TABLE+" ("+Member.ID+","+Member.PW+", "+Member.NAME+", "+Member.EMAIL+", "+Member.PHONE+", "+Member.PHOTO+", "+Member.ADDR+") VALUES ('test03', '222', 'han2', 'han@test.com', '010-1111-2222', 'default.jpeg', 'seoul');");
        db.execSQL("INSERT INTO "+ Member.TABLE+" ("+Member.ID+","+Member.PW+", "+Member.NAME+", "+Member.EMAIL+", "+Member.PHONE+", "+Member.PHOTO+", "+Member.ADDR+") VALUES ('test04', '222', 'han3', 'han@test.com', '010-1111-2222', 'default.jpeg', 'seoul');");

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

        String sql = "select "+String.format("%s, %s, %s, %s, %s, %s, %s", ID, PW, NAME, EMAIL, PHONE, PHOTO, ADDR)
                +String.format(" from %s where %s = '%s';", TABLE, ID, id);
        //MemberDTO member = new MemberDTO();
        MemberDTO temp = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToNext()) {
            temp = new MemberDTO();
            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setEmail(cursor.getString(3));
            temp.setPhone(cursor.getString(4));
            temp.setPhoto(cursor.getString(5));
            temp.setAddr(cursor.getString(6));
        }

        return temp;
    }; // detail



    public ArrayList<MemberDTO> selectList(){
        String sql = "select "+String.format("%s, %s, %s, %s, %s, %s, %s", ID, PW, NAME, EMAIL, PHONE, PHOTO, ADDR)+" from member;";
        //String sql = "select count(*) as count from member;";
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor != null) {

            Log.d("DAO List is:", "성공");
            cursor.moveToFirst();
        }

        do{
            MemberDTO temp = new MemberDTO();
            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setEmail(cursor.getString(3));
            temp.setPhone(cursor.getString(4));
            temp.setPhoto(cursor.getString(5));
            temp.setAddr(cursor.getString(6));

            list.add(temp);

        } while (cursor.moveToNext());

        return list;
    }; // list




    // 로그인
    public MemberDTO login(MemberDTO param){

        Log.d("[Login]DAO ID ", param.getId());
        Log.d("[Login]DAO PW ", param.getPw());

        MemberDTO member = new MemberDTO();
        String sql = "select "+ PW+" from "+Member.TABLE+" where "+ ID+"='"+param.getId()+"';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null); // rawQuery
        if (cursor.moveToNext()) {
            member.setPw(cursor.getString(0));
        }
        Log.d("### PW ###", member.getPw());
        return member;
    };



    public void update(MemberDTO param){

        Log.d("UPDATE", "업데이트 수행");
        Log.d("DAO ID ", param.getId());

//        Log.d("DAO PW ", param.getPw());
//        Log.d("DAO E-MAIL ", param.getEmail());
//        Log.d("DAO PHONE ", param.getPhone());
//        Log.d("DAO ADDR ", param.getAddr());

//        String sql = "update member set  pw, email, phone, photo, addr where id='"+param.getId()+"';";
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL(sql);
    };

//    public void delete(MemberDTO param){
//
//    };

    public void delete(String id){
        // db 테이블에서 해당 아이디에 회원 정보 삭제

        Log.d("삭제할 ID", id);
    };
}
