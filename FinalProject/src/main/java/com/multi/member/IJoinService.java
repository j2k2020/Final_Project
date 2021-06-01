package com.multi.member;

import java.util.ArrayList;

public interface IJoinService {
	 ArrayList<JoinVO> joinList();
	 void insertJoin(JoinVO join); 
	 JoinVO idCheck(String id);


}
