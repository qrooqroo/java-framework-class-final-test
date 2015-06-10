<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<jsp:include page="toolbar.jsp" flush="false" />
<jsp:include page="nav.jsp" flush="false" />
<div class="container">
	<div>
		<h1 class="text-center">LOG IN</h1>
    </div>
	<form name='loginForm' class="form col-md-12 center-block" 
			method="post" action="<c:url value='/j_spring_security_check' />">
			<div class="form-group">
				<input type="text" class="form-control input-lg" 
									placeholder="ID" name="j_username"/>
			</div>
			<div class="form-group">
				<input type="password" class="form-control input-lg"
										 placeholder="PASSWORD" name="j_password"/>
			</div>
			<button class="btn btn-primary btn-lg btn-block" type="submit">로그인</button>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<span class="pull-right"><a href="#">Register</a></span>
			<span><a href="#">Need help?</a></span>
	</form>
</div>

</body>
</html>