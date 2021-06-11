package com.multi.member.Runner01;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Running01Service implements IRunning01Service{
	@Autowired
	@Qualifier("IRunning01DAO")
	IRunning01DAO dao;
	
	@Override
	public ArrayList<Running01VO> running01List() {
		return dao.running01List();
	}
	
}
