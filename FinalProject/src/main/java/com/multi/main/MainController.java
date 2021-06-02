package com.multi.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	// 메인 페이지
	@RequestMapping("/")		//메인페이지
	public String mainPage() {
		return "index"; // index.jsp
	}
	
	@RequestMapping("/baseball")	//야구
	public String baseball() {
		return "baseball";
	}
	
	@RequestMapping("/Football")	//축구
	public String Football() {
		return "Football";
	}
	
	@RequestMapping("/basketball")	//농구
	public String basketball() {
		return "basketball";
	}
	
	@RequestMapping("/volleyball")	//배구
	public String volleyball() {
		return "volleyball";
	}
	
	@RequestMapping("/btn_login")
	public String Login(){
		return "Login"; //Login.jsp
	}
}
