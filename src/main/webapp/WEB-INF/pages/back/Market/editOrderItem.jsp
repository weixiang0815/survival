<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="tw.survival.model.Market.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改訊息</title>
</head>
<body>
	<jsp:include page="../../Template/admin.jsp"></jsp:include>

	<div class="container">
		<h1>修改訊息</h1>

		<div class="card">
			<div class="card-header">修改訂單訊息</div>
			<div class="card-body">
				<form:form action="${contextRoot}/Market/editOrder" method="put"
					modelAttribute="order">
					<form:input type="hidden" path="id" />
					<form:input type="hidden" path="player" />
					<table class="table table-hover">
						<tr>
							<td><form:label class="form-label" path="order_create_date">訂單時間:</form:label></td>
							<td><form:input type="text" path="order_create_date"
									placeholder="yyyy/mm/dd" required="true" /></td>
						</tr>

						<tr>
							<td>訂單狀態：</td>
							<td><form:select class="form-control" path="status">
									<form:option value="處理中">處理中</form:option>
									<form:option value="已出貨">已出貨</form:option>
									<form:option value="已取貨">已取貨</form:option>
									<form:option value="棄單">棄單</form:option>
								</form:select></td>
						</tr>
					</table>
					<button type="submit" class="btn btn-outline-primary">送出</button>
				</form:form>

			</div>
		</div>

	</div>
</body>
</html>