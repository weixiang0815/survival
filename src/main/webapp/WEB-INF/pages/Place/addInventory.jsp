<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>庫存表</title>
</head>
<body>
<jsp:include page="../Template/admin.jsp"></jsp:include>
<div class="container">
		<c:choose>
			<c:when test="${player == null && employee == null}">
				<h1>請先登入再新增活動呦😊～</h1>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		<form:form action="${contextRoot}/inventory/create"
			modelAttribute="inventory">
			<div class="col-3">
				<form:label path="warehouse" class="form-label">倉庫</form:label>
				<form:select title="選擇一個倉庫" class="form-select" path="warehouseId"
					id="warehouseId">
					<c:forEach items="${warehouseList}" var="warehouse">
						<c:choose>
							<c:when test="${player != null && employee == null}">
								<h1>請先登入再新增活動呦😊～</h1>
							</c:when>
							<c:when test="${player == null && employee != null}">
								<form:option value="${warehouse.id}">${warehouse.warehouseName}</form:option>
							</c:when>
							<c:otherwise>
								<form:option value="${warehouse.id}">${warehouse.warehouseName}</form:option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select>
			</div>
			<div class="col-3">
				<form:label path="product" class="form-label">商品</form:label>
				<form:select title="選擇一個商品" class="form-select" path="productId"
					id="productId">
					<c:forEach items="${productList}" var="product">
						<c:choose>
							<c:when test="${player != null && employee == null}">
								<h1>請先登入再新增活動呦😊～</h1>
							</c:when>
							<c:when test="${player == null && employee != null}">
								<form:option value="${product.id}">${product.name}</form:option>
							</c:when>
							<c:otherwise>
								<form:option value="${product.id}">${product.name}</form:option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select>
			</div>
			<div class="col-6">
				<form:label class="form-label" path="inventorySellamount">販賣數量</form:label>
				<form:input class="form-control" type="text" path="inventorySellamount"
					required="true" />
			</div>
			<div class="col-6">
				<form:label class="form-label" path="inventoryRentamount">租借數量</form:label>
				<form:input class="form-control" type="text" path="inventoryRentamount"
					required="true" />
			</div>
			<fieldset class="row mt-3 mb-3 p-3">
				<input class="col-1 m-3 btn btn-primary" type="submit" value="送出" />
			</fieldset>
		</form:form>
	</div>
</body>
</html>