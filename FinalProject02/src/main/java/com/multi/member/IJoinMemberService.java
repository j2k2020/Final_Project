package com.multi.member;

public interface IJoinMemberService {
	
	JoinMemberVO loginCheck(String joID,String joPassword); //로그인
	void insertMember(JoinMemberVO join); //회원가입
	JoinMemberVO idCheck(String id); //회원가입:id중복체크
	JoinMemberVO readMyId(String id); //마이페이지
	

}
