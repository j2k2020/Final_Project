package com.multi.member;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class JoinService implements IJoinService {
@Autowired
@Qualifier("IJoinDAO")
IJoinDAO dao;

	@Override
	public void insertJoin(JoinVO join) { //회원가입
		dao.insertJoin(join);

	}
	
	@Override
	public JoinVO idCheck(String id) { //회원가입: id중복체크
		return dao.idCheck(id);
	}
	
	@Override
	public JoinVO readMyID(String id) { //마이페이지
		return dao.readMyID(id);
	}

	@Override
	public JoinVO loginCheck(String joID, String joPassword) { //로그인
		HashMap<String , Object> map = new HashMap<String, Object>();
		map.put("joID", joID);
		map.put("joPassword", joPassword);
		return dao.loginCheck(map);
	}

	@Override
	public ArrayList<JoinVO> memberList() {
		return dao.memberList(); //회원정보 조회
	}

	@Override
	public void deleteMember(String joID) {
		dao.deleteMember(joID); //관리자:회원삭제		
	}

	@Override
	public JoinVO UpdateMember(String joID) {
		return dao.UpdateMember(joID); //관리자:회원정보수정	
	}

	@Override
	public void myUpdate(JoinVO join) {
		dao.myUpdate(join); //마이페이지:수정
	}

	@Override
	public void memberOut(JoinVO vo, HttpSession session) {
		dao.memberOut(vo,session);
		
	}


	
	
	

	
}
