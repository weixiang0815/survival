<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>論壇</title>
<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>
	<!-- Page Header Start -->
	<div class="container-fluid page-header py-5 mb-5 wow fadeIn"
		data-wow-delay="0.1s">
		<div class="container text-center py-5">
			<h1
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">論壇</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white" href="${contextRoot}/">首頁</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">論壇</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->
<div class="container text-center">
<h1>論壇</h1>
<!-- Service Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center mx-auto mb-5 wow fadeInUp"
				data-wow-delay="0.1s" style="max-width: 600px;">
				<p class="d-inline-block bg-secondary text-primary py-1 px-4">服務</p>
				<h1 class="text-uppercase">我們能提供什麼</h1>
			</div>
			<div class="row g-4">
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<img class="img-fluid" src="${contextRoot}/img/haircut.png"
								alt="">
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">精選好評</h3>
							<p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum
								sit. Aliqu diam amet diam.</p>
							<span class="text-uppercase text-primary">From $15</span>
						</div>
						<a class="btn btn-square" href="">
							<i class="fa fa-plus text-primary"></i>
						</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<img class="img-fluid" src="${contextRoot}/img/beard-trim.png"
								alt="">
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">貼文發布</h3>
							<p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum
								sit. Aliqu diam amet diam.</p>
							<span class="text-uppercase text-primary">From $15</span>
						</div>
						<a class="btn btn-square" href=""><i
							class="fa fa-plus text-primary"></i></a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<img class="img-fluid" src="${contextRoot}/img/mans-shave.png"
								alt="">
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">貼文查詢</h3>
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
							<img class="img-fluid" src="${contextRoot}/img/hair-dyeing.png"
								alt="">
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">我的貼文</h3>
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
							<img class="img-fluid" src="${contextRoot}/img/mustache.png"
								alt="">
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">我的關注</h3>
							<p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum
								sit. Aliqu diam amet diam.</p>
							<span class="text-uppercase text-primary">From $15</span>
						</div>
						<a class="btn btn-square" href=""><i
							class="fa fa-plus text-primary"></i></a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<img class="img-fluid" src="${contextRoot}/img/stacking.png"
								alt="">
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">評價紀錄</h3>
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
</div>
<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>