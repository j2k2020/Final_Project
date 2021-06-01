package com.multi.member;

import java.util.ArrayList;

public interface IJoinDAO {
	public ArrayList<JoinVO> joinList();
	public void insertJoin(JoinVO join);
	public JoinVO idCheck(String id);


}
