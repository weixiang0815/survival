<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢訂單</title>
</head>
<body>
	<jsp:include page="../../Template/admin.jsp"></jsp:include>
	<h1>查詢訂單</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">id</th>
				<th scope="col">新建日期</th>
				<th scope="col">狀態</th>
				<th scope="col">會員ID</th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach items="${SearchResult1}" var="search" varStatus="Status">
				<tr>
					<th scope="row">${Status.index+1}</th>
					<td>${search.name}</td>
					<td><img alt="" height="100" width="160"
						src="${contextRoot}/Market/id?id=${search.id}"></td>
					<td>${search.order_create_date}</td>
					<td>${search.status}</td>
					<td>${search.fk_player_id}</td>
					<td>
						<form action="${contextRoot}/Market/editOrder" method="get">
							<input name="id" type="hidden" value="${search.id}" /> <input
								type="submit" class="btn btn-info btn-sm" value="編輯" />
						</form>
					</td>
					<td>
						<form action="${contextRoot}/Market/deleteOrder" method="post">
							<input name="_method" type="hidden" value="delete" /> <input
								name="id" type="hidden" value="${show_AllProduct.id}" /> <input
								type="submit" class="btn btn-danger btn-sm" value="刪除" />
						</form>
					</td>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
</body>
</html>