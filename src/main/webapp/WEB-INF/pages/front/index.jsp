<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="utf-8">
<title>Survival - 生存遊戲俱樂部</title>
<style>
.i_item{
	color: red;
	font-size: 2em;
}
</style>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<jsp:include page="../Template/front/includedinhead.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../Template/front/navbar.jsp"></jsp:include>
	<!-- Carousel Start -->
	<div class="container-fluid p-0 mb-5 wow fadeIn" data-wow-delay="0.1s">
		<div id="header-carousel" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<video class="w-100" preload="auto" autoplay loop="loop" muted="muted">
						<source src="${contextRoot}/videos/kalashnikov-99910.mp4" type="video/mp4">
						Your browser does not support the video tag.
					</video>
					<div
						class="carousel-caption d-flex align-items-center justify-content-center text-start">
						<div class="mx-sm-5 px-5" style="max-width: 900px;">
							<h1
								class="display-2 text-white text-uppercase mb-4 animated slideInDown">biu biu biu</h1>
							<h4 class="text-white text-uppercase mb-4 animated slideInDown">
								<i class="fa fa-map-marker-alt text-primary me-3"></i>台北市復興南路一段390號2樓
							</h4>
							<h4 class="text-white text-uppercase mb-4 animated slideInDown">
								<i class="fa fa-phone-alt text-primary me-3"></i>（02）6631-6588
							</h4>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<video class="w-100" preload="auto" autoplay loop="loop" muted="muted">
						<source src="${contextRoot}/videos/war-16391.mp4" type="video/mp4">
					</video>
					<div
						class="carousel-caption d-flex align-items-center justify-content-center text-start">
						<div class="mx-sm-5 px-5" style="max-width: 900px;">
							<h1
								class="display-2 text-white text-uppercase mb-4 animated slideInDown">小心手榴彈</h1>
							<h4 class="text-white text-uppercase mb-4 animated slideInDown">
								<i class="fa fa-map-marker-alt text-primary me-3"></i>台北市復興南路一段390號2樓
							</h4>
							<h4 class="text-white text-uppercase mb-4 animated slideInDown">
								<i class="fa fa-phone-alt text-primary me-3"></i>（02）6631-6588
							</h4>
						</div>
					</div>
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#header-carousel" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">上一頁</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#header-carousel" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">下一頁</span>
			</button>
		</div>
	</div>
	<!-- Carousel End -->


	<!-- About Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="row g-5">
				<div class="col-lg-6 wow fadeIn" data-wow-delay="0.1s">
					<div class="d-flex flex-column">
						<img class="img-fluid w-75 align-self-end"
							src="${contextRoot}/img/about.jpg" alt="">
						<div class="w-50 bg-secondary p-5" style="margin-top: -25%;">
							<h1 class="text-uppercase text-primary mb-3">SURVIVAL</h1>
							<h2 class="text-uppercase mb-0">加入我們</h2>
						</div>
					</div>
				</div>
				<div class="col-lg-6 wow fadeIn" data-wow-delay="0.5s">
					<p class="d-inline-block bg-secondary text-primary py-1 px-4">關於我們</p>
					<h1 class="text-uppercase mb-4">不只是打生存！</h1>
					<p>屌炸天</p>
					<p class="mb-4"></p>
					<div class="row g-4">
						<div class="col-md-6">
							<h3 class="text-uppercase mb-3">起自 2023 年</h3>
							<p class="mb-0">全台最大生存遊戲場地租借</p>
						</div>
						<div class="col-md-6">
							<h3 class="text-uppercase mb-3">超過 1000+ 客戶</h3>
							<p class="mb-0">來過都說讚</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- About End -->


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
							<div class="i_item">
							<i class="fas fa-meteor"></i>
							</div>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">活動</h3>
							<p>活動資訊速速了解</p>
							<span class="text-uppercase text-primary">多人對戰</span>
						</div>
						<a class="btn btn-square" href="${contextRoot}/front/competition"><i
							class="fa fa-plus text-primary"></i></a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<div class="i_item">
							<i class="fa-brands fa-shopify"></i>
							</div>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">商城</h3>
							<p>各式槍枝服裝一次滿足</p>
							<span class="text-uppercase text-primary">手刀購買</span>
						</div>
						<a class="btn btn-square" href="${contextRoot}/front/Market/index"><i
							class="fa fa-plus text-primary"></i></a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<div class="i_item">
							<i class="fa-solid fa-comments"></i>
							</div>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">論壇</h3>
							<p>隨時掌握最新資訊</p>
							<span class="text-uppercase text-primary">新聞速報</span>
						</div>
						<a class="btn btn-square" href="${contextRoot}/front/Forum/index"><i
							class="fa fa-plus text-primary"></i></a>
					</div>
				</div>
				
				
			</div>
		</div>
	</div>
	<!-- Service End -->




	<!-- Team Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center mx-auto mb-5 wow fadeInUp"
				data-wow-delay="0.1s" style="max-width: 600px;">
				<p class="d-inline-block bg-secondary text-primary py-1 px-4">生存冠軍</p>
				<h1 class="text-uppercase">戰到最後的辣個男人</h1>
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
							<h5 class="text-uppercase"></h5>
							<span class="text-primary">李奧納多皮卡丘</span>
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
							<h5 class="text-uppercase"></h5>
							<span class="text-primary">傑森包爾</span>
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
							<h5 class="text-uppercase"></h5>
							<span class="text-primary">比利庫柏</span>
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
							<h5 class="text-uppercase"></h5>
							<span class="text-primary">傑森史塔生</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Team End -->

	<!-- Testimonial End -->
	<jsp:include page="../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>