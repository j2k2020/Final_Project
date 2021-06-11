package com.multi.member.Defense01;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Defense01Service implements IDefense01Service{
	@Autowired
	@Qualifier("IDefense01DAO")
	IDefense01DAO dao;
	
	@Override
	public ArrayList<Defense01VO> defense01List() {
		return dao.defense01List();
	}
	
}
