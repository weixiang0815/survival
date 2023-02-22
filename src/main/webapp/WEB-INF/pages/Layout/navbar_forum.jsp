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
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="${contextRoot}/">生存遊戲</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="${contextRoot}/forum.main">論壇系統首頁</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${contextRoot}/formToAdd">貼文發佈</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${contextRoot}/posts/getAll">最新貼文</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${contextRoot}/posts/getAll">最新貼文</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${contextRoot}/posts/getAll">最新貼文</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${contextRoot}/posts/getAll">最新貼文</a></li>
						<li class="nav-item"><a class="nav-link disabled">連結 3</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>