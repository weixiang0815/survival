<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!-- Footer Start -->
<div
	class="container-fluid bg-secondary text-light footer mt-5 pt-5 wow fadeIn"
	data-wow-delay="0.1s">
	<div class="container py-5">
		<div class="row g-5">
			<div class="col-lg-4 col-md-6">
				<h4 class="text-uppercase mb-4">聯絡資訊</h4>
				<div class="d-flex align-items-center mb-2">
					<div class="btn-square bg-dark flex-shrink-0 me-3">
						<span class="fa fa-map-marker-alt text-primary"></span>
					</div>
					<span>台北市復興南路一段390號2樓</span>
				</div>
				<div class="d-flex align-items-center mb-2">
					<div class="btn-square bg-dark flex-shrink-0 me-3">
						<span class="fa fa-phone-alt text-primary"></span>
					</div>
					<span>（02）6631-6588</span>
				</div>
				<div class="d-flex align-items-center">
					<div class="btn-square bg-dark flex-shrink-0 me-3">
						<span class="fa fa-envelope-open text-primary"></span>
					</div>
					<span>info@example.com</span>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<h4 class="text-uppercase mb-4">快速連結</h4>
				<a class="btn btn-link" href="${contextRoot}/about">關於我們</a> <a
					class="btn btn-link" href="${contextRoot}/contact">聯絡我們</a> <a
					class="btn btn-link" href="${contextRoot}/service">服務項目</a> <a
					class="btn btn-link" href="${contextRoot}/code-of-conduct">使用條款</a>
				<a class="btn btn-link" href="">贊助項目</a>
			</div>
			<div class="col-lg-4 col-md-6">
				<h4 class="text-uppercase mb-4">最新資訊</h4>
				<div class="position-relative mb-4">
					<input class="form-control border-0 w-100 py-3 ps-4 pe-5"
						type="text" placeholder="電子信箱">
					<button type="button"
						class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2">訂閱</button>
				</div>
				<div class="d-flex pt-1 m-n1">
					<a class="btn btn-lg-square btn-dark text-primary m-1" href=""><i
						class="fab fa-twitter"></i></a> <a
						class="btn btn-lg-square btn-dark text-primary m-1" href=""><i
						class="fab fa-facebook-f"></i></a> <a
						class="btn btn-lg-square btn-dark text-primary m-1" href=""><i
						class="fab fa-youtube"></i></a> <a
						class="btn btn-lg-square btn-dark text-primary m-1" href=""><i
						class="fab fa-linkedin-in"></i></a>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="copyright">
			<div class="row">
				<div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
					&copy; <a class="border-bottom" href="${contextRoot}/">Survival</a>
					著作權所有
				</div>
				<div class="col-md-6 text-center text-md-end">
					<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
					Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML
						Codex</a> <br>Distributed By: <a class="border-bottom"
						href="https://themewagon.com" target="_blank">ThemeWagon</a>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Footer End -->

<!-- Back to Top -->
<a href="#" class="btn btn-primary btn-lg-square back-to-top"><i
	class="bi bi-arrow-up"></i></a>