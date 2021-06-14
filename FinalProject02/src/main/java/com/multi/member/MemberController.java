package com.multi.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.multi.member.teams.BaseballTeamsService;
import com.multi.member.teams.BaseballTeamsVO;

@Controller
public class MemberController {


@Autowired
JoinMemberService joinmemberService;

@Autowired
BaseballTeamsService teamsService;



//---첫화면: 홈페이지--------------------------------------
	@RequestMapping("/")
	public String homePage() {
		return "index";
	}

	
	
//---회원가입---------------------------------------------
	@RequestMapping(value = "btn_join")
	public String joinPage() {
		return "join"; //회원가입 페이지로
	}	
		
	//신규회원정보 입력	
	@RequestMapping("insertJoinMember")
	public String InsertMember(JoinMemberVO join) {
		joinmemberService.insertMember(join);
		return "login"; //회원가입 후 로그인페이지로
	}
	
	////회원가입:id중복체크
	@ResponseBody
	@RequestMapping("joinidCheck")
	public int idCheck(@RequestParam("joID") String id) {
		JoinMemberVO vo = joinmemberService.idCheck(id);
		int result=0;
		if(vo != null) {result =1;}	
		return result; //id체크해서 같은 값이 존재하면 1을 반환
	}
	
	
	
//---로그인---------------------------------------------
	@RequestMapping(value = "btn_login") 
	public String lgoinPage() {
		return "login"; //로그인페이지로 이동
	}
	
	//로그인페이지에서 id,pw입력받고 확인
	@RequestMapping("Login")
	public String Login(@RequestParam("joID") String joID, @RequestParam("joPassword") String joPassword, HttpSession session) {
	    JoinMemberVO vo = joinmemberService.loginCheck(joID,joPassword);
        if(vo != null) { 
        	session.setAttribute("sid", vo.getJoID()); //세션으로 아이디 저장
        	}
		return "main"; //id,pw존재하면 메인페이지로 이동
	}


//---마이페이지---------------------------------------------
	
	@RequestMapping(value = "myPage")
	public String myPage(Model model, HttpSession session) {
		String sid = (String)session.getAttribute("sid");
		JoinMemberVO join = joinmemberService.readMyId(sid);
		model.addAttribute("join", join);
		
		return "myDetailPage";
	}
	
	
	
//---선수기록---------------------------------------------
	
	
//---구단소개---------------------------------------------	
	@RequestMapping(value = "/teamInfo/{btName}")
	public String teamInfo(@PathVariable String btName, Model model) {
		System.out.println(btName);
		BaseballTeamsVO team = teamsService.teamsInfo(btName);
		model.addAttribute("team", team);	
		return "KT";
	}
	
//	@RequestMapping("/amgg")
//	public String amognapage() {
//		return "amogona";
//	}
}
