package com.example.a1027.week151105.member;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */


// 데이터베이스를 위해 존재하는 클래스 - SQL

public class MemberDAO {


    public MemberDAO(Context context) {

    }



    public void insert(MemberDTO param){

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

    public MemberDTO login(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    };

    public void update(MemberDTO param){

    };

    public void delete(MemberDTO param){

    };
}
