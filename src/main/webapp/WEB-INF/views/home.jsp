<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
<html>
<head>
<title>Home</title>
</head>
<body>
<jsp:include page="toolbar.jsp" flush="false" />
<jsp:include page="nav.jsp" flush="false" />
<div class="container">

	<div class="panel panel-default">
	  <div class="panel-heading">제품 목록</div>
	 
	  <!-- Table -->
	  <table class="table" id="product-list">
	  	<thead>
			<tr>
				<th class="product-title">제목</th>
				<th class="product-price">가격</th>
				<th class="product-seller">판매자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="list">
				<tr id="${list.productid}">
					<td class="product-title">${list.title}</td>
					<td class="product-price">${list.price}</td>
					<td class="product-seller">${list.seller}</td>
				</tr>
			</c:forEach>
		</tbody>
	  </table>
	</div>
</div>
	<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/home.js" />"></script>  
</body>
</html>

