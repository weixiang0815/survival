<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>新增活動獎品</title>
</head>
<body>
	<jsp:include page="../Template/admin.jsp" />
	<div class="container pt-3 pb-3">
		<h1>活動獎品新增表單</h1>
		<h2>活動基本資訊</h2>
		<div class="row mt-3 mb-3">
			<div class="col-2 text-end">活動名稱</div>
			<div class="col-3">${comp.mandarinName}</div>
		</div>
		<div class="row mt-3 mb-3">
			<div class="col-2 text-end">活動場地</div>
			<div class="col-3">${place.place_name}</div>
		</div>
		<div class="row mt-3 mb-3">
			<div class="col-2 text-end">活動日期</div>
			<div class="col-3">${comp.startDate}～${comp.endDate}</div>
		</div>
		<div class="row mt-3 mb-3">
			<div class="col-2 text-end">競賽類型</div>
			<div class="col-3">
				<c:choose>
					<c:when test="${comp.singleOrCrew.equals(\"S\")}">個人戰</c:when>
					<c:when test="${comp.singleOrCrew.equals(\"C\")}">團體戰</c:when>
					<c:otherwise>未定</c:otherwise>
				</c:choose>
			</div>
		</div>
		<form:form action="${contextRoot}/competition/prize/add" method="post"
			modelAttribute="prizes">
			<div class="row mt-3 mb-3">
				<div class="col-2 text-end">
					<form:label class="form-label" path="firstPrize">冠軍獎品</form:label>
				</div>
				<div class="col-3">
					<form:select class="form-select form-select-sm" path="firstPrize">
						<c:forEach items="${products}" var="product">
							<form:option value="${product.id}">${product.name}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="row mt-3 mb-3">
				<div class="col-2 text-end">
					<form:label class="form-label" path="secondPrize">亞軍獎品</form:label>
				</div>
				<div class="col-3">
					<form:select class="form-select form-select-sm" path="secondPrize">
						<c:forEach items="${products}" var="product">
							<form:option value="${product.id}">${product.name}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="row mt-3 mb-3">
				<div class="col-2 text-end">
					<form:label class="form-label" path="thirdPrize">季軍獎品</form:label>
				</div>
				<div class="col-3">
					<form:select class="form-select form-select-sm" path="thirdPrize">
						<c:forEach items="${products}" var="product">
							<form:option value="${product.id}">${product.name}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="row mt-3 mb-3">
				<c:choose>
					<c:when test="${comp.singleOrCrew.equals(\"S\")}">
						<div class="col-2 text-end"><form:label class="form-label" path="singlePrize">個人獎品</form:label></div>
						<div class="col-3"><form:select class="form-select form-select-sm" path="singlePrize">
							<c:forEach items="${products}" var="product">
								<form:option value="${product.id}">${product.name}</form:option>
							</c:forEach>
							</form:select>
						</div>
					</c:when>
					<c:when test="${comp.singleOrCrew.equals(\"C\")}">
						<div class="col-2 text-end"><form:label class="form-label" path="crewPrize">團隊獎品</form:label></div>
						<div class="col-3"><form:select class="form-select form-select-sm" path="crewPrize">
							<c:forEach items="${products}" var="product">
								<form:option value="${product.id}">${product.name}</form:option>
							</c:forEach>
							</form:select>
						</div>
					</c:when>
				</c:choose>
			</div>
			<div class="row mt-3 mb-3">
				<div class="col-2 text-end">
					<form:label class="form-label" path="comfortPrize">安慰獎品</form:label>
				</div>
				<div class="col-3">
					<form:select class="form-select form-select-sm" path="comfortPrize">
						<c:forEach items="${products}" var="product">
							<form:option value="${product.id}">${product.name}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="row mt-3 mb-3">
				<div class="col-1">
					<input class="btn btn-primary btn-sm" type="submit" value="送出">
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>