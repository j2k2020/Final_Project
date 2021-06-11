<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<script src="<c:url value='/js/jquery-3.6.0.min.js'/>"></script>
<script src="<c:url value='/js/joinidCheck.js'/>"></script>
<script src="<c:url value='/js/joinMember.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/main_header.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/join.css'/>"> 	 
</head>

<body>
<div id="wrap">
<div id="header">
<div class="header_bg">
<div class="logo_area">
<div class="logo_img">
<a id="logo">United Baseball Club</a>
</div>
<div class="btn1"><a href="/">Home</a></div>
</div>
</div>
</div><!-- end header -->

<div class="join_body">
<h1>Sign up</h1>
<!-- 회원가입창 시작 -->
<form  action="/insertJoinMember"  method="post" name="userInfo" onsubmit="return checkValue()" class="form">
<div>
<label>이름</label>
<input type="text" id="joName" name="joName" maxlength="50" style="font-size:12pt;" placeholder="name" required>
</div>
<div>
<label>아이디</label>
<input type="text" id="joID" name="joID"  maxlength="50" style="font-size:12pt;" placeholder="username" required>
</div>
<div class="IDCheck">
<button type="button" id="idCheck" name="idCheck">ID중복체크</button>
</div>
<div>
<label>비밀번호</label>
<input type="password" id="joPassword" name="joPassword" maxlength="50" style="font-size:12pt;" placeholder="password" required>
</div>
<div>
<label>이메일 주소</label>
<input type="text" id="joEmail" name="joEmail" maxlength="50" style="font-size:12pt;" placeholder="email" required>
</div>
<div class="birth">
<label>생년월일</label>
<input type="text" name="joYear" id="yy"  placeholder="yyyy" maxlength="4" style="font-size:12pt;" size="4">
<input type="text" name="joMonth" id="mm"  placeholder="mm" maxlength="2" style="font-size:12pt;" size="2">
<input type="text" name="joDate" id="dd" placeholder="dd" maxlength="2" style="font-size:12pt;" size="2">
</div>
<button type="submit" id="submit" onclick="goFirstForm()">가입</button>
<button type="reset" id="btn_reset">취소</button>
</form><!-- 로그인창 끝 -->

</div><!-- 아이디,비밀번호 끝-->	
</div><!-- end wrap -->
</body>
</html>