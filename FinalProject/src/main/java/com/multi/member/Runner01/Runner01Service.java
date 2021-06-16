package com.multi.member.Runner01;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.multi.Parser.Runner01;
@Service
public class Runner01Service implements IRunner01Service{
	@Autowired
	@Qualifier("IRunner01DAO")
	IRunner01DAO dao;
	
	
	@Override
	public ArrayList<Runner01VO> runner01List() {
		return dao.runner01List();
	}

}
