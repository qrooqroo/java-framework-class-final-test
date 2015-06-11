<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/jumbotron-narrow.css" />" rel="stylesheet">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign Up</title>
</head>
<body>
<div class="container">
	<div class="text-center">
		<h2>SIGN UP</h2>
    </div>
	<form name='signUpForm' class="form-horizontal" role="form" 
			method="POST" action="<c:url value='/signUp' />">
			<div class="form-group">
				<label class="control-label col-sm-2" for="username">아이디 :</label> 
				<div class="col-sm-8">
					<input id="id" name="id" type="text" class="form-control input-md" placeholder="ID"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="password">비밀번호 :</label> 
				<div class="col-sm-8">
					<input id="password" name="password" type="password" class="form-control input-md" placeholder="PASSWORD"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">이름 :</label> 
				<div class="col-sm-8">
					<input id="name" name="name" type="text" class="form-control input-md" placeholder="NAME"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="authority">권한 :</label>
				<div class="col-sm-8">
					<select id="authority" name="authority" class="form-control input-md">
						<option value="sellr">판매자</option>
						<option value="user">사용자</option>
					</select>
				</div>
			</div>
			<div class="col-sm-offset-2 col-sm-4">
				<input class="btn btn-primary btn-md btn-block" 
						type="submit" name="submit" value="회원가입" />
			</div>
			<div class="col-sm-4">
				<a href="<c:url value='/' />">
					<button class="btn btn-default btn-md btn-block" type="button">취소</button>
				</a>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	
</div>
<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/signup.js" />"></script>
</body>
</html>