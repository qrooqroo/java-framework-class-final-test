<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/toolbar.css" />" rel="stylesheet">
<div class="container">
	<div id="toolbar">
		<form name='loginForm' method="post" class="form-horizontal"
			action="<c:url value='/j_spring_security_logout'/>">
			${message}
			<sec:authorize access="! isAuthenticated()">
				<a href="<c:url value='/signup'/>">
					<button type="button" class="btn btn-default">회원가입</button>
				</a>
				<a href="<c:url value='/login'/>">
					<button type="button" class="btn btn-default">로그인</button>
				</a>
			</sec:authorize>
			
			<sec:authorize access="hasAuthority('ROLE_ADMIN')">
				<a href="<c:url value='/admin'/>">
					<button type="button" class="btn btn-default">관리자 페이지</button>
				</a>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<a href="<c:url value='/product/register'/>">
					<button type="button" class="btn btn-default">상품 등록</button>
				</a>
				<button type="submit" class="btn btn-default pull-right">로그아웃</button>
				<input type="hidden" name="message" value="성공적으로 로그아웃되었습니다." />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</sec:authorize>
		</form>
	</div>
</div>