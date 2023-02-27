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
<title>倉庫詳情</title>
</head>
<body>
<jsp:include page="../Template/admin.jsp"></jsp:include>

<div class="container">
<h1>倉庫詳情</h1>
<div class="row">
	<div class="col-2">倉庫名稱:</div>
	<div class="col-2">${warehouse.warehouseName}</div>
</div>
<div class="row">
	<table class="table table-hover table-bordered">
	 <tr>
	  <th>商品</th>
	  <th>販賣數量</th>
	  <th>租借數量</th>
	 </tr>
	  <jstl:forEach items="${inventory}" var="inventory">
				<tr>
					<td>${inventory.product.name}</td>
					<td>${inventory.inventorySellamount}</td>
					<td>${inventory.inventoryRentamount}</td>
				</tr>
	  </jstl:forEach>	
	</table>			
</div>




</div>

</body>
</html>