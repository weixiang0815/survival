<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>場地詳情</title>
<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
<style>
ul#comp-link>li {
	list-style-type: none;
}
</style>
</head>
<body>
	<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>
	<div class="container text-center">
		<h1>場地系統</h1>
		<ul id="comp-link">
			<li><a href="${contextRoot}/front/place/all">場地詳情</a></li>
			<li><a href="${contextRoot}/front/schedule/new">活動排程</a></li>
		</ul>
	</div>
	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>