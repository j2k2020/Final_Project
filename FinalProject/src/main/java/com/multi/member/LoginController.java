package com.multi.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@Autowired
	JoinService service;
	
	
	@RequestMapping("/btn_login")
	public String doLogin(@RequestParam("id") String id) {
		
		return "after_login/main/main";
		
	}

}
