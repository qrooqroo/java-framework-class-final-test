<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<table id="productList">
	<thead>
		<tr>
			<th>제목</th>
			<th>가격</th>
			<th>판매자<th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="list">
        	<tr id="${list.productid}">
        		<td>${list.title}</td>
        		<td>${list.price}</td>
        		<td>${list.seller}</td>
        	</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>
