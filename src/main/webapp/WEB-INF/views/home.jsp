<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
<html>
<head>
<title>Home</title>
</head>
<body>
	<sec:authorize access="isAnonymous()">
		<a href="signup"><button>회원가입</button></a>
		<a href="login"><button>로그인</button></a>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<a href="/j_spring_security_logout"><button>로그아웃</button></a>
	</sec:authorize>
	<table id="productList">
		<thead>
			<tr>
				<th>제목</th>
				<th>가격</th>
				<th>판매자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="list">
				<tr id="${list.productid}">
					<td>${list.title}</td>
					<td>${list.price}</td>
					<td>${list.seller}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 
	<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
	<script src="<c:url value="/resources/js/home.js" />"></script>  
	-->
</body>
</html>

