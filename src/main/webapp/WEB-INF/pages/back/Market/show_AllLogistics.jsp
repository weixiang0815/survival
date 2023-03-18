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
<title>所有物流</title>
</head>
<body>

	<jsp:include page="../../Template/admin.jsp"></jsp:include>
	<h1>所有物流</h1>
	<table class="table table-hover table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>收件人</th>
				<th>起始日期</th>
				<th>到貨日期</th>
				<th>狀態</th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach items="${list}" var="logistics">
				<tr>
					<td>${logistics.id}</td>
					<td>${logistics.player.name}</td>
					<td><fmt:formatDate pattern="yyyy/MM/dd "
							value="${logistics.start_date}" /></td>
					<td><fmt:formatDate pattern="yyyy/MM/dd "
							value="${logistics.arrive_date}" /></td>
					<td>${logistics.status}</td>
					<td><form action="${contextRoot}/Market/editlogistics"
							method="get">
							<input name="id" type="hidden" value="${logistics.id}" /> <input
								type="submit" class="btn btn-info btn-sm" value="編輯" />
						</form></td>

					<td>
						<form action="${contextRoot}/Market/deletelogistics" method="post">
							<input name="_method" type="hidden" value="delete" /> 
							<input name="id" type="hidden" value="${logistics.id}" /> <input
								type="submit" class="btn btn-danger btn-sm" value="刪除" />
						</form>
					</td>
				</tr>
			</jstl:forEach>
		</tbody></table>
</body>
</html>