package com.multi.member;

/* FinalProject */

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.multi.member.Defense01.Defense01Service;
import com.multi.member.Defense01.Defense01VO;
import com.multi.member.Pitcher01.Pitcher01Service;
import com.multi.member.Pitcher01.Pitcher01VO;
import com.multi.member.hitter01.Hitter01Service;
import com.multi.member.hitter01.hitter01VO;

@Controller
public class MemberController {

	@Autowired
	private JoinService joinService;

	@Autowired
	private Hitter01Service hitter01Service;
	
	@Autowired
	private Pitcher01Service Pitcher01Service;
	
	@Autowired
	private Defense01Service defense01Service;
	
	// 메인 페이지
	@RequestMapping("/") // 메인페이지
	public String mainPage() {
		return "index"; // index.jsp
	}


	
//선수기록---------------------------------------------------------
	@RequestMapping("/baseball")	// 야구-타자
	public String batter1(Model model) {
		ArrayList<hitter01VO> hitter01List = hitter01Service.hitter01List();
		model.addAttribute("hitter01List",hitter01List);
		return "baseball";
	}
	
	@RequestMapping("/baseball2")	// 야구-투수
	public String baseball2(Model model) {
		ArrayList<Pitcher01VO> pitcher01List = Pitcher01Service.pitcher01List();
		model.addAttribute("pitcher01List",pitcher01List);
		return "baseball2";
	}
	
	@RequestMapping("/baseball3")	// 야구-수비
	public String baseball3(Model model) {
		ArrayList<Defense01VO> defense01List = defense01Service.defense01List();
		model.addAttribute("defense01List",defense01List);
		return "baseball3";
	}
	
	@RequestMapping("/baseball4")	// 야구-주루
	public String baseball4() {
		return "baseball4";
	}

	
	
//팀기록---------------------------------------------------------
	@RequestMapping("team")
	public String team(){
		return "team";
	}

	
//경기일정---------------------------------------------------------
		@RequestMapping("schedule")
		public String schedule(){
			return "schedule";
		}
		
		
//챗봇---------------------------------------------------------
		@RequestMapping("AI_ChatBot")
		public String AI_ChatBot(){
			return "AI_ChatBot";
		}
		
		
		
//마이페이지---------------------------------------------------------
		@RequestMapping("myPage")
		public String myPage(){
			return "myPage";
		}		
//---------------------------------------------------------
	
	//메인페이지에서 배너 클릭시 이동//
	
	@RequestMapping("/LG") 
	public String teamLG() {
		return "LG"; //LG.jsp
	}
	
	@RequestMapping("/KT") 
	public String teamKT() {
		return "KT";
	}
	
	@RequestMapping("/SSG") 
	public String teamSSG() {
		return "SSG";
	}
	
	@RequestMapping("/SamSung") 
	public String teamSamSung() {
		return "SamSung";
	}
	
	@RequestMapping("/goHome") //구단소개 페이지에서 메인으로 나오기
	public String goHomePage() {
		return "main";
	}
	
	
//---------------------------------------------------------
	// 로그인 페이지로 이동
		@RequestMapping("/btn_login")
		public String LoginMember() {
			return "Login"; // Login.jsp
		}
		
		
	//로그인:id,pw검사하여 존재하면 로그인 진행
	@RequestMapping("/Login")
	public String Login(@RequestParam("joID") String joID, @RequestParam("joPassword") String joPassword, HttpSession session) {
		JoinVO vo = joinService.LoginCheck(joID,joPassword);
		//System.out.println("id는 = "+joID);
		//System.out.println("pwd는 = "+joPassword);

		//결과 받아서 id와 비밀번호가 일치하면 세션 변수로 저장
		if(vo != null) { //id,pwd가 존재한다면
			session.setAttribute("sid", vo.getJoID());
		}					
		return "main"; //main.jsp
	}
	
	
	//로그아웃
	@RequestMapping("/btn_loginOut")
	public String userLogout(HttpSession session) {
		session.invalidate(); //저장된 세선 비우기
		return "redirect:./"; //index.jsp로 이동
	}
	


	// 회원가입 페이지로 이동
	@RequestMapping("/btn_join")
	public String JoinMember() {
		return "join"; // join.jsp
	}

	// 회원 정보 기입
	@RequestMapping("/insertJoinMember")
	public String InsertJoinMember(JoinVO join) {
		joinService.insertJoin(join);
		return "redirect:./"; //index.jsp로 이동
	}

	// 모든 가입 회원 정보
	@RequestMapping("/joinMemberList")
	public String AllMemberList(Model model) {
		ArrayList<JoinVO> joinList = joinService.joinList();
		model.addAttribute("joinList", joinList);
		return "All_joinMemberView";
	}

	// ID중복 체크
	@ResponseBody
	@RequestMapping("/joinidCheck")
	public int idCehck(@RequestParam("joID") String id) {
		JoinVO vo = joinService.idCheck(id);
		int result = 0;
		if (vo != null)
			result = 1;
		return result;
	}

}
