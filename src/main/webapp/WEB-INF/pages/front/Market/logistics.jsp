<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="tw.survival.model.Market.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>訂單詳情</title>
<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
<style type="text/css">
	*{
	margin: 0;
	padding: 0;
	List-style: none;
	}
	.step{
		width: 500px;
		margin: 100px auto;
		out
	}
ul#comp-link>li {
	list-style-type: none;
}
</style>
</head>
<body>
	<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>

	<div class="container">
		<h1>產品物流</h1>

		<table class="table table-hover table-bordered">
			<tr>
				<th>訂單ID</th>
				<th>建立日期</th>
				<th>狀態</th>

			</tr>
			<c:forEach items="${orderList}" var="show">
				<tr>
					<td>${show.id}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${show.order_create_date}" /></td>
					<td>${show.status}</td>
				</tr>
			</c:forEach>
		</table>
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>起始日期</th>
					<th>到貨日期</th>
					<th>狀態</th>
				</tr>
			</thead>
			
			<tbody>
				<jstl:forEach items="${list}" var="Logistics">
					<tr>
						<td>${Logistics.id}</td>
						<td><fmt:formatDate pattern="yyyy/MM/dd"
								value="${Logistics.start_date}" /></td>
						<td><fmt:formatDate pattern="yyyy/MM/dd"
								value="${Logistics.arrive_date}" /></td>
						<td>${Logistics.status}</td>
					</tr>
				</jstl:forEach>
		</table>
	</div>

	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>