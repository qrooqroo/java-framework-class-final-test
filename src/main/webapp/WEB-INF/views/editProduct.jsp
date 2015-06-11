<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/jumbotron-narrow.css" />" rel="stylesheet">
<html>
<head>
<title>Edit Product</title>
</head>
<body>
	<div class="container">
		<sec:authentication property="principal.username"/>님의 상품
		<div class="text-center">
			<h2>상품 수정</h2>
    	</div>
    	<form name='editProductForm' class="form-horizontal" role="form"
			method="post" action="<c:url value='/product/edit/process' />">
			<div class="form-group">
			 	<label class="control-label col-sm-2" for="title">제목 :</label> 
			 	<div class="col-sm-8">
					<input id="title" class="form-control input-md" value="${product.title}" 
						type="text" placeholder="제목" name="title"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="price">가격 :</label>
				<div class="col-sm-8">
					<input id="price" class="form-control input-md" value="${product.price}" 
							type="number" placeholder="가격" name="price"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="comment">상세 설명 :</label>
				<div class="col-sm-8">
					<textarea id="comment" name="comment" class="form-control input-md" rows="5">${product.comment}</textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
	        		<button class="btn btn-default btn-block" type="submit">수정</button>
	      		</div>
				<div class="col-sm-4">
					<a href="<c:url value='/' />">
						<button class="btn btn-default btn-block" type="button">취소</button>
					</a>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<input type="hidden" name="productid" value="${product.id}" />
			</div>
		</form>
	</div>
	
<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>