<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!-- Spinner Start -->
<div id="spinner"
	class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
	<div class="spinner-grow text-primary"
		style="width: 3rem; height: 3rem;" role="status">
		<span class="sr-only">準備好了嗎？</span>
	</div>
</div>
<!-- Spinner End -->
<!-- Navbar Start -->
<nav
	class="navbar navbar-expand-lg bg-secondary navbar-dark sticky-top py-lg-0 px-lg-5 wow fadeIn"
	data-wow-delay="0.1s">
	<a href="${contextRoot}/" class="navbar-brand ms-4 ms-lg-0">
		<h1 class="mb-0 text-primary text-uppercase">
			<i class="fa-solid fa-person-rifle"></i>&nbsp;Survival
		</h1>
	</a>
	<button type="button" class="navbar-toggler me-4"
		data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<div class="navbar-nav ms-auto p-4 p-lg-0">
			<a href="${contextRoot}/" class="nav-item nav-link active">首頁</a> <a
				href="${contextRoot}/about" class="nav-item nav-link">關於</a>
			<div class="nav-item dropdown">
				<a href="" class="nav-link dropdown-toggle"
					data-bs-toggle="dropdown">服務</a>
				<div class="dropdown-menu m-0">
					<a href="${contextRoot}/front/competition" class="dropdown-item">活動</a>
					<a href="${contextRoot}/team" class="dropdown-item">場地</a> <a
						href="${contextRoot}/open" class="dropdown-item">商城</a> <a
						href="${contextRoot}/testimonial" class="dropdown-item">論壇</a> <a
						href="${contextRoot}/404page" class="dropdown-item">404</a>
				</div>
			</div>
			<div class="nav-item dropdown">
				<a href="#" class="nav-link dropdown-toggle"
					data-bs-toggle="dropdown">頁面</a>
				<div class="dropdown-menu m-0">
					<a href="${contextRoot}/price" class="dropdown-item">價位</a> <a
						href="${contextRoot}/team" class="dropdown-item">設計師</a> <a
						href="${contextRoot}/open" class="dropdown-item">服務時段</a> <a
						href="${contextRoot}/testimonial" class="dropdown-item">顧客評價</a> <a
						href="${contextRoot}/404page" class="dropdown-item">404</a>
				</div>
			</div>
			<a href="${contextRoot}/contact" class="nav-item nav-link">聯絡我們</a>
		</div>
		<a href="${contextRoot}/front/signup"
			class="btn btn-primary rounded-0 py-2 px-lg-4 d-none d-lg-block">
			立即報名<i class="fa fa-arrow-right ms-3"></i>
		</a>
	</div>
</nav>
<!-- Navbar End -->