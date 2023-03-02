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
	<jsp:include page="../../Template/admin.jsp"></jsp:include>
	<div class="container">
		<h1>所有倉庫</h1>

		<table class="table table-hover table-bordered">
			<tr>
				<th>場地</th>
				<th>倉庫</th>
				<th colspan="2"></th>
			</tr>
			<jstl:forEach items="${list}" var="warehouse">
				<tr>
					<td><a href="${contextRoot}/place/detail?id=${warehouse.place.id}">${warehouse.place.place_name}</a></td>
					<td><a href="${contextRoot}/warehouse/detail?id=${warehouse.id}">${warehouse.warehouseName}</a></td>
					<td>
						<form action="${contextRoot}/warehouse/edit" method="get">
							<input name="id" type="hidden" value="${warehouse.id}" /> 
							<input type="submit" class="btn btn-info btn-sm" value="修改" />
						</form>
					</td>
					<td>
						<form action="${contextRoot}/warehouse/delete" method="post"> <input
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