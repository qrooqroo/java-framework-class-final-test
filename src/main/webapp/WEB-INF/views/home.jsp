<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/jumbotron-narrow.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">

<html>
<head>
<title>Home</title>
</head>
<body>
	<jsp:include page="toolbar.jsp" flush="false" />
	<div class="container">
		
		<div>
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
						<tr id="${list.id}">
							<td class="product-title"><a
								href="<c:url value='/product/${list.id}'/>">${list.title}</a>
							</td>
							<td class="product-price">${list.price}</td>
							<td class="product-seller">${list.seller}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="text-center" id="pager">
				<a href="<c:url value='/?pageSize=${pageSize}&pageno=${pageno-10}'/>"><div class="pagerUnit">&lt;&lt;</div></a>
				<a href="<c:url value='/?pageSize=${pageSize}&pageno=${pageno-1}'/>"><div class="pagerUnit">&lt;</div></a>
				<c:forEach var="before" begin="1" end="5">
					<c:choose>
				      <c:when test="${pageno-(6-before)>=1}">
				      	<a href="<c:url value='/?pageSize=${pageSize}&pageno=${pageno-(6-before)}'/>">
				      		<div class="pagerUnit">${pageno-(6-before)}</div>
				      	</a>
				      </c:when>
				      <c:otherwise>
				    	<div class="pagerUnit">&nbsp;&nbsp;</div>
				      </c:otherwise>
					</c:choose>
				</c:forEach>
				<div class="pagerUnit">${pageno}</div>
				<c:forEach var="after" begin="1" end="5">
					<c:choose>
				      <c:when test="${pageno+after<=totalCount}">
				      	<a href="<c:url value='/?pageSize=${pageSize}&pageno=${pageno+after}'/>">
				      		<div class="pagerUnit">${pageno+after}</div>
				      	</a>
				      </c:when>
				      <c:otherwise>
				    	<div class="pagerUnit">&nbsp;&nbsp;</div>
				      </c:otherwise>
					</c:choose>
				</c:forEach>
				<a href="<c:url value='/?pageSize=${pageSize}&pageno=${pageno+1}'/>"><div class="pagerUnit">&gt;</div></a>
				<a href="<c:url value='/?pageSize=${pageSize}&pageno=${pageno+10}'/>"><div class="pagerUnit">&gt;&gt;</div></a>
			</div>
			<div class="text-center"><h1>^</h1></div>
		</div>
	</div>
	<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>