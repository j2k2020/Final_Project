<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>baseball(야구)페이지 입니다.</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/baseball.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/main_footer.css'/>">
</head>
<body>
<div id="wrap">
<div class="header">
<div class="Logo"><a href="/">로고 또는 메인화면으로 돌아가기</a><!-- 메인 화면으로 돌아가기 --></div>
<div class="event"><!--  경기 종목들 -->
<div class="event_items"><a href="#">타 자</a></div>
<div class="event_items"><a href="#">투 수</a></div>
<div class="event_items"><a href="#">수 비</a></div>
<div class="event_items"><a href="#">주 루</a></div>
</div><!-- end event -->
</div><!-- end header -->



<!-- 선수 검색 창 -->
<div class="select_area">
<div class="select">
<div class="select1">
<h3 id="select_title">선수검색</h3>
</div><!--end select_title -->

<div class="select2" >
<form action="#" id="select_form">
<input type="text" id="sel_player" placeholder="  ex) 선수이름">
</form>
</div><!--end select_form -->
</div><!-- end select -->
</div>

<!-- 리스트:기록 테이블 -->
<div class="list_body">
<form action="#">
<table class="baseball_list">
<tr>
<th>순위</th><th>선수명</th><th>팀명</th><th>AVG</th><th>G</th><!-- 5 -->
<th>PA</th><th>AB</th><th>R</th><th>H</th><th>2B</th><!-- 10 -->
<th>3B</th><th>HR</th><th>TB</th><th>RBI</th><th>SAC</th><!-- 15 -->
<th>SF</th>
</tr>
<tr>
<td>1</td><td>2</td><td>3</td><td>4</td><td>5</td>
<td>6</td><td>7</td><td>8</td><td>9</td><td>10</td>
<td>11</td><td>12</td><td>13</td><td>14</td><td>15</td>
<td>16</td>
</tr>
</table>
</form>
</div><!-- end list_body -->
</div><!-- end wrap -->
	<div id="footer">
	<br>
	<br>
	<a href="https://drive.google.com/drive/folders/1EPHrF_y4CtRxgS1JM9hk4yCVCFsROWyM"> 
	4조[AI 유나이티드 스포츠 클럽-드라이브] </a>
	</div>
</body>
</html>