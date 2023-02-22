<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<style>
	.bd-placeholder-img {
		font-size: 1.125rem;
		text-anchor: middle;
		-webkit-user-select: none;
		-moz-user-select: none;
		user-select: none;
	}

	@media (min-width : 768px) {
		.bd-placeholder-img-lg {
			font-size: 3.5rem;
		}
	}

	.b-example-divider {
		height: 3rem;
		background-color: rgba(0, 0, 0, .1);
		border: solid rgba(0, 0, 0, .15);
		border-width: 1px 0;
		box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
	}

	.b-example-vr {
		flex-shrink: 0;
		width: 1.5rem;
		height: 100vh;
	}

	.bi {
		vertical-align: -.125em;
		fill: currentColor;
	}

	.nav-scroller {
		position: relative;
		z-index: 2;
		height: 2.75rem;
		overflow-y: hidden;
	}

	.nav-scroller .nav {
		display: flex;
		flex-wrap: nowrap;
		padding-bottom: 1rem;
		margin-top: -1px;
		overflow-x: auto;
		text-align: center;
		white-space: nowrap;
		-webkit-overflow-scrolling: touch;
	}

	.nav-link {
		border-radius: 50px;
	}

	.nav-link:hover {
		background-color: rgba(0, 0, 0, .15);
	}
</style>
<link href="${contextRoot}/css/dashboard.css" rel="stylesheet">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"
	integrity="sha256-lSjKY0/srUM9BE3dPm+c4fBo1dky2v27Gdjm2uoZaL0=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
	<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="#">Survival</a>
		<button class="navbar-toggler position-absolute d-md-none collapsed" type="button"
			data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<input class="form-control form-control-dark w-100 rounded-0 border-0" type="text" placeholder="搜尋"
			aria-label="Search">
		<div class="navbar-nav">
			<div class="nav-item text-nowrap">
				<a class="nav-link px-3" href="#">登出</a>
			</div>
		</div>
	</header>
	<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
		<div class="position-sticky pt-3 sidebar-sticky">
			<ul class="nav flex-column">
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" href="#">
						<i class="bi bi-house-gear"></i>&nbsp;&nbsp;後台介面首頁
					</a>
				</li>
				<li class="nav-item">
					<a data-bs-parent="#sidebarMenu" data-bs-toggle="collapse" class="nav-link"
						href="#submenu-competition">
						<i class="bi bi-card-checklist"></i>&nbsp;&nbsp;活動系統
					</a>
					<ul class="collapse" id="submenu-competition">
						<li><a href="${contextRoot}/competition/new" class="nav-link">新增活動</a></li>
						<li><a href="${contextRoot}/competition/search/result" class="nav-link">查詢活動</a></li>
						<li><a href="${contextRoot}/competition/signup" class="nav-link">新增報名</a></li>
						<li><a href="${contextRoot}/competition/signup/search/result" class="nav-link">查詢報名</a></li>
					</ul>
				</li>
				<li class="nav-item">
					<a data-bs-parent="#sidebarMenu" data-bs-toggle="collapse" class="nav-link"
						href="#submenu-market">
						<i class="bi bi-cart4"></i>&nbsp;&nbsp;商城系統
					</a>
					<ul class="collapse" id="submenu-market">
						<li><a href="${contextRoot}/" class="nav-link">新增</a></li>
						<li><a href="${contextRoot}/" class="nav-link">修改</a></li>
						<li><a href="${contextRoot}/" class="nav-link">刪除</a></li>
						<li><a href="${contextRoot}/" class="nav-link">查詢</a></li>
					</ul>
				</li>
				<li class="nav-item">
					<a data-bs-parent="#sidebarMenu" data-bs-toggle="collapse" class="nav-link"
						href="#submenu-player">
						<i class="bi bi-people"></i>&nbsp;&nbsp;會員系統
					</a>
					<ul class="collapse" id="submenu-player">
						<li><a href="${contextRoot}/" class="nav-link">新增</a></li>
						<li><a href="${contextRoot}/" class="nav-link">修改</a></li>
						<li><a href="${contextRoot}/" class="nav-link">刪除</a></li>
						<li><a href="${contextRoot}/" class="nav-link">查詢</a></li>
					</ul>
				</li>
				<li class="nav-item">
					<a data-bs-parent="#sidebarMenu" data-bs-toggle="collapse" class="nav-link"
						href="#submenu-employee">
						<i class="bi bi-person-badge"></i>&nbsp;&nbsp;員工系統
					</a>
					<ul class="collapse" id="submenu-employee">
						<li><a href="${contextRoot}/" class="nav-link">新增</a></li>
						<li><a href="${contextRoot}/" class="nav-link">修改</a></li>
						<li><a href="${contextRoot}/" class="nav-link">刪除</a></li>
						<li><a href="${contextRoot}/" class="nav-link">查詢</a></li>
					</ul>
				</li>
				<li class="nav-item">
					<a data-bs-parent="#sidebarMenu" data-bs-toggle="collapse" class="nav-link"
						href="#submenu-place">
						<i class="bi bi-building"></i>&nbsp;&nbsp;場地系統
					</a>
					<ul class="collapse" id="submenu-place">
						<li><a href="${contextRoot}/place/uploadPage" class="nav-link">新增場地</a></li>
						<li><a href="${contextRoot}/place/all" class="nav-link">所有場地</a></li>
						<li><a href="${contextRoot}/warehouse/new" class="nav-link">新增倉庫</a></li>
						<li><a href="${contextRoot}/warehouse/all" class="nav-link">所有倉庫</a></li>
						<li><a href="${contextRoot}/inventory/new" class="nav-link">新增庫存</a></li>
						<li><a href="${contextRoot}/inventory/all" class="nav-link">所有庫存</a></li>
						<li><a href="${contextRoot}/schedule/new" class="nav-link">新增排程</a></li>
					</ul>
				</li>
				<li class="nav-item">
					<a data-bs-parent="#sidebarMenu" data-bs-toggle="collapse" class="nav-link"
						href="#submenu-forum">
						<i class="bi bi-file-text"></i>&nbsp;&nbsp;論壇系統
					</a>
					<ul class="collapse" id="submenu-forum">
						<li><a href="${contextRoot}/" class="nav-link">新增</a></li>
						<li><a href="${contextRoot}/" class="nav-link">修改</a></li>
						<li><a href="${contextRoot}/" class="nav-link">刪除</a></li>
						<li><a href="${contextRoot}/" class="nav-link">查詢</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">