<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有物流</title>
</head>
<body>
	<jsp:include page="../Template/admin.jsp"></jsp:include>
	<h1>所有物流</h1>
	<table class="table table-hover table-bordered table-dark">
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
					<td><form action="${contextRoot}/Market/editLogistics"
							method="get">
							<input name="id" type="hidden" value="${Logistics.id}" /> <input
								type="submit" class="btn btn-info btn-sm" value="編輯" />
						</form></td>

					<td>
						<form action="${contextRoot}/Market/deleteLogistics" method="post">
							<input name="_method" type="hidden" value="DELETE" /> <input
								name="deleteid" type="hidden" value="${Logistics.id}" /> <input
								type="submit" class="btn btn-danger btn-sm" value="刪除" />
						</form>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
</body>
</html>