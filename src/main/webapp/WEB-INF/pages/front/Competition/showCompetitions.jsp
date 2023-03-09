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
td>a {
	font-weight: bolder;
}

td>a:hover {
	color: white;
	background-color: red;
	transition: .2s ease-in-out;
}

.form-label {
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
			<div class="col-2 d-flex flex-column text-white text-start">
				<div class="mt-3 mb-3">
					<label class="form-label" for="name">活動名稱</label>
					<input id="name" class="form-control" type="text" pattern="/^[\u4e00-\u9ffff-zA-Z0-9]+$/" placeholder="請輸入關鍵字" />
				</div>
				<div class="mt-3 mb-3">
					<label for="place" class="form-label">活動場地</label>
					<select class="form-select" id="place">
						<option selected>- 請選一個場地 -</option>
						<c:forEach items="${places}" var="place">
							<option value="${place.id}">${place.place_name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="mt-3 mb-3">
					<lable class="form-label">活動時間</lable>
					<div class="form-check">
						<input checked class="form-check-input" type="checkbox" name="date" id="notyet">
						<lable for="notyet" class="form-check-label">尚未開始</lable>
					</div>
					<div class="form-check">
						<input checked class="form-check-input" type="checkbox" name="date" id="ing">
						<lable for="ing" class="form-check-label">進行中</lable>
					</div>
					<div class="form-check">
						<input checked class="form-check-input" type="checkbox" name="date" id="ended">
						<lable for="ended" class="form-check-label">已結束</lable>
					</div>
				</div>
				<div class="mt-3 mb-3">
					<label for="" class="form-label">競賽模式</label>
					<div class="form-check">
						<input checked type="checkbox" name="singleOrCrew" value="S" id="S" class="form-check-input">
						<label for="S" class="form-check-label">單人戰</label>
					</div>
					<div class="form-check">
						<input checked type="checkbox" name="singleOrCrew" value="C" id="C" class="form-check-input">
						<label for="C" class="form-check-label">團體戰</label>
					</div>
				</div>
				<div class="mt-3 mb-3">
					<lable class="form-label">報名費用</lable>
					<div class="form-check">
						<input checked class="form-check-input" type="checkbox" value="0" name="fee" id="free">
						<lable for="free" class="form-check-label">0 元</lable>
					</div>
					<div class="form-check">
						<input checked class="form-check-input" type="checkbox" value="1" name="fee" id="cheap">
						<lable for="cheap" class="form-check-label">0 到 1000 元</lable>
					</div>
					<div class="form-check">
						<input checked class="form-check-input" type="checkbox" value="2" name="fee" id="expensive">
						<lable for="expensive" class="form-check-label">1000 元以上</lable>
					</div>
				</div>
				<div class="mt-3 mb-3">
					<lable class="form-label">活動規模</lable>
					<div class="form-check">
						<input checked class="form-check-input" type="checkbox" value="0" name="fee" id="free">
						<lable for="free" class="form-check-label">30 人以下</lable>
					</div>
					<div class="form-check">
						<input checked class="form-check-input" type="checkbox" value="1" name="fee" id="cheap">
						<lable for="cheap" class="form-check-label">30 到 100 人</lable>
					</div>
					<div class="form-check">
						<input checked class="form-check-input" type="checkbox" value="2" name="fee" id="expensive">
						<lable for="expensive" class="form-check-label">100 人以上</lable>
					</div>
				</div>
			</div>
			<div class="col-10 mt-3 mb-3">
				<table class="table table-hover table-dark table-bordered table-striped">
					<thead>
						<tr>
							<th>中文名稱</th>
							<th>英文名稱</th>
							<th>活動地點</th>
							<th>開始時間</th>
							<th>結束時間</th>
							<th>競賽模式</th>
							<th>報名費用</th>
							<th>活動規模</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${comps}" var="comp">
							<tr>
								<td><a
									href="${contextRoot}/front/competition/detail/${comp.id}">${comp.mandarinName}</a></td>
								<td><a
									href="${contextRoot}/front/competition/detail/${comp.id}">${comp.englishName}</a></td>
								<td>${comp.place.place_name}</td>
								<td class="compDate">${comp.startDate}</td>
								<td class="compDate">${comp.endDate}</td>
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
								<td>$&nbsp;${comp.fee}</td>
								<td>${comp.capacity} 人</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
	<script src="${contextRoot}/js/Competition/front/showCompetitions.js"></script>
</body>
</html>