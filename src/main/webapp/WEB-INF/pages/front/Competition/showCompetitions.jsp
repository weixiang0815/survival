<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有活動</title>
<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
<style>
a {
	font-weight: bolder;
}
</style>
</head>
<body>
	<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>
	<!-- Page Header Start -->
	<div class="container-fluid page-header py-5 mb-5 wow fadeIn"
		data-wow-delay="0.1s">
		<div class="container text-center py-5">
			<h1
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">所有活動</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}">首頁</a></li>
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}/front/competition">活動</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">所有活動</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->
	<div class="container text-center">
		<div class="row">
			<div class="col-12 text-white">
				搜尋：<input type="text" placeholder="你想查詢的關鍵字" />
			</div>
			<div class="col-12 mt-5 mb-5">
				<table class="table table-hover table-dark table-bordered">
					<thead>
						<tr>
							<th>活動名稱</th>
							<th>活動地點</th>
							<th>開始時間</th>
							<th>結束時間</th>
							<th>競賽模式</th>
							<th>參加費用</th>
							<th>活動集錦</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${comps}" var="comp">
							<tr>
								<td><a
									href="${contextRoot}/front/competition/detail/${comp.id}">${comp.mandarinName}</a></td>
								<td>${comp.place.place_name}</td>
								<td>${comp.startDate}</td>
								<td>${comp.endDate}</td>
								<c:choose>
									<c:when test="${comp.singleOrCrew.equals(\"S\")}">
										<td>個人戰</td>
									</c:when>
									<c:when test="${comp.singleOrCrew.equals(\"C\")}">
										<td>團體戰</td>
									</c:when>
									<c:otherwise>
										<td>未定</td>
									</c:otherwise>
								</c:choose>
								<td>${comp.fee}</td>
								<td><a
									href="${contextRoot}/front/competition/photo/${comp.id}">相簿</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>