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
					<a href="${contextRoot}/front/Market/index" class="dropdown-item">戰略商城</a>
					<a href="${contextRoot}/front/Forum/index" class="dropdown-item">論壇</a>
				</div>
			</div>
			<c:choose>
				<c:when test="${not empty sessionScope.player && sessionScope.player != null}">
					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown">個人資料</a>
						<div class="dropdown-menu m-0">
							<a href="${contextRoot}/player/${sessionScope.player.id}"
								class="dropdown-item">玩家資料</a> <a
								href="${contextRoot}/front/Market/order" class="dropdown-item">玩家訂單</a>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown">加入我們</a>
						<div class="dropdown-menu m-0">
							<a href="${contextRoot}/Player/login" class="dropdown-item">使用者登入</a>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
			<a href="${contextRoot}/contact" class="nav-item nav-link">聯絡我們</a>
		</div>
		<%-- 				<a href="${contextRoot}/front/signup" class="btn btn-primary rounded-0 py-2 px-lg-4 d-none d-lg-block"> --%>
		<!-- 					立即報名<i class="fa fa-arrow-right ms-3"></i> -->
		<!-- 				</a> -->
		<div class="navbar-nav">
			<div class="nav-item text-nowrap"
				style="display: flex; justify-content: center; align-items: center;">
				<c:choose>
					<c:when test="${not empty sessionScope.player}">
						<!-- 如果存在名為 employee 的實體，則顯示 name 屬性的值 -->
						<span style="color: white;">你好，${player.name}！</span>
						<a
							class="btn btn-primary rounded-0 py-2 px-lg-4 d-none d-lg-block"
							href="${contextRoot}/logout">登出</a>
					</c:when>
					<c:otherwise>
						<!-- 如果不存在名為 employee 的實體，則顯示登入按鈕 -->
						<a
							class="btn btn-primary rounded-0 py-2 px-lg-4 d-none d-lg-block"
							href="${contextRoot}/Player/login">登入</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</nav>
<!-- Navbar End -->