<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改訊息</title>
</head>
<body>
	<jsp:include page="Layout/navbar_market.jsp"></jsp:include>

	<div class="container">
		<h1>修改訊息</h1>

		<div class="card">
			<div class="card-header">修改訂單訊息</div>
			<div class="card-body">
				<form action="${contextRoot}/Market/editOrder" method="post">
					<input type="text" name="id" value="${OrderItem.id}" hidden />
					<table class="table table-hover">
						<tr>
							<td>訂單時間:</td>
							<td><input type="date" name="order_create_date"
								value="${OrderItem.order_create_date}" /></td>
						</tr>

						<tr>
							<td>訂單狀態：</td>
							<td><input type="text" name="status"
								value="${OrderItem.status}" /></td>
						</tr>
					</table>
					<input class="btn btn-primary" type="submit" value="更新" />
				</form>

			</div>
		</div>

	</div>
</body>
</html>