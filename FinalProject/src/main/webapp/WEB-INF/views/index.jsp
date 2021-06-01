<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index 페이지</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/main_header.css'/>"> 	  
<link rel="stylesheet" type="text/css" href="<c:url value='/css/main_container.css'/>"> 	
</head>

<body>
<h1>index 페이지가-->main페이지 입니다.</h1>
<div id="wrap">
<div id="header">
<div class="header_bg">
<div class="logo_area">
<h1 class="logo_img">
<a id="logo">검색</a>
</h1>
</div>
<div class="search_area" id="search" data-clk-prefix="sch">
<form action="/search" class="search_form" name="search_form" method="get" role="search" >
<input id="s_input" type="text" placeholder="검색어를 입력하세요">
<input id="submit" type="submit" value="검색" onclick="/">
</form>
</div>
</div>
</div>

<div id="container" role="main">메인 부분으로 메인페이지 전체 구성입니다.
<div id="main_left" class="main_left">메인_왼쪽
<div id="main_left_nav" class="main_left_nav">메인_왼쪽_네비_바
<div class="group_nav">
<ul>
<li id="nav_item1">야구</li>
</ul>
<ul>
<li id="nav_item2">축구</li>
</ul>
<ul>
<li id="nav_item3">농구</li>
</ul>
<ul>
<li id="nav_item4">배구</li>
</ul>
</div>
</div>
<div class="main_body">
<div class="mLeft_left">메인_왼쪽_네비바 밑에 [메인 이미지]<br>
<br>
<br>
<a>이미지가 들어갈 공간</a></div>
<div class="mLeft_right">메인_왼쪽_네비바 밑에 [각 팀별 베너]</div>
</div>
</div>
<div class="main_right">메인_오른쪽
<br>
<form action="/Login" class="login">
<br>
<h1>로그인</h1>
<br>
<input type="text" id="loginID" name="loginID" maxlength="60" placeholder="아이디를 입력하세요">
<p>
<input type="password" id="loginPW" name="loginPW" maxlength="60" placeholder="비밀번호를 입력하세요">
<p>
<input class="btn" type="button" id="btn_login" name="btn_login" value="로그인">
<input class="btn" type="button" id="btn_join_member" name="btn_join_member" value="회원가입">
</form>
<p>

<table border="1"><tr><th>메인_오른쪽[ 챗봇 ]</th></tr></table><br>
</div>
</div>
<br>
<br>
<a href="join">회원가입 페이지</a><br><br>
<a href="joinMemberList">회원 정보 페이지</a><br><br>
</div>
</body>
</html>