package com.multi.member.teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BaseballTeamsService implements IBaseballTeamsService {
@Autowired
@Qualifier("IBaseballTeamsDAO")
IBaseballTeamsDAO teamsDao;


	@Override
	public BaseballTeamsVO teamsInfo(String sName) {
		return teamsDao.teamsInfo(sName);
	}


	@Override
	public BaseballTeamsVO mascotInfo(String sName) {
		return teamsDao.mascotInfo(sName);
	}

}
