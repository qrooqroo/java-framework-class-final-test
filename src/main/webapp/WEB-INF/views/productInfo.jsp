<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/productInfo.css" />" rel="stylesheet">
<html>
<head>
<title>Home</title>
</head>
<body>
<jsp:include page="toolbar.jsp" flush="false" />
<jsp:include page="nav.jsp" flush="false" />
<div class="container">
	<div class="col-xs-12 text-center"><h2>상품 정보</h2></div>
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<dl class="row">
				<dt class="col-md-2">제목</dt>
				<dd class="col-md-10">${product.title}</dd>
			</dl>
			<dl class="row">
				<dt class="col-md-2">가격</dt>
				<dd class="col-md-10">${product.price}</dd>
			</dl>
			<dl class="row">
				<dt class="col-md-2">상세 설명</dt>
				<dd class="col-md-10">${product.comment}</dd>
			</dl>
			<div class="row">
				<button class="btn btn-primary btn-lg btn-block" type="button">뒤로</button>
			</div>
		</div>
</div>
<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>