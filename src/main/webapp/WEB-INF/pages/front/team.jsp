<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="utf-8">
<title>設計師</title>
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
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">設計師</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white" href="#">首頁</a></li>
					<li class="breadcrumb-item"><a class="text-white" href="#">頁面</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">設計師</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->


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
				<div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
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
				<div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
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
				<div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
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
				<div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.7s">
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
			</div>
		</div>
	</div>
	<!-- Team End -->
	<jsp:include page="../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>