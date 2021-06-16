package com.multi.member;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public interface IJoinService {

	 void insertJoin(JoinVO join); //회원가입
	 JoinVO idCheck(String id); //회원가입:id체크
	 JoinVO readMyID(String id); //마이페이지
	 JoinVO loginCheck(String joID, String joPassword); //로그인
	 ArrayList<JoinVO> memberList(); //회원정보 조회
	 void deleteMember(String joID); //관리자:회원삭제
	 JoinVO UpdateMember(String joID); //관리자:회원정보수정	
	 
	 JoinVO myUpdateForm(String joID); //마이페이지:수정페이지로
	 void myUpdate(JoinVO join); //마이페이지:수정
	 void memberOut(JoinVO vo, HttpSession session);
	 
	 


}
