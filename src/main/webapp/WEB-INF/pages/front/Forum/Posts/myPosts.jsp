<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>個人貼文</title>
<jsp:include page="../../../Template/front/includedinhead.jsp"></jsp:include>
<style>
.a1 {
	display: flex;
	justify-content: center;
}

a {
	color: red;
	transition: color 0.5s ease;
}

a:hover {
	color: white;
}

td {

	width: 200px;
}
</style>
</head>
<body>
	<jsp:include page="../../../Template/front/navbar.jsp"></jsp:include>
	<!-- Page Header Start -->
	<div class="container-fluid page-header py-5 mb-5 wow fadeIn"
		data-wow-delay="0.1s">
		<div class="container text-center py-5">
			<h1
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">貼文查詢</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}">首頁</a></li>
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}/front/Forum/index">論壇</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">個人貼文</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->
	<!-- Service Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center mx-auto mb-5 wow fadeInUp"
				data-wow-delay="0.1s">
				<p class="d-inline-block bg-secondary text-primary py-1 px-4">個人貼文</p>
				<h1 class="text-uppercase">個人貼文</h1>
			</div>
			<!-- class="row" 橫向排列-->
			<div class="text-center mx-auto mb-5 wow fadeInUp">
				<!-- class="wow fadeInUp" 上浮顯現 -->
				<!-- data-wow-delay="0.1s" 設定延遲時間-->
				<!-- col-lg-4 col-md-6 Bootstrap分隔樣板 col為列分隔最大為12 lg:空間高於992px md:空間高於≥768px-->
				<div class=" wow fadeInUp" data-wow-delay="0.1s">
					<div>
						<!-- 						<div class="col-md-3" style="border: #FF0000 2px solid;"> -->
						<div class="row">
							<div class="col-3"></div>
							<div class="col-6">
								<table class="text-center">
									<thead>
										<tr>
											<th><p>類型</p></th>
											<th><p>關鍵字</p></th>
											<th><p>最新</p></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>
												<label><input 
													type="checkbox" class="classify" name="classify" 
													value="心得"/>心得</label> 
												<label><input
													type="checkbox" class="classify" name="classify"
													value="問題"/>問題</label> 
												<label><input
													type="checkbox" class="classify" name="classify"
													value="閒聊"/>閒聊</label> 
												<label><input
													type="checkbox" class="classify" name="classify"
													value="討論"/>討論</label></td>
											<td><input type="text" id="name" name="name" />
											</td>
											<td><label><input type="checkbox" class="date"
													name="date" value="1">今日最新</label></td>
										</tr>
										<tr>
											<td colspan="3"><input type="button" value="搜尋貼文" id="submitBtn" />
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="col-3"></div>
						</div>
						<br />
						<div class="row">
							<div class="a1 row">
								<div class="col-3"></div>
								<div class="col-6">
									<table class="table table-hover table-bordered">
										<thead>
											<tr>
												<th colspan="2">貼文名稱</th>
												
											</tr>
										</thead>
										<tbody id="myTbody">
											<c:forEach items="${postsPage.content}" var="post">

												<tr>
													<td>[${post.classify}] <a
														href="${contextRoot}/front/posts/content?id=${post.id}">${post.name}</a></td>
													<td>${post.player.name}/ ${post.player.nickname}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="col-3"></div>
							</div>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
	<!-- Service End -->
	<!-- jquery欲使用就須放在你所寫的.js前面 -->
	<jsp:include page="../../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../../Template/front/includedinbody.jsp"></jsp:include>
	<script>
		const playerId = ${sessionScope.player.id};
	</script>
	<script src="${contextRoot}/js/ajax/posts/axios-owner-page-search.js"></script>
	
</body>
</html>