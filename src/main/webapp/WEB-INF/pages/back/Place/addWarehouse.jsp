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
<title>倉庫表</title>
</head>
<body>
	<jsp:include page="../../Template/admin.jsp"></jsp:include>

	<div class="container">
		<c:choose>
			<c:when test="${player == null && employee == null}">
				<h1>請先登入再新增活動呦😊～</h1>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		<form:form action="${contextRoot}/warehouse/create"
			modelAttribute="warehouse">
			<div class="col-3">
				<form:label path="place" class="form-label">倉庫場地</form:label>
				<form:select title="選擇一個場地" class="form-select" path="placeId"
					id="placeId">
					<c:forEach items="${placeList}" var="place">
						<c:choose>
							<c:when test="${player != null && employee == null}">
								<h1>請先登入再新增活動呦😊～</h1>
							</c:when>
							<c:when test="${player == null && employee != null}">
								<form:option value="${place.id}">${place.place_name}</form:option>
							</c:when>
							<c:otherwise>
								<form:option value="${place.id}">${place.place_name}</form:option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select>
			</div>
			<div class="col-6">
				<form:label class="form-label" path="warehouseName">倉庫名稱</form:label>
				<form:input class="form-control" type="text" path="warehouseName"
					required="true" />
			</div>
			<fieldset class="row mt-3 mb-3 p-3">
				<input class="col-1 m-3 btn btn-primary" type="submit" value="送出" />
			</fieldset>
		</form:form>
	</div>

</body>
</html>