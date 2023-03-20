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
<jsp:include page="../../Template/admin.jsp"></jsp:include>
<div class="container">
		<h1>所有庫存</h1>

		<table class="table table-hover table-bordered">
			<tr>
				<th class="text-center">倉庫</th>
				<th class="text-center">商品</th>
				<th class="text-center">販賣數量</th>
				<th class="text-center">租借數量</th>
				<th class="text-center">商品圖片</th>
				<th colspan="2"></th>
			</tr>
			<jstl:forEach items="${list}" var="inventory">
				<tr>
					<td class="text-center col-1">${inventory.warehouse.warehouseName}</td>
					<td class="text-center col-2">${inventory.product.name}</td>
					<td class="text-center col-1">${inventory.inventorySellamount}</td>
					<td class="text-center col-1">${inventory.inventoryRentamount}</td>
					<td class="col-4"><img alt="" src="${contextRoot}/inventory/id?id=${inventory.product.id}"
								width="100%"></td>
					
					<td class="text-center col-1">
						<form action="${contextRoot}/inventory/edit" method="get">
							<input name="id" type="hidden" value="${inventory.id}" /> 
							<input type="submit" class="btn btn-info btn-sm" value="修改" />
						</form>
					</td>
					<td class="text-center col-1">
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