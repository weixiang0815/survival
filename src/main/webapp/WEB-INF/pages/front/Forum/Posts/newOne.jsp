<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增貼文</title>
<jsp:include page="../../../Template/front/includedinhead.jsp"></jsp:include>
<style>
ul#comp-link>li {
	list-style-type: none;
}

i {
	font-size: 2rem;
	color: red;
}

img {
	width: 150px;
	hight: 150px;
	padding: 10px;
}

div .ct {
	display: flex;
	/* 水平置中 */
	align-items: center;
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
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">貼文發佈</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}">首頁</a></li>
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}/front/Forum/index">論壇</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">貼文發佈</li>
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
				<p class="d-inline-block bg-secondary text-primary py-1 px-4">貼文發佈</p>
				<h1 class="text-uppercase">新增貼文</h1>
			</div>
			<!-- class="row" 橫向排列-->
			<div class="text-center mx-auto mb-5 wow fadeInUp">
				<!-- class="wow fadeInUp" 上浮顯現 -->
				<!-- data-wow-delay="0.1s" 設定延遲時間-->
				<!-- col-lg-4 col-md-6 Bootstrap分隔樣板 col為列分隔最大為12 lg:空間高於992px md:空間高於≥768px-->
				<div class=" wow fadeInUp" data-wow-delay="0.1s">
					<div class="wow d-flex text-center .ct">
						<!-- 用戶欄設計 -->
						<div class="col-md-3" style="border: #FF0000 2px solid;">

							<img src="${contextRoot}/player/photo/${player.id}" />

							<p>用戶: ${player.name}</p>
							<p>暱稱: ${player.nickname}</p>
							<p>位居縣市: ${player.county}</p>

						</div>
						<!-- 用戶欄設計結束 -->
						<!-- 表單開始 -->
						<div class="col-md-9" style="border: #FF0000 2px solid;">
							<form:form action="${contextRoot}/front/posts/create"
								modelAttribute="postsBean" method="post">
<%-- 								<form:input path="player" type="hidden" value="${player.id}"/> --%>
								<!-- 標題 -->
								<label for="inputName">請輸入標題:</label>
								<form:input class="form-control" id="inputName" path="name" />
								<br />
								<!-- 分類 -->
								<label for="inputClassify">請輸入分類:</label>
								<form:select class="form-control" id="inputClassify"
									path="classify">
									<form:option value="none" selected="true" disabled="true"
										hidden="true">請選擇選項</form:option>
									<form:option value="心得">心得</form:option>
									<form:option value="問題">問題</form:option>
									<form:option value="閒聊">閒聊</form:option>
									<form:option value="討論">討論</form:option>
								</form:select>

								<br />
								<!-- 內容 -->
								<label for="inputEssay">請輸入內容:</label>
								<form:textarea id="ckeditor" path="content" class="form-control" />
								<br />
								<!-- 按鈕排版 -->
								<div class="row ">
									<div class="col-3"></div>
									<div class="col">
										<button type="submit" class="btn btn-outline-primary">送出</button>
									</div>
									<div class="col">
										<button type="button" id="toForum"
											class="btn btn-outline-primary">取消</button>
									</div>
									<div class="col-3"></div>
								</div>
								
							</form:form>
						</div>
						<!-- 表單結束 -->
					</div>
				</div>
			</div>
			<!-- container結束 -->
		</div>
	</div>
	<!-- Service End -->
	<jsp:include page="../../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../../Template/front/includedinbody.jsp"></jsp:include>
	<script>
// 		jQuery重新導向 取消按鈕
		$("#toForum").on({
			click : function(e) {
				e.preventDefault();
				window.location.href = '${contextRoot}/front/Forum/index';
			}
		});
	</script>
</body>
</html>