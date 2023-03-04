<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="utf-8">
<title>顧客評價</title>
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
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">顧客評價</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white" href="#">首頁</a></li>
					<li class="breadcrumb-item"><a class="text-white" href="#">頁面</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">顧客評價</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->


	<!-- Testimonial Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center mx-auto mb-5 wow fadeInUp"
				data-wow-delay="0.1s" style="max-width: 600px;">
				<p class="d-inline-block bg-secondary text-primary py-1 px-4">顧客評價</p>
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
	<jsp:include page="../Template/front/includeinbody.jsp"></jsp:include>
</body>
</html>