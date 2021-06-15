<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/header.css'/>">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
<div id="wrap">

<div id="header">
<div class="header_bg">
<div class="logo_area">
	<div class="logo_img"><a id="logo">United Baseball Club</a></div>
	 <div class="btn2"><a hhref="javascript:history.go(-3);" id="btn_loginOut">로그아웃</a></div>
	 <div class="btn2"><a id="a1">Signed in as &nbsp</a><a id="a2"> ${sessionScope.sid}</a></div> 
	 <div><a href="goHome"><i class="fas fa-home"></i>메인으로</a></div>
</div>
</div>
</div><!-- end header -->
관리자 리스트입니다.
<form>
<table border="1">
<tr><th>이름</th><th>아이디</th><th>비밀번호</th><th>이메일</th><th>출생년도</th><th>월</th><th>일</th><th>DELETE</th><th>UPDATE</th></tr>

<c:forEach items="${memlist }" var="mem">
<tr>
<td>${mem.joName }</td>
<td>${mem.joID }</td>
<td>${mem.joPassword }</td>
<td>${mem.joEmail }</td>
<td>${mem.joYear }</td>
<td>${mem.joMonth }</td>
<td>${mem.joDate }</td>
<td><a href="updateMember/${mem.joID }">수정</a></td>
<td><a href="deleteMember/${mem.joID }">삭제</a></td>
</tr>
</c:forEach>
</table>
</form>
</div>

</body>
</html>