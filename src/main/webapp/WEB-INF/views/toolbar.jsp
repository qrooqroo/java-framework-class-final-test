<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/toolbar.css" />" rel="stylesheet">
<div class="container">
	<div id="toolbar" class="col-sm-12">
		<form name='loginForm' method="post" class="form-inline"
			action="<c:url value='/j_spring_security_logout'/>">
			<div class="form-group">${message}</div>
			<sec:authorize access="! isAuthenticated()">
				<div class="form-group">
					<a href="<c:url value='/signup'/>">
						<button type="button" class="btn btn-default">회원가입</button>
					</a> <a href="<c:url value='/login'/>">
						<button type="button" class="btn btn-default">로그인</button>
					</a>
				</div>
			</sec:authorize>
			<sec:authorize access="hasAuthority('ROLE_ADMIN')">
				<div class="form-group">
					<a href="<c:url value='/admin'/>">
						<button type="button" class="btn btn-default">관리자 페이지</button>
					</a>
				</div>
			</sec:authorize>
			<sec:authorize access="hasAuthority('ROLE_SELLER')">
				<div class="form-group">
					<a href="<c:url value='/product/register'/>">
						<button type="button" class="btn btn-default">상품 등록</button>
					</a>
				</div>	
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<div class="form-group" id="logout">
					<button type="submit" class="btn btn-default">로그아웃</button>
					<input type="hidden" name="message" value="성공적으로 로그아웃되었습니다." /> <input
						type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</div>
			</sec:authorize>
		</form>
	</div>
</div>