<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
</head>
<body>
<h2>회원가입 후 -> 회원리스트 확인</h2>
<table border="1" width="600">
<tr>
<th>이름</th><th>아이디</th><th>비밀번호</th><th>이메일</th><th>출생년도</th><th>월</th><th>일</th>
</tr>

<!-- for문 -->
<c:forEach items="${joinList}" var="join">
<tr>
<td>${join.joName }</td>
<td>${join.joID }</td>
<td>${join.joPassword }</td>
<td>${join.joEmail }</td>
<td>${join.joYear}</td>
<td>${join.joMonth}</td>
<td>${join.joDate}</td>
</tr>
</c:forEach>
</table>
<br><br>

<a href="/">메인으로</a>
</body>
</html>