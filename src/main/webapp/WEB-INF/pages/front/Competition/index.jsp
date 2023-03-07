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
					<li class="breadcrumb-item"><a class="text-white" href="${contextRoot}">首頁</a></li>
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
<%-- 							<img class="img-fluid" src="${contextRoot}/img/haircut.png" alt=""> --%>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">所有活動</h3>
							<p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum
								sit. Aliqu diam amet diam.</p>
							<span class="text-uppercase text-primary">From $15</span>
						</div>
						<a class="btn btn-square" href=""><i
							class="fa fa-plus text-primary"></i></a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<i class="bi bi-camera2"></i>
<%-- 							<img class="img-fluid" src="${contextRoot}/img/beard-trim.png" alt=""> --%>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">活動相簿</h3>
							<p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum
								sit. Aliqu diam amet diam.</p>
							<span class="text-uppercase text-primary">From $15</span>
						</div>
						<a class="btn btn-square" href="${contextRoot}/front/competition/photo"><i
							class="fa fa-plus text-primary"></i></a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<i class="fa-sharp fa-solid fa-location-dot"></i>
<%-- 							<img class="img-fluid" src="${contextRoot}/img/mans-shave.png" alt=""> --%>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">活動場地</h3>
							<p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum
								sit. Aliqu diam amet diam.</p>
							<span class="text-uppercase text-primary">From $15</span>
						</div>
						<a class="btn btn-square" href=""><i
							class="fa fa-plus text-primary"></i></a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<i class="fa-sharp fa-solid fa-right-to-bracket"></i>
<%-- 							<img class="img-fluid" src="${contextRoot}/img/hair-dyeing.png" alt=""> --%>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">報名資訊</h3>
							<p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum
								sit. Aliqu diam amet diam.</p>
							<span class="text-uppercase text-primary">From $15</span>
						</div>
						<a class="btn btn-square" href="${contextRoot}/front/signup"><i
							class="fa fa-plus text-primary"></i></a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<i class="fa-solid fa-ranking-star"></i>
<%-- 							<img class="img-fluid" src="${contextRoot}/img/mustache.png" alt=""> --%>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">競賽紀錄</h3>
							<p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum
								sit. Aliqu diam amet diam.</p>
							<span class="text-uppercase text-primary">From $15</span>
						</div>
						<a class="btn btn-square" href="${contextRoot}/front/competition/history"><i
							class="fa fa-plus text-primary"></i></a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<i class="fa-solid fa-handshake"></i>
<%-- 							<img class="img-fluid" src="${contextRoot}/img/stacking.png" alt=""> --%>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">場地租借</h3>
							<p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum
								sit. Aliqu diam amet diam.</p>
							<span class="text-uppercase text-primary">From $15</span>
						</div>
						<a class="btn btn-square" href=""><i
							class="fa fa-plus text-primary"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Service End -->
	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>