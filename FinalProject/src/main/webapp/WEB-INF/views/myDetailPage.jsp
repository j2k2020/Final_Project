<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/header.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/join.css'/>"> 	
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
<div>
<label>이름</label>
<input type="text" id="joName" value="${join.joName }" readonly>
</div>
<div>
<label>아이디</label>
<input type="text" id="joID" value="${join.joID }" readonly>
</div>
<div>
<label>비밀번호</label>
<input type="password" id="joPassword" value="${join.joPassword }" >
</div>
<div>
<label>이메일 주소</label>
<input type="text" id="joEmail" value="${join.joEmail }" >
</div>
<div class="birth">
<label>생년월일</label>
<input type="text"  id="yy"  maxlength="4" size="4" value="${join.joYear }" >
<input type="text"  id="mm"  maxlength="2" size="2" value="${join.joMonth }" >
<input type="text"  id="dd"  maxlength="2" size="2" value="${join.joDate }" >
</div>
<input type="submit" value="수정하기"> 
<input type="submit" value="탈퇴하기"><!-- 회원정보 삭제 -->
</form><!-- 로그인창 끝 -->
</div><!-- 아이디,비밀번호 끝-->	

</div>
</body>
</html>