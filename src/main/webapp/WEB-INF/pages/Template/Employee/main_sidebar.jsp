<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<style>
.sidebar {
	height: 100vh;
	overflow-y: auto;
	position: fixed;
	top: 0;
	left: 0;
	bottom: 0;
	width: 250px;
	padding: 20px;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar text-bg-dark">
				<a href="/"
					class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
					<svg class="bi pe-none me-2" width="40" height="32">
						<use xlink:href="#bootstrap" /></svg> <span class="fs-4">Survival</span>
				</a>
				<hr>
				<div class="dropdown">
					<a href="#"
						class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
						data-bs-toggle="dropdown" aria-expanded="false"> <img
						src="https://github.com/mdo.png" alt="" width="32" height="32"
						class="rounded-circle me-2"> <strong>員工名稱</strong>
					</a>
					<ul class="dropdown-menu dropdown-menu-dark text-small shadow">
						<li><a class="dropdown-item" href="#">設定</a></li>
						<li><a class="dropdown-item" href="#">個人頁面</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">登出</a></li>
					</ul>
				</div>
				<hr>
				<ul class="nav nav-pills flex-column mb-auto">
					<li class="nav-item"><a href="#" class="nav-link active"
						aria-current="page"> <svg class="bi pe-none me-2" width="16"
								height="16">
								<use xlink:href="#home" /></svg> 首頁
					</a></li>
					<li><a href="#" class="nav-link text-white"> <svg
								class="bi pe-none me-2" width="16" height="16">
								<use xlink:href="#speedometer2" /></svg> 員工管理
					</a></li>
					<li><a href="#" class="nav-link text-white"> <svg
								class="bi pe-none me-2" width="16" height="16">
								<use xlink:href="#table" /></svg> 會員管理
					</a></li>
					<li><a href="#" class="nav-link text-white"> <svg
								class="bi pe-none me-2" width="16" height="16">
								<use xlink:href="#grid" /></svg> 活動管理
					</a></li>
					<li><a href="#" class="nav-link text-white"> <svg
								class="bi pe-none me-2" width="16" height="16">
								<use xlink:href="#people-circle" /></svg> 商城管理
					</a></li>
					<li><a href="#" class="nav-link text-white"> <svg
								class="bi pe-none me-2" width="16" height="16">
								<use xlink:href="#people-circle" /></svg> 場地管理
					</a></li>
					<li><a href="#" class="nav-link text-white"> <svg
								class="bi pe-none me-2" width="16" height="16">
								<use xlink:href="#people-circle" /></svg> 論壇管理
					</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-md-10 main">
				<!-- Main content goes here -->
			</div>
		</div>
	</div>
	<iframe src="" frameborder="0"></iframe>
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>