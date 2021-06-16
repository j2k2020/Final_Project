package com.multi.member;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

public interface IJoinDAO {
	void insertJoin(JoinVO join);
	JoinVO idCheck(String id);
	JoinVO readMyID(String id); //마이페이지
	JoinVO loginCheck(HashMap<String, Object> map); //로그인
	ArrayList<JoinVO> memberList(); //관리자:회원조회
	void deleteMember(String joID); //관리자:회원삭제
	JoinVO UpdateMember(String joID);  //관리자:회원정보수정	
	void myUpdate(JoinVO join); //마이페이지:수정
	void memberOut(JoinVO vo, HttpSession session);
	JoinVO myUpdateForm(String joID);//마이페이지:수정페이지


}
