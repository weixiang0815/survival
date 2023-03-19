<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="utf-8">
<title>聯絡我們</title>
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
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">聯絡我們</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white" href="#">首頁</a></li>
					<li class="breadcrumb-item"><a class="text-white" href="#">頁面</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">聯絡我們</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->


	<!-- Contact Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="row g-0">
				<div class="col-lg-6 wow fadeIn" data-wow-delay="0.1s">
					<div class="bg-secondary p-5">
						<p class="d-inline-block bg-dark text-primary py-1 px-4">聯絡我們</p>
						<h1 class="text-uppercase mb-4">有任何問題？請聯絡我們！</h1>
						<form>
							<div class="row g-3">
								<div class="col-md-6">
									<div class="form-floating">
										<input type="text" class="form-control bg-transparent"
											id="name" placeholder="姓名"> <label for="name">姓名</label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-floating">
										<input type="email" class="form-control bg-transparent"
											id="email" placeholder="電子信箱"> <label
											for="email">電子信箱</label>
									</div>
								</div>
								<div class="col-12">
									<div class="form-floating">
										<input type="text" class="form-control bg-transparent"
											id="subject" placeholder="主旨"> <label
											for="subject">主旨</label>
									</div>
								</div>
								<div class="col-12">
									<div class="form-floating">
										<textarea class="form-control bg-transparent"
											placeholder="有什麼想告訴我們的？" id="message"
											style="height: 100px"></textarea>
										<label for="message">訊息</label>
									</div>
								</div>
								<div class="col-12">
									<button class="btn btn-primary w-100 py-3" type="submit">送出</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="col-lg-6 wow fadeIn" data-wow-delay="0.5s">
					<div class="h-100" style="min-height: 400px;">
						<iframe class="google-map w-100 h-100"
							src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d391.11585059587577!2d121.54269064594865!3d25.03358214678788!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3442abd4825ecdf1%3A0x1376611696cf0cff!2z5Y-w5YyX5biC6L6y5pyD5aSn5qiT!5e0!3m2!1szh-TW!2stw!4v1677773970735!5m2!1szh-TW!2stw"
							frameborder="0" allowfullscreen="" aria-hidden="false"
							tabindex="0"
							style="filter: grayscale(100%) invert(92%) contrast(83%); border: 0;"></iframe>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Contact End -->
	<jsp:include page="../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>