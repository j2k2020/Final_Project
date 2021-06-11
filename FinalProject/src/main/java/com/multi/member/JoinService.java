package com.multi.member;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class JoinService implements IJoinService {
@Autowired
@Qualifier("IJoinDAO")
IJoinDAO dao;


	@Override
	public ArrayList<JoinVO> joinList() {
		return dao.joinList();
	}

	@Override
	public void insertJoin(JoinVO join) {
		dao.insertJoin(join);

	}
	
	@Override
	public JoinVO idCheck(String id) { //회원가입: id 중복체크
		return dao.idCheck(id);
	}

	
	@Override
	public JoinVO LoginCheck(String joID, String joPassword) { //로그인: id,pw 확인 후 로그인
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("joID", joID);
		map.put("joPassword", joPassword);
		return dao.loginCheck(joID, joPassword);
	}
	
	

	
}
