<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/jumbotron-narrow.css" />" rel="stylesheet">
<html>
<head>
<title>Cart</title>
</head>
<body>
	<div class="container">
		${userid}님의 장바구니
		<div>
			<table class="table" id="cart-list">
				<thead>
					<tr>
						<th>상품명</th>
						<th>가격</th>
						<th>판매자</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="product">
						<tr id="${product.id}">
							<td>
								<a href="<c:url value='/product/${product.id}'/>">${product.title}</a>
							</td>
							<td>${product.price}</td>
							<td>${product.seller}</td>
							<td>
								<form name='deletForm' class="form-inline" role="form"
										method="post" action="<c:url value='/${userid}/cart/${product.id}/delete' />">
									<button type="submit" class="btn btn-default">주문 취소</button>
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="text-center" id="total">
				<c:set var="sum" value="0"/>
				<c:forEach items="${list}" var="list">
					<c:set var="sum" value="${sum+list.price}"/>
				</c:forEach>
				<span>총 가격 : ${sum}</span>
			</div>
		</div>
	</div>
<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>