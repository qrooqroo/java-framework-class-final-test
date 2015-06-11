<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/jumbotron-narrow.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/productInfo.css" />" rel="stylesheet">
<html>
<head>
<title>Home</title>
</head>
<body>
<div class="container">
	<div class="col-sm-6">
		<div id="title" class="row">${product.title}</div>
		<div>
			<img src="" width="250" height="200">
		</div>
	</div>
	<div>
		<div class="col-sm-6" class="row">
			<div class="col-sm-3">
				<a href="<c:url value='/'/>">
					<button type="button" class="btn btn-default">목록</button>
				</a>
			</div>
			<form name='editProductForm' class="form-inline" role="form"
					method="post" action="<c:url value='/product/edit' />">
				<div class="col-sm-3">
					<button type="submit"class="btn btn-default">수정</button>
					<input type="hidden" name="productid" value="${product.id}" />
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</div>
			</form>
		</div>
		<div class="col-sm-6">
			<br>
			<div>가격 : ${product.price}원</div><br>
			<div>판매자 : ${product.seller}</div><br>
			<form name='buyForm' class="form-inline" role="form"
					method="post" action="<c:url value='/product/${product.id}/cart' />">
				<butotn style="submit" class="btn btn-default">구매</butotn>
			</form>
		</div>
	</div>
	
	<div class="col-sm-10">
		<div><h2>제품 상세 설명</h2></div>
		<div id="comment">${product.comment}</div>
	</div>
</div>
<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>