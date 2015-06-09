<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="toolbar.jsp" flush="false" />
<jsp:include page="nav.jsp" flush="false" />
<div class="container">
	<div>
		<h1 class="text-center">SIGN UP</h1>
    </div>
	<form name='signUpForm' class="form col-md-12 center-block" 
			method="POST" action="<c:url value='/signUp' />">
			<div class="form-group">
				<input type="text" class="form-control input-lg" placeholder="ID"/>
			</div>
			<div class="form-group">
				<input type="password" class="form-control input-lg" placeholder="PASSWORD"/>
			</div>
			<div class="form-group">
				<input type="password" class="form-control input-lg" placeholder="PASSWORD CONFIRM"/>
			</div>
			<div class="form-group">
				<input type="text" class="form-control input-lg" placeholder="NAME"/>
			</div>
			<div class="form-group">
				<input type="email" class="form-control input-lg" placeholder="E-MAIL"/>
			</div>
			<div class="form-group">
				<select name="authority" class="form-control">
					<option value="admin">ADMIN</option>
					<option value="user">USER</option>
				</select>
			</div>
			<div class="form-group">
				<input class="btn btn-primary btn-lg btn-block" 
						type="submit" name="submit" value="SIGN UP" />
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</div>
</body>
</html>