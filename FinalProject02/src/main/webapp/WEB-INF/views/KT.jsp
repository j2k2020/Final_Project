<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KTwiz</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/header.css'/>">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/teams.css'/>"> 	 
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


<div class="teams">
<h1>KT 위즈</h1>
<form class="form">
<table>
<tr><th>구단명</th><td>${team.btName }</td></tr>
<tr><th>구단사무실</th><td>${team.btOffice }</td></tr>
<tr><th>연락처</th><td>${team.btContact }</td></tr>
<tr><th>홈페이지</th><td><a href="https://www.ktwiz.co.kr/">www.lgtwins.com</a></td></tr>
<tr><th>창단년도</th><td>${team.btEstablishday }</td></tr>
<tr><th>연고지역</th><td>${team.btHometown }</td></tr>
<tr><th>구단주</th><td>${team.btOwner }</td></tr>
<tr><th>대표이사</th><td>${team.btCEO }</td></tr>
<tr><th>단장</th><td>${team.btLeader }</td></tr>
<tr><th>감독</th><td>${team.btDirector }</td></tr>
</table>
<button type="submit" id="submit">수정</button>
<button type="button" id="reset">탈퇴</button><!-- 회원정보 삭제 -->
</form><!-- 로그인창 끝 -->
</div><!-- 아이디,비밀번호 끝-->	



</div>
</body>
</html>