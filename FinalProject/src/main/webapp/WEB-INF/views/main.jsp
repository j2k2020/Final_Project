<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login 후 메인페이지</title>
 <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/main_header.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/main.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/main_footer.css'/>">
</head>
<body>
<div id="wrap">

<div id="header">
<div class="header_bg">
<div class="logo_area">
	<div class="logo_img"><a id="logo">United Baseball Club</a></div>
	<c:if test="${not empty sessionScope.sid }">  
	<div class="btn2"><a href="<c:url value='btn_loginOut' />" id="btn_loginOut"><i class="fas fa-home"></i>로그아웃</a></div>
	<div class="btn2"><a id="a1">Signed in as &nbsp</a><a id="a2"> ${sessionScope.sid}</a></div>
	</c:if> 
</div>
</div>
</div><!-- end header -->

<!-- 내비바로 변경 예정 -->
<nav>
	<div class="nav_item">
		<a href="baseball" id="baseball">선수기록</a>
	</div>
	<div class="nav_item">
		<a href="team" id="team" >팀기록</a>
	</div>
	<div class="nav_item">
		<a href="schedule" id="schedule" >경기일정</a>
	</div>
	<div class="nav_item">	
		<a href="AI_ChatBot" id="AI_ChatBot">챗봇</a>
	</div>
	<div class="nav_item2">	
	<c:if test="${sessionScope.sid == 'admin'}">  
		<a href="<c:url value='AllPage' />" id="myPage">회원관리</a>
		</c:if>
		<c:if test="${sessionScope.sid != 'admin'}">  
		<a href="<c:url value='myPage' />" id="myPage">마이페이지</a>
		</c:if>
	</div>
</nav><!-- end nav-->

<!-- 메인바디-구단로고들로 배너 생성 -->
<div class="main_body">
<div class="team_Banners">
<div class="img_box5">
	<a href="<c:url value='/teamInfo/${"LG"}'/>"><img alt="LG트윈스" id="LGpop" src="<c:url value='/image/LG.jpg'/>"></a>
</div>
<div class="img_box5">
	<a href="<c:url value='/teamInfo/${"KT"}'/>"><img alt="KT위즈" class="profile" src="<c:url value='/image/Kt.jpg'/>"></a>
</div>
<div class="img_box5">
	<a href="<c:url value='/teamInfo/${"SSG"}'/>">
	<img alt="SSG랜더스" class="profile" src="<c:url value='/image/SSG.jpg'/>"></a>
</div>
<div class="img_box5">
	<a href="<c:url value='/teamInfo/${"SamSung"}'/>">
	<img alt="삼성 라이온즈" class="profile" src="<c:url value='/image/SamSung.jpg'/>"></a>
</div>
<div class="img_box5">
	<a href="<c:url value='/teamInfo/${"DooSan"}'/>">
	<img alt="두산베어스" class="profile" src="<c:url value='/image/DooSan.jpg'/>"></a>
</div>
<div class="img_box10">
    <a href="<c:url value='/teamInfo/${"NC"}'/>">
    <img alt="NC다이노스" class="profile" src="<c:url value='/image/NC.jpg'/>"></a>
</div>
<div class="img_box10">
    <a href="<c:url value='/teamInfo/${"Kiwoom"}'/>">
	<img alt="키움히어로즈" class="profile" src="<c:url value='/image/Kiwoom.jpg'/>"></a>
</div>	
<div class="img_box10">
    <a href="<c:url value='/teamInfo/${"KIA"}'/>">
	<img alt="KIA타이거즈" class="profile" src="<c:url value='/image/KIA.jpg'/>"></a>
</div>
<div class="img_box10">
    <a href="<c:url value='/teamInfo/${"Hanwha"}'/>">
	<img alt="한화이글스" class="profile" src="<c:url value='/image/Hanwha.jpg'/>"></a>
</div>
<div class="img_box10">
    <a href="<c:url value='/teamInfo/${"Lotte"}'/>">
	<img alt="롯데자이언츠" class="profile" src="<c:url value='/image/Lotte.jpg'/>"></a>
</div>
</div>
</div>
</div><!-- end main_body: 배너 끝-->
</div><!-- end wrap -->


<div id="footer">
<a href="https://drive.google.com/drive/folders/1EPHrF_y4CtRxgS1JM9hk4yCVCFsROWyM"> 
4조[AI 유나이티드 스포츠 클럽-드라이브] </a>
</div>

</body>
</html>