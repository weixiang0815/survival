<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="utf-8">
<title>價位</title>
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
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">價位</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white" href="#">首頁</a></li>
					<li class="breadcrumb-item"><a class="text-white" href="#">頁面</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">價位</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->


	<!-- Price Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="row g-0">
				<div class="col-lg-6 wow fadeIn" data-wow-delay="0.1s">
					<div
						class="bg-secondary h-100 d-flex flex-column justify-content-center p-5">
						<p class="d-inline-flex bg-dark text-primary py-1 px-4 me-auto">Price
							& Plan</p>
						<h1 class="text-uppercase mb-4">Check Out Our Barber Services
							And Prices</h1>
						<div>
							<div class="d-flex justify-content-between border-bottom py-2">
								<h6 class="text-uppercase mb-0">Haircut</h6>
								<span class="text-uppercase text-primary">$29.00</span>
							</div>
							<div class="d-flex justify-content-between border-bottom py-2">
								<h6 class="text-uppercase mb-0">Beard Trim</h6>
								<span class="text-uppercase text-primary">$35.00</span>
							</div>
							<div class="d-flex justify-content-between border-bottom py-2">
								<h6 class="text-uppercase mb-0">Mans Shave</h6>
								<span class="text-uppercase text-primary">$23.00</span>
							</div>
							<div class="d-flex justify-content-between border-bottom py-2">
								<h6 class="text-uppercase mb-0">Hair Dyeing</h6>
								<span class="text-uppercase text-primary">$19.00</span>
							</div>
							<div class="d-flex justify-content-between border-bottom py-2">
								<h6 class="text-uppercase mb-0">Mustache</h6>
								<span class="text-uppercase text-primary">$15.00</span>
							</div>
							<div class="d-flex justify-content-between py-2">
								<h6 class="text-uppercase mb-0">Stacking</h6>
								<span class="text-uppercase text-primary">$39.00</span>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6 wow fadeIn" data-wow-delay="0.5s">
					<div class="h-100">
						<img class="img-fluid h-100" src="${contextRoot}/img/price.jpg" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Price End -->
	<jsp:include page="../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../Template/front/includeinbody.jsp"></jsp:include>
</body>
</html>