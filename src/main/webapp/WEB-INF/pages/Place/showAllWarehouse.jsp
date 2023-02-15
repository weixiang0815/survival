<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有倉庫</title>
</head>
<body>
	<jsp:include page="../Layout/navbar_place.jsp"></jsp:include>
	<div class="container">
		<h1>All Place</h1>

		<table class="table table-hover table-bordered">
			<tr>
				<th>場地</th>
				<th>名稱</th>
				<th colspan="2"></th>
			</tr>
			<jstl:forEach items="${list}" var="warehouse">
				<tr>
					<td>${warehouse.place.place_name}</td>
					<td>${warehouse.warehouseName}</td>
					<td>
						<form action="${contextRoot}/warehouse/edit" method="get">
							<input name="id" type="hidden" value="${warehouse.id}" /> <input
								type="submit" class="btn btn-info btn-sm" value="編輯" />
						</form>
					</td>
					<td>
						<form action="${contextRoot}/place/delete" method="post">
							<input name="_method" type="hidden" value="delete" /> <input
								name="id" type="hidden" value="${warehouse.id}" /> <input
								type="submit" class="btn btn-danger btn-sm" value="刪除" />
						</form>
					</td>
				</tr>

			</jstl:forEach>
		</table>
	</div>
</body>
</html>