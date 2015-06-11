<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/addProduct.css" />" rel="stylesheet">
<html>
<head>
<title>Add Product</title>
</head>
<body>
<jsp:include page="toolbar.jsp" flush="false" />
<jsp:include page="nav.jsp" flush="false" />
	<div class="container">
		<div class="col-xs-12 text-center"><h2>상품 등록</h2></div>
		<div class="col-md-2"></div>
		<form name='addProductForm' class="form col-md-8"
			method="POST" action="<c:url value='/product/register/process' />">
			<div class="form-group row">
				<label for="title" class="col-xs-2 control-label">제목</label>
				<div class="col-xs-10">
					<input id="title" name="title" type="text" 
						class="form-control input-mg" placeholder="제목" />
				</div>
			</div>
			<div class="form-group row">
				<label for="price" class="col-xs-2 control-label">가격</label>
				<div class="col-xs-10">
					<input id="price" name="price" type="text"
						 class="form-control input-mg" placeholder="가격(원)" />
				</div>
			</div>
			<div class="form-group row">
				<label for="comment" class="col-xs-2 control-label">상세 설명:</label>
				<div class="col-xs-10">
					<textarea id="comment" name="comment" class="form-control" rows="5"></textarea>
				</div>
			</div>
			<div class="form-group row">
				<button class="btn btn-primary btn-lg btn-block" type="submit">상품 등록</button>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>
<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/addProduct.js" />"></script>
</body>
</html>