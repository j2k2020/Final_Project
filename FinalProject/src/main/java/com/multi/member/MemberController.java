package com.multi.member;

/* FinalProject */

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.multi.member.Defense01.Defense01Service;
import com.multi.member.Defense01.Defense01VO;
import com.multi.member.Pitcher01.Pitcher01Service;
import com.multi.member.Pitcher01.Pitcher01VO;
import com.multi.member.Runner01.Runner01Service;
import com.multi.member.Runner01.Runner01VO;
import com.multi.member.hitter01.Hitter01Service;
import com.multi.member.hitter01.hitter01VO;
import com.multi.member.teams.BaseballTeamsService;
import com.multi.member.teams.BaseballTeamsVO;

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
	@Autowired
	private Runner01Service runner01Service;
	@Autowired
	private BaseballTeamsService teamsService;

	
	
//---첫화면: 홈페이지-----------------------------------------------------------------		
	@RequestMapping("/") // 메인페이지
	public String mainPage() {
		return "index"; // index.jsp
	}
	
	@RequestMapping("goHome") // 메인페이지
	public String callBackPage() {
		return "main";
	}

	
	
//선수기록---------------------------------------------------------
	@RequestMapping("/baseball") // 야구-타자
	public String batter1(Model model) {
		ArrayList<hitter01VO> hitter01List = hitter01Service.hitter01List();
		model.addAttribute("hitter01List", hitter01List);
		return "baseball";
	}

	@RequestMapping("/baseball2") // 야구-투수
	public String baseball2(Model model) {
		ArrayList<Pitcher01VO> pitcher01List = Pitcher01Service.pitcher01List();
		model.addAttribute("pitcher01List", pitcher01List);
		return "baseball2";
	}

	@RequestMapping("/baseball3") // 야구-수비
	public String baseball3(Model model) {
		ArrayList<Defense01VO> defense01List = defense01Service.defense01List();
		model.addAttribute("defense01List", defense01List);
		return "baseball3";
	}

	@RequestMapping("/baseball4") // 야구-주루
	public String baseball4(Model model) {
		ArrayList<Runner01VO> runner01List = runner01Service.runner01List();
		model.addAttribute("runner01List", runner01List);
		return "baseball4";
	}

//팀기록---------------------------------------------------------
	@RequestMapping("team")
	public String team() {
		return "team";
	}

//경기일정---------------------------------------------------------
	@RequestMapping("schedule")
	public String schedule() {
		return "schedule";
	}

//챗봇---------------------------------------------------------
	@RequestMapping("AI_ChatBot")
	public String AI_ChatBot() {
		return "AI_ChatBot";
	}


//---마이페이지-----------------------------------------------------------------		
	// 개인정보만 화면에 출력
	@RequestMapping(value = "myPage")
	public String myPage(Model model, HttpSession session) {
		String sid = (String) session.getAttribute("sid");
		JoinVO join = joinService.readMyID(sid);
		model.addAttribute("join", join);
		return "myDetailPage";
	}
	//마이페이지:수정으로
	@RequestMapping("/myUpdate/updateForm/{joID}")
	public String myUpdateForm(@PathVariable String joID, Model model) {
		JoinVO up = joinService.myUpdateForm(joID);
		model.addAttribute("up", up);
		return "myUpdateForm";
	}	
	//마이페이지:수정
	@RequestMapping("/myUpdate/myUpdateForm")
	public String myInfoUpdate(JoinVO up) {
		joinService.myUpdate(up);
		return "redirect:/myPage"; //수정한 정보 다시 확인
	}
	//마이페이지:탈퇴
	@RequestMapping(value="mypage/deleteMember/{joID}")
	public String myPageDelete(@PathVariable String joID, HttpSession session) {
		joinService.deleteMember(joID);
		session.invalidate();
		return "redirect:/"; //홈화면
	}
	
	
//---구단소개-----------------------------------------------------------------	
	@RequestMapping(value = "/teamInfo/{sName}")
	public String teamInfo(@PathVariable String sName, Model model) {
		System.out.println("요청받은 구단명:"+sName);
		BaseballTeamsVO team = teamsService.teamsInfo(sName);
		model.addAttribute("team", team);
		return "TeamsInfo";
	}

	
//---로그인-----------------------------------------------------------------	
	@RequestMapping(value = "btn_login")
	public String LoginMember() {
		return "login"; //로그인페이지로 이동
	}
	//로그인페이지에서 id,pw입력받고 확인
	@RequestMapping("Login")
	public String Login(@RequestParam("joID") String joID, @RequestParam("joPassword") String joPassword,HttpSession session) {
		JoinVO vo = joinService.loginCheck(joID, joPassword);
		// 결과 받아서 id와 비밀번호가 일치하면 세션 변수로 저장
		if (vo != null) { session.setAttribute("sid", vo.getJoID()); }
		return "main"; //id,pw가 존재하면 메인페이지로 이동
	}	
//---로그인:관리자페이지-----------------------------------------------------------------	
	//관리자페이지:전체 회원
	@RequestMapping("AllPage")
	public String allMemberList(Model model) {
		ArrayList<JoinVO> memlist=joinService.memberList();
		model.addAttribute("memlist", memlist);
		return "/admin/adminPage"; //전체 리스트
	}
	//관리자:상세 조회
	@RequestMapping(value = "/admin/memberDetailView/{joID}")
	public String updateMemberView(@PathVariable String joID, Model model) {
		JoinVO join = joinService.UpdateMember(joID);
		model.addAttribute("join", join);
		return "/admin/memDetailview";//상세정보
	}
	//관리자:수정회원:id로 출력
	@RequestMapping(value = "/admin/memberUpdatForm/{joID}")
	public String updateMemberForm(@PathVariable String joID, Model model) {
		JoinVO join = joinService.UpdateMember(joID);
		model.addAttribute("join",join);
		return "/admin/memUpdateForm";
	}	
	//관리자:수정회원:정보 수정 완료
	@RequestMapping(value = "/admin/update.do")
	public String adminUpdateDo(JoinVO join) {
		joinService.myUpdate(join);
		return "redirect:/AllPage";
	}
	//관리자:회원정보 삭제
	@RequestMapping(value="/deleteMember/{joID}")
	public String deleteMemberPage(@PathVariable String joID) {
		joinService.deleteMember(joID);
		return "redirect:/AllPage"; //회원정보 조회 경로로 이동
	}

	// 로그아웃
	@RequestMapping(value = "btn_loginOut")
	public String userLogout(HttpSession session) {
		session.invalidate(); // 저장된 세선 비우기
		return "redirect:./"; // index.jsp로 이동
	}
	@RequestMapping(value = "loginOut")
	public String bennerLogout(HttpServletRequest request) {
		request.getSession().invalidate(); // 저장된 세선 비우기
		return "redirect:/index";
	}

	
	
// ---회원가입-----------------------------------------------------------------	
	@RequestMapping(value = "btn_join")
	public String JoinMember() {
		return "join"; // 회원가입 페이지로
	}

	// 신규회원정보 입력
	@RequestMapping("insertJoinMember")
	public String InsertJoinMember(JoinVO join) {
		joinService.insertJoin(join);
		return "login"; // 회원가입 후 로그인페이지로
	}

	//회원가입:id중복체크
	@ResponseBody
	@RequestMapping("joinidCheck")
	public int idCehck(@RequestParam("joID") String id) {
		JoinVO vo = joinService.idCheck(id);
		int result = 0;
		if (vo != null) { result = 1; }
		return result; //id체크해서 같은 값이 존재하면 1을 반환
	}
	

	

}
