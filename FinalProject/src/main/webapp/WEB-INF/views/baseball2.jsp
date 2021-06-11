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

		<!-- 선수 검색 창 -->
		<div class="select_area">
			<div class="select">
				<div class="select1">
					<h3 id="select_title">선수검색</h3>
				</div>
				<!--end select_title -->

				<div class="select2">
					<form action="#" id="select_form">
						<input type="text" id="sel_player" placeholder="  ex) 선수이름">
					</form>
				</div>
				<!--end select_form -->
			</div>
			<!-- end select -->
		</div>

		<!-- 리스트:기록 테이블 -->
		<div class="list_body">
			<form action="#">
				<table class="baseball_list">
					<tr>
						<th>순위</th>
					    <th>선수명</th>
					    <th>팀명</th>
					    <th>ERA</th>
					    <th>G</th>
					    <th>W</th>
					    <th>L</th>
					    <th>SV</th>
					    <th>HLD</th>
					    <th>WPCT</th>
					    <th>IP</th>
					    <th>H</th>
					    <th>HR</th>
					    <th>BB</th>
					    <th>HBP</th>
					    <th>SO</th>
					    <th>R</th>
					    <th>ER</th>
					    <th>WHIP</th>
					    <th>CG</th>
					    <th>SHO</th>
					    <th>QS</th>
					    <th>BSV</th>
					    <th>TBF</th>
					    <th>NP</th>
					    <th>AVG</th>
					    <th>2B</th>
					    <th>3B</th>
					    <th>SAC</th>
					    <th>SF</th>
					    <th>IBB</th>
					    <th>WP</th>
					    <th>BK</th>
					</tr>
					<c:forEach items="${pitcher01List }" var="pitcher">
						<tr align="center">
							<td>${pitcher.pNum}</td>
						    <td>${pitcher.pName}</td>
						    <td>${pitcher.pTeam}</td>
						    <td>${pitcher.pERA}</td>
						    <td>${pitcher.pG}</td>
						    <td>${pitcher.pW}</td>
						    <td>${pitcher.pL}</td>
						    <td>${pitcher.pSV}</td>
						    <td>${pitcher.pHLD}</td>
						    <td>${pitcher.pWPCT}</td>
						    <td>${pitcher.pIP}</td>
						    <td>${pitcher.pH}</td>
						    <td>${pitcher.pHR}</td>
						    <td>${pitcher.pBB}</td>
						    <td>${pitcher.pHBP}</td>
						    <td>${pitcher.pSO}</td>
						    <td>${pitcher.pR}</td>
						    <td>${pitcher.pER}</td>
						    <td>${pitcher.pWHIP}</td>
						    <td>${pitcher.pCG}</td>
						    <td>${pitcher.pSHO}</td>
						    <td>${pitcher.pQS}</td>
						    <td>${pitcher.pBSV}</td>
						    <td>${pitcher.pTBF}</td>
						    <td>${pitcher.pNP}</td>
						    <td>${pitcher.pAVG}</td>
						    <td>${pitcher.p2B}</td>
						    <td>${pitcher.p3B}</td>
						    <td>${pitcher.pSAC}</td>
						    <td>${pitcher.pSF}</td>
						    <td>${pitcher.pIBB}</td>
						    <td>${pitcher.pWP}</td>
						    <td>${pitcher.pBK}</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
		<!-- end list_body -->
	</div>
	<!-- end wrap -->
	<div id="footer">
		<br> <br> <a
			href="https://drive.google.com/drive/folders/1EPHrF_y4CtRxgS1JM9hk4yCVCFsROWyM">
			4조[AI 유나이티드 스포츠 클럽-드라이브] </a>
	</div>
</body>
</html>