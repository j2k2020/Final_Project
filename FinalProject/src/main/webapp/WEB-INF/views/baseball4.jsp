<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
	<head>
<meta charset="UTF-8">
<title>baseball(야구)페이지 입니다.</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/header.css'/>">
<link rel="stylesheet" type="text/css"	href="<c:url value='/css/baseball.css'/>">
<link rel="stylesheet" type="text/css"	href="<c:url value='/css/main_footer.css'/>">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
<div id="wrap">

<div id="header">
<div class="header_bg">
<div class="logo_area">
	<div class="logo_img"><a id="logo">United Baseball Club</a></div>
	 <div class="btn2"><a href="btn_loginOut" id="btn_loginOut">로그아웃</a></div>
	 <div class="btn2"><a id="a1">Signed in as &nbsp</a><a id="a2"> ${sessionScope.sid}</a></div> 
	 <div><a href="goHome"><i class="fas fa-home"></i>메인으로</a></div>
</div>
</div>
</div><!-- end header -->

		<div class="event">
				<!--  경기 종목들 -->
				<div class="event_items">
					<a href="baseball">타 자</a>
				</div>
				<div class="event_items">
					<a href="baseball2">투 수</a>
				</div>
				<div class="event_items">
					<a href="baseball3">수 비</a>
				</div>
				<div class="event_items">
					<a href="baseball4">주 루</a>
				</div>
			</div>
			<!-- end event -->
			
	<!-- 선수 검색 창 -->
		<div class="select_area">
			<div class="select">
				<div class="select1">
					<h3 id="select_title">선수검색</h3>
				</div>
				<!--end select_title -->

				<div class="select2">
					<form action="#" id="select_form">
						<input type="text" id="sel_player" placeholder="  ex) 선수이름">
					</form>
				</div>
				<!--end select_form -->
			</div>
			<!-- end select -->
		</div>

		<!-- 리스트:기록 테이블 -->
		<div class="list_body">
			<form action="#">
				<table class="baseball_list">
					<tr>
						<th>순위</th>
						<th>선수명</th>
						<th>팀명</th>
						<th>G</th>
						<th>SBA</th>
						<th>SB</th>
						<th>CS</th>
						<th>SB%</th>
						<th>OOB</th>
						<th>POK</th>
					</tr>
					<c:forEach items="${runner01List }" var="runner">
						<tr align="center">
							<td>${runner.rNum }</td>
							<td>${runner.rName }</td>
							<td>${runner.rTeam }</td>
							<td>${runner.rG }</td>
							<td>${runner.rSBA }</td>
							<td>${runner.rSB }</td>
							<td>${runner.rCS }</td>
							<td>${runner.rSBp }</td>
							<td>${runner.rOOB }</td>
							<td>${runner.rPOK }</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
		<!-- end list_body -->
	</div>
	<!-- end wrap -->
	<div id="footer">
		<br> <br> <a
			href="https://drive.google.com/drive/folders/1EPHrF_y4CtRxgS1JM9hk4yCVCFsROWyM">
			4조[AI 유나이티드 스포츠 클럽-드라이브] </a>
	</div>
</body>
</html>