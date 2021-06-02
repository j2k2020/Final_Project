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
<link rel="stylesheet" type="text/css" href="<c:url value='/css/join.css'/>"> 	  
</head>
<body>
<div id="wrap"> 
<div id="main_title">
<h1>회원가입</h1>
</div>

<form method="post" action="/insertJoinMember"  name="userInfo" onsubmit="return checkValue()">

<div class="join_div">
<h3 class="join_title">이름</h3>
<span class="ps_box"><input type="text" name="joName" maxlength="10" style="font-size:12pt;"></span>
</div>

<!-- 아이디,비밀번호 시작-->
<div class="join_div">
<h3 class="join_title">아이디</h3>
<span class="ps_box"><input type="text" id="joID" name="joID"  maxlength="20" style="font-size:12pt;"></span>
<input type="button" id="idCheck" name="idCheck" class="input_box" value="ID 중복 체크">
<input type="hidden" name="idDuplication" value="idUncheck" >
</div>
<div class="join_div">
<h3 class="join_title">비밀번호</h3>
<span class="ps_box"><input type="text" name="joPassword" maxlength="20" style="font-size:12pt;"></span>
</div>
<!-- 아이디,비밀번호 end-->

<!-- 이메일 시작-->
<div class="join_div">
<h3 class="join_title">이메일 주소</h3>
<span class="ps_box"><input type="text" name="joEmail" maxlength="20" style="font-size:12pt;"></span>
</div>
<!-- 이메일 end-->

<!-- 생년월일 시작-->
<div class="join_div">
<div class="birthday">
<h3 class="join_title">생년월일</h3>
<!--출생 년도-->
<div class="bir_yy">
<span class="ps_box">
<input type="text" name="joYear" id="yy"  placeholder="yyyy" maxlength="4" style="font-size:12pt;">
</span>
</div>
<!--출생 월-->
<div class="bir_mm">
<span class="ps_box">
<input type="text" name="joMonth" id="mm"  placeholder="mm" maxlength="2" style="font-size:12pt;">
</span>
</div>
<!--출생 일-->
<div class="bir_dd">
<span class="ps_box">
  <input type="text" name="joDate" id="dd" placeholder="dd" maxlength="2" style="font-size:12pt;">
</span>
</div>
</div>
</div>
<!-- 생년월일 end-->

<input type="submit" id="submit" value="등록" onclick="goFirstForm()">
<input type="reset" value="취소">

</form><br><br>
<a href="/">메인으로</a><br>
<a href="joinMemberList">회원 정보 페이지</a>
<br>
</div>
</body>
</html>