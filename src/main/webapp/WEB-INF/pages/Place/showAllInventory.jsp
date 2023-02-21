<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有庫存</title>
</head>
<body>
<jsp:include page="../Layout/navbar_place.jsp"></jsp:include>
<div class="container">
		<h1>所有庫存</h1>

		<table class="table table-hover table-bordered">
			<tr>
				<th>倉庫</th>
				<th>商品</th>
				<th>販賣數量</th>
				<th>租借數量</th>
				<th colspan="2"></th>
			</tr>
			<jstl:forEach items="${list}" var="inventory">
				<tr>
					<td>${inventory.warehouse.warehouseName}</td>
					<td>${inventory.product.name}</td>
					<td>${inventory.inventorySellamount}</td>
					<td>${inventory.inventoryRentamount}</td>
					
					<td>
						<form action="${contextRoot}/inventory/edit" method="get">
							<input name="id" type="hidden" value="${inventory.id}" /> 
							<input type="submit" class="btn btn-info btn-sm" value="修改" />
						</form>
					</td>
					<td>
						<form action="${contextRoot}/inventory/delete" method="post"> <input
								name="id" type="hidden" value="${inventory.id}" /> <input
								type="submit" class="btn btn-danger btn-sm" value="刪除" />
						</form>
					</td>
				</tr>

			</jstl:forEach>
		</table>
	</div>
</body>
</html>