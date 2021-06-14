<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/main_header.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login.css'/>">
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


<!-- 아이디,비밀번호 시작-->
<div class="join_div">

<h1>Welcome to Login</h1>

<!-- 로그인창 시작 -->
<form action="/Login" method="post" class="form">
<div>
<label>아이디</label>
<input type="text" name="joID" id="joID" maxlength="20" placeholder="username" required >
</div>
<div>
<label>비밀번호</label>
<input type="password" name="joPassword" id="joPassword" maxlength="20" placeholder="password" required>
</div>

<button type="submit" id="login">로그인</button>
</form><!-- 로그인창 끝 -->

</div>
<!-- 아이디,비밀번호 끝-->	



</body>
</html>