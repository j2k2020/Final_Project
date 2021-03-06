<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/header.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/mydetailpage.css'/>"> 	
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

<div class="join_body">
<h1>My Profile</h1>
<form class="form" action="myUpdate">
<table>
<tr id="tr_b"><th>이름</th><td>${join.joName }</td></tr>
<tr id="tr_b"><th>아이디</th><td><a id="button" href="/myUpdate/updateForm/${join.joID}">${join.joID }</a></td></tr>
<tr id="tr_b"><th>비밀번호</th><td>${join.joPassword }</td></tr>
<tr id="tr_b"><th>이메일</th><td>${join.joEmail }</td></tr>
<tr id="tr_b"><th>년</th><td>${join.joYear }</td></tr>
<tr id="tr_b"><th>월</th><td>${join.joMonth }</td></tr>
<tr><th>일</th><td>${join.joDate }</td></tr>
</table>
<div class="btn">
<a id="button2" href="<c:url value='mypage/deleteMember/${join.joID}'/>" >탈퇴하기</a>
</div>
</form><!-- 로그인창 끝 -->
</div><!-- 아이디,비밀번호 끝-->	

</div>
</body>
</html>