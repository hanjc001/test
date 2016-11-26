package com.example.a1027.week151105.movie;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-26.
 */

public class MovieDAO extends SQLiteOpenHelper {


    public MovieDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "", null, 1);
    }


    // DB는 어플 맨처음 실행될 때 한 번만 생성되어야 한다.
    @Override
    public void onCreate(SQLiteDatabase db) { }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }


    public void add(MovieDTO param) {
        String sql = "insert into table(...) values(...);";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    };

    public int count() {
        String sql = "select count(*) from table;";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return 0;
    };

    public MovieDTO findOne(String key) {
        String sql = "select * from table where column='key';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return null;
    };
    public ArrayList<MovieDTO> findBy(MovieDTO param) {
        String sql = "select * from where column='search word';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return null;
    };
    public ArrayList<MovieDTO> list() {
        String sql = "select * from table;";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return null;
    };

    public void update(MovieDTO param) {
        String sql = "update table set column='value', column='value' ... where column='key';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
    };

    public void delete(String Key) {
        String sql = "delete from table where column='key';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
    };
}
