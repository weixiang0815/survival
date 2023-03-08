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

</head>
<body>
	<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>
	
	<div class="container">
		<table class="table table-hover table-bordered">
			<tr>
				<th>照片</th>
				<th>名稱</th>
				<th>地址</th>
				<th>費用/時段</th>
				<th>容納人數</th>
			</tr>
			<jstl:forEach items="${placelist}" var="frontplace">
				<tr>
					<td class="col-5"><img alt=""
						src="${contextRoot}/front/place/id?id=${frontplace.id}" width="100%"></td>
					<td class="col-1">${frontplace.place_name}</td>
					<td>${frontplace.place_address}</td>
					<td>${frontplace.place_fee} 元</td>
					<td>${frontplace.place_capacity} 人</td>
				</tr>

			</jstl:forEach>
		</table>
	</div>
	
	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>