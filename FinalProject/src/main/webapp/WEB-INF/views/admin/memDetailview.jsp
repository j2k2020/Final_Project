<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세정보</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/header.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/admin2.css'/>"> 	
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
<div class="table">
<form>
<table>
<tr><th>이름</th><td>${join.joName }</td></tr>
<tr><th>아이디</th><td>${join.joID }</td></tr>
<tr><th>비밀번호</th><td>${join.joPassword }</td></tr>
<tr><th>이메일</th><td>${join.joEmail }</td></tr>
<tr><th>출생년도</th><td>${join.joYear }</td></tr>
<tr><th>월</th><td>${join.joMonth }</td></tr>
<tr><th>일</th><td>${join.joDate }</td></tr>
</table>
</form>
<br><br> 
<a id="button" href="/admin/memberUpdatForm/${join.joID }">정보 수정</a>
</div>
</body>
</html>
</body>
</html>