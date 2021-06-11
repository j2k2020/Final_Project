package com.multi.member.Pitcher01;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Pitcher01Service implements IPitcher01Service {
	@Autowired
	@Qualifier("IPitcher01DAO")
	IPitcher01DAO dao;
	
	@Override
	public ArrayList<Pitcher01VO> pitcher01List() {
		return dao.pitcher01List();
	}

}
