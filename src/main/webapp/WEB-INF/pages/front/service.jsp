<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="utf-8">
<title>服務</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<jsp:include page="../Template/front/includedinhead.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../Template/front/navbar.jsp"></jsp:include>
	<!-- Page Header Start -->
	<div class="container-fluid page-header py-5 mb-5 wow fadeIn"
		data-wow-delay="0.1s">
		<div class="container text-center py-5">
			<h1
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">服務</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white" href="#">首頁</a></li>
					<li class="breadcrumb-item"><a class="text-white" href="#">頁面</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">服務</li>
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
				<p class="d-inline-block bg-secondary text-primary py-1 px-4">Services</p>
				<h1 class="text-uppercase">What We Provide</h1>
			</div>
			<div class="row g-4">
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<img class="img-fluid" src="${contextRoot}/img/haircut.png" alt="">
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">Haircut</h3>
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
							<img class="img-fluid" src="${contextRoot}/img/beard-trim.png" alt="">
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">Beard Trim</h3>
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
							<img class="img-fluid" src="${contextRoot}/img/mans-shave.png" alt="">
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">Mans Shave</h3>
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
							<img class="img-fluid" src="${contextRoot}/img/hair-dyeing.png" alt="">
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">Hair Dyeing</h3>
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
							<img class="img-fluid" src="${contextRoot}/img/mustache.png" alt="">
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">Mustache</h3>
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
							<img class="img-fluid" src="${contextRoot}/img/stacking.png" alt="">
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">Stacking</h3>
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


	<!-- Testimonial Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center mx-auto mb-5 wow fadeInUp"
				data-wow-delay="0.1s" style="max-width: 600px;">
				<p class="d-inline-block bg-secondary text-primary py-1 px-4">Testimonial</p>
				<h1 class="text-uppercase">What Our Clients Say!</h1>
			</div>
			<div class="owl-carousel testimonial-carousel wow fadeInUp"
				data-wow-delay="0.1s">
				<div class="testimonial-item text-center"
					data-dot="<img class='img-fluid' src='${contextRoot}/img/testimonial-1.jpg' alt=''>">
					<h4 class="text-uppercase">Client Name</h4>
					<p class="text-primary">Profession</p>
					<span class="fs-5">Clita clita tempor justo dolor ipsum amet
						kasd amet duo justo duo duo labore sed sed. Magna ut diam sit et
						amet stet eos sed clita erat magna elitr erat sit sit erat at
						rebum justo sea clita.</span>
				</div>
				<div class="testimonial-item text-center"
					data-dot="<img class='img-fluid' src='${contextRoot}/img/testimonial-2.jpg' alt=''>">
					<h4 class="text-uppercase">Client Name</h4>
					<p class="text-primary">Profession</p>
					<span class="fs-5">Clita clita tempor justo dolor ipsum amet
						kasd amet duo justo duo duo labore sed sed. Magna ut diam sit et
						amet stet eos sed clita erat magna elitr erat sit sit erat at
						rebum justo sea clita.</span>
				</div>
				<div class="testimonial-item text-center"
					data-dot="<img class='img-fluid' src='${contextRoot}/img/testimonial-3.jpg' alt=''>">
					<h4 class="text-uppercase">Client Name</h4>
					<p class="text-primary">Profession</p>
					<span class="fs-5">Clita clita tempor justo dolor ipsum amet
						kasd amet duo justo duo duo labore sed sed. Magna ut diam sit et
						amet stet eos sed clita erat magna elitr erat sit sit erat at
						rebum justo sea clita.</span>
				</div>
			</div>
		</div>
	</div>
	<!-- Testimonial End -->
	<jsp:include page="../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>