<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/jumbotron-narrow.css" />" rel="stylesheet">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<div class="container">
	<div class="text-center">
		<h1>LOG IN</h1>
    </div>
	<form name='loginForm' class="form-horizontal" role="form"
			method="post" action="<c:url value='/j_spring_security_check' />">
			<div class="form-group">
			 	<label class="control-label col-sm-2" for="username">아이디 :</label> 
			 	<div class="col-sm-8">
					<input id="username" class="form-control input-md" 
						type="text" placeholder="ID" name="j_username"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="password">비밀번호 :</label>
				<div class="col-sm-8">
					<input id="password" class="form-control input-md" 
							type="password" placeholder="PASSWORD" name="j_password"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
	        		<button class="btn btn-default btn-block" type="submit">로그인</button>
	      		</div>
				<div class="col-sm-4">
					<a href="<c:url value='/' />">
						<button class="btn btn-default btn-block" type="button">취소</button>
					</a>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</div>
	</form>
</div>
<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>