<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貼文查詢</title>
<jsp:include page="../../../Template/front/includedinhead.jsp"></jsp:include>
<style>
.a1{
	display: flex;
	justify-content: center;  
	
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
					<li class="breadcrumb-item text-primary active" aria-current="page">貼文查詢</li>
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
				<p class="d-inline-block bg-secondary text-primary py-1 px-4">貼文查詢</p>
				<h1 class="text-uppercase">貼文查詢</h1>
			</div>
			<!-- class="row" 橫向排列-->
			<div class="text-center mx-auto mb-5 wow fadeInUp">
				<!-- class="wow fadeInUp" 上浮顯現 -->
				<!-- data-wow-delay="0.1s" 設定延遲時間-->
				<!-- col-lg-4 col-md-6 Bootstrap分隔樣板 col為列分隔最大為12 lg:空間高於992px md:空間高於≥768px-->
				<div class=" wow fadeInUp" data-wow-delay="0.1s">
					<div class=" text-center ">
<!-- 						<div class="col-md-3" style="border: #FF0000 2px solid;"> -->
						<div>
							<form action="${contextRoot}/front/posts/search1" method="GET">
								<input type="text" id="myPosts" name="searchStr"/>
								<input type="submit" value="搜尋貼文" id="submitBtn" />
								
							</form>
							<button class="my-posts-data-btn" >秀資料</button>
							<div class="output">
							</div>
						</div>
						<br/>
						<div class="row">
							
							<div  class="a1">
								<table id="list_table_json" class="table table-hover table-bordered">
									<thead>
										<tr>
											<th>貼文名稱</th>
											<th>作者/小名</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${postsList}" var="post"> 
	
											<tr>
												<td>[${post.classify}] ${post.name}</td>
												<td>${post.player.name} / ${post.player.nickname}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								
							</div>
						
						</div>
						
<!-- 						</div> -->
<!-- 						<div class="col-md-9" style="border: #FF0000 2px solid;"> -->
<%-- 							<form:form action="${contextRoot}/front/posts/create" --%>
<!-- 								modelAttribute="postsBean" method="post"> -->
<%-- 								<form:input path="player" type="hidden" value="${player.id}"/> --%> 
<!-- 								<label for="inputName">請輸入標題:</label> -->
<!-- 								<form:input class="form-control" id="inputName" path="name" /> -->
<!-- 								<br /> -->
<!-- 								<label for="inputClassify">請輸入分類:</label> -->
<!-- 								<form:select class="form-control" id="inputClassify" -->
<!-- 									path="classify"> -->
<!-- 									<form:option value="none" selected="true" disabled="true" -->
<!-- 										hidden="true">請選擇選項</form:option> -->
<!-- 									<form:option value="活動">活動</form:option> -->
<!-- 									<form:option value="心得">心得</form:option> -->
<!-- 									<form:option value="問題">問題</form:option> -->
<!-- 									<form:option value="閒聊">閒聊</form:option> -->
<!-- 									<form:option value="討論">討論</form:option> -->
<!-- 								</form:select> -->

<!-- 								<br /> -->
<!-- 								<label for="inputEssay">請輸入內容:</label> -->
<!-- 								<form:textarea id="ckeditor" path="content" class="form-control" /> -->
<!-- 								<br /> -->
<!-- 								<div class="row "> -->
<!-- 									<div class="col-3"></div> -->
<!-- 									<div class="col"> -->
<!-- 										<button type="submit" class="btn btn-outline-primary">送出</button> -->
<!-- 									</div> -->
<!-- 									<div class="col"> -->
<!-- 										<button type="button" id="toForum" -->
<!-- 											class="btn btn-outline-primary">取消</button> -->
<!-- 									</div> -->
<!-- 									<div class="col-3"></div> -->
<!-- 								</div> -->
<!-- 							</form:form> -->
<!-- 						</div> -->
					</div>
				</div>


			</div>
		</div>
	</div>
	<!-- Service End -->
	<script src="${contextRoot}/js/jquery-3.6.3.min.js" type="text/javascript"></script>
	<script src="${contextRoot}/js/ajax/posts/ajax-message.js" type="text/javascript"></script>
	
	<jsp:include page="../../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../../Template/front/includedinbody.jsp"></jsp:include>
</body>
</html>