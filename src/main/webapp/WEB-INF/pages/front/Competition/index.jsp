<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>活動</title>
<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
<style>
ul#comp-link>li {
	list-style-type: none;
}

i {
	font-size: 2rem;
	color: red;
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
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">活動</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}">首頁</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">活動</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->
	<!-- Service Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center mx-auto mb-5 wow fadeInUp"
				data-wow-delay="0.1s" style="max-width: 600px;">
				<p class="d-inline-block bg-secondary text-primary py-1 px-4">活動</p>
				<h1 class="text-uppercase">各項內容</h1>
			</div>
			<div class="row g-4">
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<i class="fa-solid fa-people-group"></i>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">所有活動</h3>
							<p>來，讓我們探究一下所有活動的奧義！</p>
							<span class="text-uppercase text-primary">報名費 0 元起</span>
						</div>
						<a class="btn btn-square"
							href="${contextRoot}/front/competition/show"><i class="bi bi-eye"></i></a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<i class="bi bi-camera2"></i>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">活動相簿</h3>
							<p>重溫那場驚心動魄的活動，點開屬於我們的記憶之書！</p>
							<span class="text-uppercase text-primary">影音回憶錄</span>
						</div>
						<a class="btn btn-square"
							href="${contextRoot}/front/competition/photo"><i class="bi bi-eye"></i></a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<i class="fa-sharp fa-solid fa-location-dot"></i>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">活動場地</h3>
							<p>凝視著眼前眾多場地，選擇欲探索的地方！</p>
							<span class="text-uppercase text-primary">選好地圖，等你來征服！</span>
						</div>
						<a class="btn btn-square" href="${contextRoot}/front/place/all"><i class="bi bi-eye"></i></a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<i class="fa-sharp fa-solid fa-right-to-bracket"></i>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">報名資訊</h3>
							<p>眾所矚目的賽事報名已然展開，趕緊來確認活動報名資訊吧！</p>
							<span class="text-uppercase text-primary">手刀報名不遲疑</span>
						</div>
						<a class="btn btn-square" href="${contextRoot}/front/signup"><i class="bi bi-eye"></i></a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<i class="fa-solid fa-ranking-star"></i>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">競賽紀錄</h3>
							<p>重溫我們征戰的榮耀，回味曾經的奮鬥與血淚</p>
							<span class="text-uppercase text-primary">將歷史重現眼前</span>
						</div>
						<a class="btn btn-square"
							href="${contextRoot}/front/competition/history"><i class="bi bi-eye"></i></a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<i class="fa-solid fa-handshake"></i>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">場地租借</h3>
							<p>觀瞻諸君！來檢視租借領域的契約條款與租金報價吧！</p>
							<span class="text-uppercase text-primary">打造屬於自己的戰場</span>
						</div>
						<a class="btn btn-square" href=""><i class="bi bi-eye"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Service End -->
	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
	<script src="${contextRoot}/js/Competition/front/index.js"></script>
</body>
</html>