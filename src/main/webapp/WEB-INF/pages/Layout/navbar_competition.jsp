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
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="${contextRoot}/competition/">活動系統</a>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link"
							href="${contextRoot}/competition/">首頁 </a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDarkDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false">活動系統</a>
							<ul class="dropdown-menu dropdown-menu-dark"
								aria-labelledby="navbarDarkDropdownMenuLink">
								<li><a class="dropdown-item"
									href="${contextRoot}/competition/new">新增活動（JSP）</a></li>
								<li><a class="dropdown-item"
									href="${contextRoot}/competition/search/result">查詢活動（JSP）</a></li>
								<li><a class="dropdown-item"
									href="${contextRoot}/competition/new">新增活動（AJAX）</a></li>
								<li><a class="dropdown-item"
									href="${contextRoot}/competition/search/result">查詢活動（AJAX）</a></li>
							</ul></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDarkDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false">報名系統</a>
							<ul class="dropdown-menu dropdown-menu-dark"
								aria-labelledby="navbarDarkDropdownMenuLink">
								<li><a class="dropdown-item"
									href="${contextRoot}/competition/signup">新增報名（JSP）</a></li>
								<li><a class="dropdown-item"
									href="${contextRoot}/competition/signup/search">查詢報名（JSP）</a></li>
								<li><a class="dropdown-item"
									href="${contextRoot}/competition/signup">新增報名（AJAX）</a></li>
								<li><a class="dropdown-item"
									href="${contextRoot}/competition/signup/search">查詢報名（AJAX）</a></li>
							</ul></li>
					</ul>
				</div>
				<c:choose>
					<c:when test="${player == null && employee == null}">
						<a href="${contextRoot}/Player/login"><button
								class="btn btn-primary">登入</button></a>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${player == null && employee != null}">
						<p style="color: white;">你好，職員&nbsp;${employee.name}</p>
						</c:when>
							<c:when test="${player != null && employee == null}">
						<p style="color: white;">你好，會員&nbsp;${player.name}</p>
						</c:when>
						</c:choose>
						<a href="${contextRoot}/logout"><button
								class="btn btn-primary">登出</button></a>
					</c:otherwise>
				</c:choose>
			</div>
		</nav>
	</header>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"
		integrity="sha256-lSjKY0/srUM9BE3dPm+c4fBo1dky2v27Gdjm2uoZaL0="
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</body>
</html>