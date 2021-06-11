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
			
			
		<h1>주루기록 페이지</h1>
	</body>
</html>