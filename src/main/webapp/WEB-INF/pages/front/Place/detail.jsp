<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
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
	
	<div class="container">
		<h1>所有場地</h1>

		<table class="table table-hover table-bordered">
			<tr>
				<th>照片</th>
				<th>名稱</th>
				<th>地址</th>
				<th>費用/時段</th>
				<th>容納人數</th>
				
			</tr>
			<jstl:forEach items="${list}" var="onePlace">
				<tr>
					<td><img alt=""
						src="${contextRoot}/front/place/id?id=${onePlace.id}" width="50%"></td>
					<td>${onePlace.place_name}</td>
					<td>${onePlace.place_address}</td>
					<td>${onePlace.place_fee}</td>
					<td>${onePlace.place_capacity}</td>
				</tr>

			</jstl:forEach>
		</table>
	</div>
	
	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>