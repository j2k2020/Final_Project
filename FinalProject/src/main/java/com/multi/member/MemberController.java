package com.multi.member;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	
	@Autowired
	private JoinService joinService;

	
	//회원가입 페이지로 이동
	@RequestMapping("/btn_join")
	public String JoinMember() {
		return "join"; //join.jsp
	}
	
	//회원 정보 기입
	@RequestMapping("/insertJoinMember")
	public String InsertJoinMember(JoinVO join) {
		joinService.insertJoin(join);
		return "redirect:./"; //main페이지로 이동	
	}
	
	//모든 가입 회원 정보
	@RequestMapping("/joinMemberList")
	public String AllMemberList(Model model) {
		ArrayList<JoinVO> joinList = joinService.joinList();
		model.addAttribute("joinList", joinList);
		return "All_joinMemberView";	
	}
	
	//ID중복 체크
	@ResponseBody
	@RequestMapping("/joinidCheck")
	public int idCehck(@RequestParam("joID") String id) {
		JoinVO vo = joinService.idCheck(id);
		int result=0;
		if(vo!=null) result=1;
		return result;
	}
	
	
	
	

}
