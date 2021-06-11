package com.multi.member;

import java.util.ArrayList;

public interface IJoinService {
	 ArrayList<JoinVO> joinList();
	 void insertJoin(JoinVO join); 
	 JoinVO idCheck(String id);
	 
	 //로그인: id,pw 체크
	 JoinVO LoginCheck(String joID, String joPassword);


}
