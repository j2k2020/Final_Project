package com.multi.member.hitter01;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Hitter01Service implements IHitter01Service {
	@Autowired
	@Qualifier("IHitter01DAO")
	IHitter01DAO dao;
	
	@Override
	public ArrayList<hitter01VO> hitter01List() {
		return dao.hitter01List();
	}

}
