<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>活動相簿</title>
<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
<style>
.collection {
	cursor: pointer;
}

.collection:hover {
	background-color: red;
	transition: .2s ease-in-out;
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
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">活動相簿</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}">首頁</a></li>
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}/front/competition">活動</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">活動相簿</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->
	<div class="container text-center">
		<div class="row">
			<div class="col-2 d-flex flex-column text-white text-start">
				<div class="mt-3 mb-3">
					<label class="form-label" for="name">活動名稱</label> <input id="name"
						class="form-control" type="text"
						pattern="/^[\u4e00-\u9ffff-zA-Z0-9]+$/" placeholder="請輸入關鍵字" />
				</div>
				<div class="mt-3 mb-3">
					<label class="form-label">活動場地</label>
					<c:forEach items="${places}" var="place">
						<div class="form-check">
							<input checked class="form-check-input" type="checkbox"
								name="place" id="place_${place.id}" value="${place.id}">
							<lable for="notyet" class="form-check-label">${place.place_name}</lable>
						</div>
					</c:forEach>
				</div>
				<div class="mt-3 mb-3">
					<lable class="form-label">活動時間</lable>
					<div class="form-check">
						<input checked class="form-check-input" type="checkbox"
							value="notyet" name="date" id="notyet">
						<lable for="notyet" class="form-check-label">尚未開始</lable>
					</div>
					<div class="form-check">
						<input checked class="form-check-input" type="checkbox"
							value="ing" name="date" id="ing">
						<lable for="ing" class="form-check-label">進行中</lable>
					</div>
					<div class="form-check">
						<input checked class="form-check-input" type="checkbox"
							value="ended" name="date" id="ended">
						<lable for="ended" class="form-check-label">已結束</lable>
					</div>
				</div>
				<div class="mt-3 mb-3">
					<label for="" class="form-label">競賽模式</label>
					<div class="form-check">
						<input checked type="checkbox" name="singleOrCrew" value="S"
							id="S" class="form-check-input"> <label for="S"
							class="form-check-label">單人戰</label>
					</div>
					<div class="form-check">
						<input checked type="checkbox" name="singleOrCrew" value="C"
							id="C" class="form-check-input"> <label for="C"
							class="form-check-label">團體戰</label>
					</div>
				</div>
				<div class="mt-3 mb-3">
					<lable class="form-label">報名費用</lable>
					<div class="form-check">
						<input checked class="form-check-input" type="checkbox" value="0"
							name="fee" id="free">
						<lable for="free" class="form-check-label">0 元</lable>
					</div>
					<div class="form-check">
						<input checked class="form-check-input" type="checkbox" value="1"
							name="fee" id="cheap">
						<lable for="cheap" class="form-check-label">0 到 1000 元</lable>
					</div>
					<div class="form-check">
						<input checked class="form-check-input" type="checkbox" value="2"
							name="fee" id="expensive">
						<lable for="expensive" class="form-check-label">1000 元以上</lable>
					</div>
				</div>
				<div class="mt-3 mb-3">
					<lable class="form-label">活動規模</lable>
					<div class="form-check">
						<input checked class="form-check-input" type="checkbox" value="0"
							name="capacity" id="small">
						<lable for="free" class="form-check-label">30 人以下</lable>
					</div>
					<div class="form-check">
						<input checked class="form-check-input" type="checkbox" value="1"
							name="capacity" id="medium">
						<lable for="cheap" class="form-check-label">30 到 100 人</lable>
					</div>
					<div class="form-check">
						<input checked class="form-check-input" type="checkbox" value="2"
							name="capacity" id="large">
						<lable for="expensive" class="form-check-label">100 人以上</lable>
					</div>
				</div>
			</div>
			<div class="col-10 mt-3 mb-3">
				<div id="collections" class="row d-flex align-items-stretch">
					<c:forEach items="${pictures}" var="dto">
						<div class="col-3">
							<div class="row text-center">
								<a title="點擊查看活動詳情" href="${contextRoot}/front/competition/detail/${dto.compId}"><h4>${dto.compName}</h4></a>
							</div>
							<div class="row pt-3 pb-3 collection d-flex align-items-stretch">
								<c:forEach items="${dto.picSet}" var="pic">
									<div class="col-4">
										<a href="${contextRoot}/front/api/competition/photo/${pic.id}">
											<img class="img-fluid" alt="Image ${pic.id}"
											src="${contextRoot}/front/api/competition/photo/${pic.id}">
										</a>
									</div>
								</c:forEach>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
		<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
		<script src="${contextRoot}/js/Competition/front/photo.js"></script>
</body>
</html>