package com.multi.member;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class JoinMemberService implements IJoinMemberService {
	
	@Autowired
	@Qualifier("IJoinMemberDAO")
	IJoinMemberDAO joinDao;

	@Override
	public JoinMemberVO loginCheck(String joID, String joPassword) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("joID", joID);
		map.put("joPassword", joPassword);
		
		return joinDao.loginCheck(map);
	}

	@Override
	public void insertMember(JoinMemberVO join) {
		joinDao.insertMember(join);
		
	}

	@Override
	public JoinMemberVO idCheck(String id) { //회원가입:id중복체크
		return joinDao.idCheck(id);
	}

	@Override
	public JoinMemberVO readMyId(String id) { //마이페이지
		return joinDao.readMyId(id);
	}

}
