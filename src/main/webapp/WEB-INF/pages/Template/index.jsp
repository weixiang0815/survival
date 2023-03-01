<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!doctype html>
<html lang="zh-hant-tw">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.108.0">
<title>Survival 後台管理介面</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
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
</style>
<link href="${contextRoot}/css/dashboard.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
	integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
	integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
	crossorigin="anonymous"></script>
<script src="${contextRoot}/js/dashboard.js"></script>
</head>
<body>
	<header
		class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="#">Survival</a>
		<button class="navbar-toggler position-absolute d-md-none collapsed"
			type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
			aria-controls="sidebarMenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<input class="form-control form-control-dark w-100 rounded-0 border-0"
			type="text" placeholder="搜尋" aria-label="Search">
		<div class="navbar-nav">
			<div class="nav-item text-nowrap">
				<a class="nav-link px-3" href="#">登出</a>
			</div>
		</div>
	</header>
	<div class="container-fluid">
		<div class="row">
			<nav id="sidebarMenu"
				class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="position-sticky pt-3 sidebar-sticky">
					<ul class="nav flex-column">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="${contextRoot}/template/"> <span
								data-feather="home" class="align-text-bottom"></span> 後台介面首頁
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${contextRoot}/competition"> <span data-feather="file"
								class="align-text-bottom"></span> 活動系統
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${contextRoot}/Market/marketMain"> <span data-feather="shopping-cart"
							class="align-text-bottom"></span> 商城系統
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${contextRoot}/player.main"> <span data-feather="users"
							class="align-text-bottom"></span> 會員系統
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${contextRoot}/player.main"><i class="bi bi-person-badge"></i>&nbsp;&nbsp;員工系統
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${contextRoot}/place"><i class="bi bi-building"></i>&nbsp;&nbsp;場地系統
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${contextRoot}/forum.main"><i class="bi bi-file-text"></i>&nbsp;&nbsp;論壇系統
						</a></li>
					</ul>
					<h6
						class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted text-uppercase">
						<span>已儲存報告</span> <a class="link-secondary"
							href="${contextRoot}/" aria-label="Add a new report"> <span
							data-feather="plus-circle" class="align-text-bottom"></span>
						</a>
					</h6>
					<ul class="nav flex-column mb-2">
						<li class="nav-item"><a class="nav-link"
							href="${contextRoot}/"> <span data-feather="file-text"
								class="align-text-bottom"></span> 本月
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${contextRoot}/"> <span data-feather="file-text"
								class="align-text-bottom"></span> 上個季度
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${contextRoot}/"> <span data-feather="file-text"
								class="align-text-bottom"></span> 社交影響
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${contextRoot}/"> <span data-feather="file-text"
								class="align-text-bottom"></span> 年尾銷量
						</a></li>
					</ul>
				</div>
			</nav>
			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">後台管理介面</h1>
					<div class="btn-toolbar mb-2 mb-md-0">
						<div class="btn-group me-2">
							<button type="button" class="btn btn-sm btn-outline-secondary">分享</button>
							<button type="button" class="btn btn-sm btn-outline-secondary">匯出</button>
						</div>
						<button type="button"
							class="btn btn-sm btn-outline-secondary dropdown-toggle">
							<span data-feather="calendar" class="align-text-bottom"></span>
							本週
						</button>
					</div>
				</div>
				<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>
				<h2>副標題</h2>
				<div class="table-responsive">
					<table class="table table-striped table-sm">
						<thead>
							<tr>
								<th scope="col"></th>
								<th scope="col">標題</th>
								<th scope="col">標題</th>
								<th scope="col">標題</th>
								<th scope="col">標題</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1,001</td>
								<td>隨機</td>
								<td>資料</td>
								<td>預覽文字</td>
								<td>文字</td>
							</tr>
							<tr>
								<td>1,002</td>
								<td>預覽文字</td>
								<td>無關緊要</td>
								<td>視覺</td>
								<td>排版</td>
							</tr>
							<tr>
								<td>1,003</td>
								<td>資料</td>
								<td>豐富</td>
								<td>管理介面</td>
								<td>表格</td>
							</tr>
							<tr>
								<td>1,003</td>
								<td>資訊</td>
								<td>預覽文字</td>
								<td>表述</td>
								<td>資料</td>
							</tr>
							<tr>
								<td>1,004</td>
								<td>文字</td>
								<td>隨機</td>
								<td>排版</td>
								<td>管理介面</td>
							</tr>
							<tr>
								<td>1,005</td>
								<td>管理介面</td>
								<td>無關緊要</td>
								<td>文字</td>
								<td>預覽文字</td>
							</tr>
							<tr>
								<td>1,006</td>
								<td>管理介面</td>
								<td>表述</td>
								<td>豐富</td>
								<td>資料</td>
							</tr>
							<tr>
								<td>1,007</td>
								<td>預覽文字</td>
								<td>表格</td>
								<td>資訊</td>
								<td>無關緊要</td>
							</tr>
							<tr>
								<td>1,008</td>
								<td>隨機</td>
								<td>資料</td>
								<td>預覽文字</td>
								<td>文字</td>
							</tr>
							<tr>
								<td>1,009</td>
								<td>預覽文字</td>
								<td>無關緊要</td>
								<td>視覺</td>
								<td>排版</td>
							</tr>
							<tr>
								<td>1,010</td>
								<td>資料</td>
								<td>豐富</td>
								<td>管理介面</td>
								<td>表格</td>
							</tr>
							<tr>
								<td>1,011</td>
								<td>資訊</td>
								<td>預覽文字</td>
								<td>表述</td>
								<td>資料</td>
							</tr>
							<tr>
								<td>1,012</td>
								<td>文字</td>
								<td>預覽文字</td>
								<td>排版</td>
								<td>管理介面</td>
							</tr>
							<tr>
								<td>1,013</td>
								<td>管理介面</td>
								<td>無關緊要</td>
								<td>文字</td>
								<td>視覺</td>
							</tr>
							<tr>
								<td>1,014</td>
								<td>管理介面</td>
								<td>表述</td>
								<td>豐富</td>
								<td>資料</td>
							</tr>
							<tr>
								<td>1,015</td>
								<td>隨機</td>
								<td>表格</td>
								<td>資訊</td>
								<td>文字</td>
							</tr>
						</tbody>
					</table>
				</div>
			</main>
		</div>
	</div>
</body>
</html>
