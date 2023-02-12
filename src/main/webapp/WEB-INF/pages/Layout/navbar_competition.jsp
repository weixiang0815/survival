<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<style>
.dropdown-menu .dropdown-toggle:after {
	display: inline-block;
	margin-left: .255em;
	vertical-align: .255em;
	content: "";
	border-top: .3em solid;
	border-right: .3em solid transparent;
	border-bottom: 0;
	border-left: .3em solid transparent;
}

.dropdown-menu ul {
	display: none;
	position: absolute;
	top: 100%;
	left: 0;
	z-index: 1000;
}

.dropdown-menu li:hover>ul {
	display: block;
}
</style>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="${contextRoot}/competition/">活動系統</a>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="${contextRoot}/competition/">首頁 </a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">活動系統原生 JSP</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="${contextRoot}/competition/new">新增活動</a>
							<a class="dropdown-item" href="${contextRoot}/competition/search">查詢活動</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">活動系統 AJAX</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="${contextRoot}/competition/new">新增活動</a>
							<a class="dropdown-item" href="${contextRoot}/competition/search">查詢活動</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">報名系統原生 JSP</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="${contextRoot}/competition/signup">新增報名</a>
							<a class="dropdown-item"
								href="${contextRoot}/competition/signup/search">查詢報名</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">報名系統 AJAX</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="${contextRoot}/competition/signup">新增報名</a>
							<a class="dropdown-item"
								href="${contextRoot}/competition/signup/search">查詢報名</a>
						</div></li>
				</ul>
			</div>
			<c:choose>
				<c:when test="${player == null && employee == null}">
					<a href="#"><button class="btn btn-primary">登入</button></a>
				</c:when>
				<c:otherwise>
					<a href="#"><button class="btn btn-primary">登出</button></a>
				</c:otherwise>
			</c:choose>
		</nav>
	</header>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"
		integrity="sha256-lSjKY0/srUM9BE3dPm+c4fBo1dky2v27Gdjm2uoZaL0="
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
	<script>
		$(document).ready(function() {
			$(".nav-item").addClass("active");
		});
	</script>
</body>

</html>