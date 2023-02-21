<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有訂單</title>
</head>
<body>
	<jsp:include page="Layout/navbar_market.jsp"></jsp:include>
	<div class="container">
		<h1>所有訂單</h1>
		<table class="table table-hover table-bordered table-dark">
			<thead>
				<tr>
					<th>訂單 ID</th>
					<th>建立日期</th>
					<th>狀態</th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach items="${list}" var="show">
					<tr>
						<td>${show.id}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd"
								value="${show.order_create_date}" /></td>
						<td>${show.status}</td>
						<td><form action="${contextRoot}/Market/editOrder" method="get">
								<input name="id" type="hidden" value="${show.id}" />
								<input type="submit" class="btn btn-info btn-sm" value="編輯" />
							</form></td>

						<td><form action="${contextRoot}/Market/deleteOrder" method="post">
								<input name="_method" type="hidden" value="delete" /> <input
									name="id" type="hidden" value="${show.id}" /> <input
									type="submit" class="btn btn-danger btn-sm" value="刪除" />
							</form></td>

					</tr>
				</jstl:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>