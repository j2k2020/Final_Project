package com.multi.member;

import java.util.HashMap;

public interface IJoinMemberDAO {

	JoinMemberVO loginCheck(HashMap<String, Object> map);
    void insertMember(JoinMemberVO join);
	JoinMemberVO idCheck(String id); //회원가입:id중복체크
	JoinMemberVO readMyId(String id); //마이페이지

}
