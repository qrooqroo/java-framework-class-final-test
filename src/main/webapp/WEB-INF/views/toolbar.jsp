<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/toolbar.css" />" rel="stylesheet">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container" id="toolbar">
	<div class="btn-group span6 pull-right" role="group" aria-label="..." >
	  <sec:authorize access="! isAuthenticated()">
	  	<a href="<c:url value='/signup'/>">
	  		<button type="button" class="btn btn-default">회원가입</button></a>
	  	<a href="<c:url value='/login'/>" >
	  		<button type="button" class="btn btn-default">로그인</button></a>
	  </sec:authorize>
	  <sec:authorize access="hasAuthority('USER_ADMIN')">
	  	<a href="<c:url value='/admin'/>">
	  		<button type="button" class="btn btn-default">관리자 페이지</button></a>
	  </sec:authorize>
	  <sec:authorize access="isAuthenticated()">
		<a href="<c:url value='/j_spring_security_logout'/>">
			<button type="button" class="btn btn-default">로그아웃</button></a>
	  </sec:authorize>
	</div>
</div>
</body>
</html>