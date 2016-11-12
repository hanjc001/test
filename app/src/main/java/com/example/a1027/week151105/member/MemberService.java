package com.example.a1027.week151105.member;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */

public interface MemberService {

    // CRUD 정의

    public void join(MemberDTO param); // create
    public int count(); // read (숫자)  --> read는 작은 부분에서 큰 부분으로 정의
    public MemberDTO detail(String id); // read (하나), id값 파라미터 필요
    public ArrayList<MemberDTO> list(); // read (여러개)
    public MemberDTO login(MemberDTO param); // read (하나), id, pw 파라미터 필요 -> 암호화를 위해 캡슐에 담아서 전송(인캡슐화)
    public void update(MemberDTO param); // read
    public void delete(MemberDTO param); // read

}
