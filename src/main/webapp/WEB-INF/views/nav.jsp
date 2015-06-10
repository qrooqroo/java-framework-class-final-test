<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/nav.css" />" rel="stylesheet">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
<div class="container" id="navigation">
	<nav class="navbar navbar-custom nav-justified">
		<div class="container">
	        <div id="navbar" class="collapse navbar-collapse">
	        	<ul class="nav navbar-nav">
		            <li><a href="<c:url value='/'/>">Home</a></li>
		            <sec:authorize access="isAuthenticated()">
		            	<li><a href="<c:url value='/mypage'/>">My Page</a></li>
		            </sec:authorize>
				</ul>
	        </div>
		</div>
	</nav>
</div>
</body>
</html>