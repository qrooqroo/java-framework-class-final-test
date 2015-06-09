<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<div>로그인</div>
<div>
	<form name='loginForm' method="POST" action="<c:url value='/j_spring_security_check' />">
			<div>
				<input type="text" placeholder="ID" name="username" value="${j_username}" />
			</div>
			<div>
				<input type="password" placeholder="PASSWORD" name="password" value="${j_password}" />
			</div>
			<div>
				<input type="submit" name="submit" value="로그인" />
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	
</div>

</body>
</html>