package com.multi.member;

import java.util.ArrayList;

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

	public JoinVO idCheck(String id) {
		return dao.idCheck(id);
	}

	
}
