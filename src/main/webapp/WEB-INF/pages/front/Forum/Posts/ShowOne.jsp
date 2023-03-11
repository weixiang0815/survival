<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>論壇</title>
<style>
.divcontainer {
  position: relative; /* 將父元素設置為相對定位，以便子元素可以使用絕對定位 */
}

.divitem1 {
  float: right; /* 將元素向右浮動 */
  position: absolute; /* 將元素設置為絕對定位 */
  right: 20px; /* 將元素定位在右側，再些微調整差距 */
  top: 0; /* 將元素定位在頂部 */
  align-items: center;
  color: red;
  font-size: 2em;
  transition: color 0.5s ease;
}
.divitem1:hover{
  color: #F00078;
}
.divitem2 {
  float: right; /* 將元素向右浮動 */
  position: absolute; /* 將元素設置為絕對定位 */
  right: 90px; /* 將元素定位在右側，再些微調整差距 */
  top: 0; /* 將元素定位在頂部 */
  align-items: center;
  color: red;
  font-size: 2em;
  transition: color 0.5s ease;
}
.divitem2:hover{
  color: blue;
}
.divitem3 {
  float: right; /* 將元素向右浮動 */
  position: absolute; /* 將元素設置為絕對定位 */
  right: 160px; /* 將元素定位在右側，再些微調整差距 */
  top: 0; /* 將元素定位在頂部 */
  align-items: center;
  color: red;
  font-size: 2em;
  transition: color 0.5s ease;
}
.divitem3:hover{
  color: yellow;
}

.acontainer {
  position: relative; /* 將父元素設置為相對定位，以便子元素可以使用絕對定位 */
}

.aitem {
  justify-content: center;
  align-items: center;
}
</style>
<jsp:include page="../../../Template/front/includedinhead.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../../../Template/front/navbar.jsp"></jsp:include>
	<!-- Page Header Start -->
	<div class="container-fluid page-header py-5 mb-5 wow fadeIn"
		data-wow-delay="0.1s">
		<div class="container text-center py-5">
			<h1
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">論壇</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white" href="${contextRoot}/">首頁</a></li>
					<li class="breadcrumb-item"><a class="text-white" href="${contextRoot}/">論壇</a></li>
					<li class="breadcrumb-item"><a class="text-white" href="${contextRoot}/">貼文查詢</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">${post.name}</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->
<div class="container text-center">
	<div>
		<div class="wow fadeInUp" data-wow-delay="0.1s">
			<div class="wow d-flex text-center">
				<div  style="border: #FF0000 2px solid;">

					<img src="${contextRoot}/player/photo/${post.player.id}" />

					<p>用戶: ${post.player.name}</p>
					<p>暱稱: ${post.player.nickname}</p>
					<p>位居縣市: ${post.player.county}</p>

				</div>
				<div  style="border: #FF0000 2px solid;">
					<!-- 這個內容為HTML可以直接輸入即可 -->
					${post.content}
					<hr />
					<div class="divcontainer">
						
						
						<a class="divitem1 acontainer" href="">
							<i class="fa-solid fa-heart"></i>
							<span class="aitem" style="font-size: 20px;">收藏</span>
						</a>
						<a class="divitem2 acontainer" href="">
							<i class="fa-solid fa-thumbs-up"></i>
							<span class="aitem" style="font-size: 20px;">按讚</span>
						</a>
						<a class="divitem3 acontainer" href="">
							<i class="fa-solid fa-star"></i>
							<span class="aitem" style="font-size: 20px;">評分</span>
						</a>
					</div>
				</div>
			</div>
			<!-- 留言開始 -->
			<div class="wow d-flex text-center">
			</div>
			<!-- 留言結束 -->
		</div>
	</div>
</div>

<!-- Service Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center mx-auto mb-5 wow fadeInUp"
				data-wow-delay="0.1s" style="max-width: 600px;">
				<h1 class="text-uppercase">論壇</h1>
				<p class="d-inline-block bg-secondary text-primary py-1 px-4">服務</p>
			</div>
			<div class="row g-4">
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<i class="fa-solid fa-trophy"></i>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">精選好評</h3>
							<p>這裡有各種好評如潮的專業生存玩家相關知識，會員用戶人人推薦，趕快點進來看看吧。</p>
							<span class="text-uppercase text-primary">From $15</span>
						</div>
						<a class="btn btn-square" href="">
							<i class="fa fa-plus text-primary"></i>
						</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<i class="fa-sharp fa-solid fa-pen-to-square"></i>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">貼文發布</h3>
							<p>想要獲得貼文專家勳章嗎?趕緊提供你的知識吧!</p>
							<span class="text-uppercase text-primary">From $15</span>
						</div>
						<a class="btn btn-square" href="${contextRoot}/front/posts/new"><i
							class="fa fa-plus text-primary"></i></a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<i class="fa-solid fa-magnifying-glass"></i>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">貼文查詢</h3>
							<p>這裡是龐大的貼文搜尋庫。上從專業文章、提問；下至閒聊八卦這裡應有盡有!</p>
							<span class="text-uppercase text-primary">From $15</span>
						</div>
						<a class="btn btn-square" href="${contextRoot}/front/posts/getAll"><i
							class="fa fa-plus text-primary"></i></a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<i class="fa-solid fa-person-chalkboard"></i>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">我的貼文</h3>
							<p>這裡可編輯你的貼文，方便使用者控管自己的文章。</p>
							<span class="text-uppercase text-primary">From $15</span>
						</div>
						<a class="btn btn-square" href=""><i
							class="fa fa-plus text-primary"></i></a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<i class="fa-solid fa-heart"></i>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">我的關注</h3>
							<p>可以把你喜歡的貼文留下來，以防下次找不到。</p>
							<span class="text-uppercase text-primary">From $15</span>
						</div>
						<a class="btn btn-square" href=""><i
							class="fa fa-plus text-primary"></i></a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
					<div
						class="service-item position-relative overflow-hidden bg-secondary d-flex h-100 p-5 ps-0">
						<div
							class="bg-dark d-flex flex-shrink-0 align-items-center justify-content-center"
							style="width: 60px; height: 60px;">
							<i class="fa-solid fa-star"></i>
						</div>
						<div class="ps-4">
							<h3 class="text-uppercase mb-3">評價紀錄</h3>
							<p>這裡可以看到妳曾經評價過的貼文，也可以修改貼文評價?我怎麼感覺有點多餘??</p>
							<span class="text-uppercase text-primary">From $15</span>
						</div>
						<a class="btn btn-square" href=""><i
							class="fa fa-plus text-primary"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Service End -->
</div>
<jsp:include page="../../../Template/front/footer.jsp"></jsp:include>
<jsp:include page="../../../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>