<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="tw.survival.model.Forum.PostsBean"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>論壇</title>
<style>
p {
	color: #AAAAAA;
}

.i_item {
	color: red;
	font-size: 2em;
}

img {
	max-width: 35%;
}

.divcontainer {
	position: relative; /* 將父元素設置為相對定位，以便子元素可以使用絕對定位 */
}

.divitem1 {
	float: right; /* 將元素向右浮動 */
	position: absolute; /* 將元素設置為絕對定位 */
	right: 0px; /* 將元素定位在右側，再些微調整差距 */
	top: 0; /* 將元素定位在頂部 */
	align-items: center;
	color: red;
	font-size: 2em;
	transition: color 0.5s ease;
}

.divitem1:hover {
	color: #F00078;
}

.divitem2 {
	float: right; /* 將元素向右浮動 */
	position: absolute; /* 將元素設置為絕對定位 */
	right: 40px; /* 將元素定位在右側，再些微調整差距 */
	top: 0; /* 將元素定位在頂部 */
	align-items: center;
	color: red;
	font-size: 2em;
	transition: color 0.5s ease;
}

.divitem2:hover {
	color: blue;
}

.divitem3 {
	float: right; /* 將元素向右浮動 */
	position: absolute; /* 將元素設置為絕對定位 */
	right: 80px; /* 將元素定位在右側，再些微調整差距 */
	top: 0; /* 將元素定位在頂部 */
	align-items: center;
	color: red;
	font-size: 2em;
	transition: color 0.5s ease;
}

.divitem3:hover {
	color: yellow;
}

.acontainer {
	position: relative; /* 將父元素設置為相對定位，以便子元素可以使用絕對定位 */
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
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}/">首頁</a></li>
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}/front/Forum/index">論壇</a></li>
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}/front/posts/getAll">貼文查詢</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">${post.name}</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->
	<div class="container text-center ">
		<div class="text-center mx-auto mb-5 wow fadeInUp"
			data-wow-delay="0.1s" style="max-width: 600px;">
			<h1 class="">貼文</h1>
			<p class="d-inline-block bg-secondary text-primary py-1 px-4">貼文</p>
		</div>
		<div class="wow fadeInUp" data-wow-delay="0.1s">
			<div class="row user-select-none" style="border: #FF0000 2px solid;">
				<div class="col-3" style="border: #FF0000 2px solid;">
					<img src="${contextRoot}/player/photo/${post.player.id}" />
					<p>作者: ${post.player.name}</p>
					<p>暱稱: ${post.player.nickname}</p>
					<p>位居縣市: ${post.player.county}</p>
				</div>
				<div class="col-9 text-start" style="border: #FF0000 2px solid;">
					<h1 class="text-center">貼文類型：${post.classify}</h1>
					<hr />
					<h1>${post.name}</h1>
					<!-- 這個內容為HTML可以直接輸入即可 -->
					${post.content}
				</div>
			</div>
		</div>
		<!-- 如果sessionScope中有'player'物件，執行以下內容 -->
		<c:if test="${not empty sessionScope.player}">
			<!-- 目的:浮動目標是沒辦法排定空間。 -->
			<!-- 輸入留言區塊 -->
			<div class="wow fadeInUp" data-wow-delay="0.4s">
				<div class="row" style="border: #FF0000 2px solid;">
					<div class="col-3" style="border: #FF0000 2px solid;">
						<img src="${contextRoot}/player/photo/${player.id}" />
						<p>作者: ${player.name}</p>
						<p>暱稱: ${player.nickname}</p>
						<p>位居縣市: ${player.county}</p>
					</div>
					<div class="col-9 card"
						style="background-color: black; border: #FF0000 2px solid;">
						<div class="card-header">
							<span>留言框</span>
						</div>
						<div class="card-body">
							<textarea id="myTextarea" class="form-control"
								style="background-color: black;" rows="9"></textarea>
							<button class="msg-btn btn btn-primary">送出</button>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		<!-- 留言開始 -->
		<div class="wow fadeInUp" data-wow-delay="0.6s">
			<div class="row" style="border: #FF0000 2px solid;">
				<h3>留言區</h3>
				<button class="msg-nonlogin-btn btn btn-primary">顯示更多留言</button>
			</div>
		</div>
		<div class="wow fadeInUp" data-wow-delay="0.6s">
			<div class="row" id="msg-block" style="border: #FF0000 2px solid;">

				<c:forEach items="${msgBlocks.content}" var="msgBlock">

					<div class="col-3 player-block"
						style="background-color: black; border: #FF0000 2px solid;">
						<img src="${contextRoot}/player/photo/${msgBlock.playerId}" />
						<p>作者: ${msgBlock.playerName}</p>
						<p>暱稱: ${msgBlock.playerNickname}</p>
						<p>位居縣市: ${msgBlock.playerCounty}</p>
					</div>
					<div class="col-9 card"
						style="background-color: black; border: #FF0000 2px solid;">
						<div class="card-header">
							<span>發文時間:${msgBlock.msgAdded}</span>
						</div>
						<div class="card-body">
							<p>${msgBlock.msgEssay}</p>
						</div>
					</div>

				</c:forEach>

				<br /> <br />
			</div>
		</div>
		<!-- 留言結束 -->
	</div>
	<jsp:include page="../../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../../Template/front/includedinbody.jsp"></jsp:include>
	<script src="${contextRoot}/js/ajax/posts/axios-post-message.js"></script>
	<script type="text/javascript">
		const playerId = ${sessionScope.player != null ? sessionScope.player.id : 0};
		const postId = ${requestScope.post.id}
	</script>
</body>
</html>