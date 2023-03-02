<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="utf-8">
<title>關於</title>
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
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">關於</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white" href="#">首頁</a></li>
					<li class="breadcrumb-item"><a class="text-white" href="#">頁面</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">關於</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->


	<!-- About Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="row g-5">
				<div class="col-lg-6 wow fadeIn" data-wow-delay="0.1s">
					<div class="d-flex flex-column">
						<img class="img-fluid w-75 align-self-end" src="${contextRoot}/img/about.jpg"
							alt="">
						<div class="w-50 bg-secondary p-5" style="margin-top: -25%;">
							<h1 class="text-uppercase text-primary mb-3">25 Years</h1>
							<h2 class="text-uppercase mb-0">Experience</h2>
						</div>
					</div>
				</div>
				<div class="col-lg-6 wow fadeIn" data-wow-delay="0.5s">
					<p class="d-inline-block bg-secondary text-primary py-1 px-4">About
						Us</p>
					<h1 class="text-uppercase mb-4">More Than Just A Haircut.
						Learn More About Us!</h1>
					<p>Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit.
						Aliqu diam amet diam et eos. Clita erat ipsum et lorem et sit, sed
						stet lorem sit clita duo justo magna dolore erat amet</p>
					<p class="mb-4">Stet no et lorem dolor et diam, amet duo ut
						dolore vero eos. No stet est diam rebum amet diam ipsum. Clita
						clita labore, dolor duo nonumy clita sit at, sed sit sanctus dolor
						eos.</p>
					<div class="row g-4">
						<div class="col-md-6">
							<h3 class="text-uppercase mb-3">Since 1990</h3>
							<p class="mb-0">Tempor erat elitr rebum at clita. Diam dolor
								diam ipsum sit. Aliqu diam amet diam et eos.</p>
						</div>
						<div class="col-md-6">
							<h3 class="text-uppercase mb-3">1000+ clients</h3>
							<p class="mb-0">Tempor erat elitr rebum at clita. Diam dolor
								diam ipsum sit. Aliqu diam amet diam et eos.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- About End -->


	<!-- Team Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center mx-auto mb-5 wow fadeInUp"
				data-wow-delay="0.1s" style="max-width: 600px;">
				<p class="d-inline-block bg-secondary text-primary py-1 px-4">Our
					Barber</p>
				<h1 class="text-uppercase">Meet Our Barber</h1>
			</div>
			<div class="row g-4">
				<div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
					<div class="team-item">
						<div class="team-img position-relative overflow-hidden">
							<img class="img-fluid" src="${contextRoot}/img/team-1.jpg" alt="">
							<div class="team-social">
								<a class="btn btn-square" href=""><i
									class="fab fa-facebook-f"></i></a> <a class="btn btn-square"
									href=""><i class="fab fa-twitter"></i></a> <a
									class="btn btn-square" href=""><i class="fab fa-instagram"></i></a>
							</div>
						</div>
						<div class="bg-secondary text-center p-4">
							<h5 class="text-uppercase">Barber Name</h5>
							<span class="text-primary">Designation</span>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
					<div class="team-item">
						<div class="team-img position-relative overflow-hidden">
							<img class="img-fluid" src="${contextRoot}/img/team-2.jpg" alt="">
							<div class="team-social">
								<a class="btn btn-square" href=""><i
									class="fab fa-facebook-f"></i></a> <a class="btn btn-square"
									href=""><i class="fab fa-twitter"></i></a> <a
									class="btn btn-square" href=""><i class="fab fa-instagram"></i></a>
							</div>
						</div>
						<div class="bg-secondary text-center p-4">
							<h5 class="text-uppercase">Barber Name</h5>
							<span class="text-primary">Designation</span>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
					<div class="team-item">
						<div class="team-img position-relative overflow-hidden">
							<img class="img-fluid" src="${contextRoot}/img/team-3.jpg" alt="">
							<div class="team-social">
								<a class="btn btn-square" href=""><i
									class="fab fa-facebook-f"></i></a> <a class="btn btn-square"
									href=""><i class="fab fa-twitter"></i></a> <a
									class="btn btn-square" href=""><i class="fab fa-instagram"></i></a>
							</div>
						</div>
						<div class="bg-secondary text-center p-4">
							<h5 class="text-uppercase">Barber Name</h5>
							<span class="text-primary">Designation</span>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.7s">
					<div class="team-item">
						<div class="team-img position-relative overflow-hidden">
							<img class="img-fluid" src="${contextRoot}/img/team-4.jpg" alt="">
							<div class="team-social">
								<a class="btn btn-square" href=""><i
									class="fab fa-facebook-f"></i></a> <a class="btn btn-square"
									href=""><i class="fab fa-twitter"></i></a> <a
									class="btn btn-square" href=""><i class="fab fa-instagram"></i></a>
							</div>
						</div>
						<div class="bg-secondary text-center p-4">
							<h5 class="text-uppercase">Barber Name</h5>
							<span class="text-primary">Designation</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Team End -->
	<jsp:include page="../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../Template/front/includeinbody.jsp"></jsp:include>
</body>
</html>