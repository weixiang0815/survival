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
a {
  color: red;
  transition: color 0.5s ease;
}

a:hover {
  color: white;
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
						</div>
						<br/>
						<div class="row">
							<div  class="a1">
								<table id="list_table_json" class="table table-hover table-bordered">
									<thead>
										<tr>
											<th>貼文名稱</th>
							
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${postsPage.content}" var="post"> 
	
											<tr>
												<td>[${post.classify}] <a href="${contextRoot}/front/posts/content?id=${post.id}">${post.name}</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
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
	
</body>
</html>