<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>報名結果</title>
<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>
	<!-- Page Header Start -->
	<div class="container-fluid page-header py-5 mb-5 wow fadeIn"
		data-wow-delay="0.1s">
		<div class="container text-center py-5">
			<h1
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">報名結果</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}">首頁</a></li>
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}/front/competition">活動</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">報名結果</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->
	<div class="container">
		<c:choose>
			<c:when test="${signup == null || empty signup}">
				<div class="row text-center">
					<h1>報名失敗</h1>
					<h4>非常抱歉，您選擇的活動目前無法報名</h4>
					<h4>要不要改選其它活動呢？</h4>
				</div>
				<div class="row m-5">
					<div class="col-6 text-end">
						<form action="${contextRoot}/front/signup" method="get">
							<input title="回到報名頁面" type="submit" class="btn btn-primary"
								value="好的">
						</form>
					</div>
					<div class="col-6 text-start">
						<form action="${contextRoot}" method="get">
							<input title="回到首頁" type="submit" class="btn btn-primary"
								value="不用謝謝">
						</form>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="row text-center">
					<h1>報名成功</h1>
					<h4>報名明細</h4>
				</div>
				<div class="row text-center">
					<div class="col-3"></div>
					<div class="col-6">
						<table id="receipt"
							class="table table-dark table-hover table-striped table-bordered">
							<tr>
								<th>會員姓名</th>
								<td>${player.name}</td>
							</tr>
							<tr>
								<th>活動名稱</th>
								<td>${comp.mandarinName}</td>
							</tr>
							<tr>
								<th>活動時間</th>
								<td>${startDate}～${endDate}</td>
							</tr>
							<tr>
								<th>報名時間</th>
								<td><fmt:formatDate pattern="yyyy 年 MM 月 dd 日 EEEE a hh:mm:ss"
										value="${signup.signUpDate}" /></td>
							</tr>
							<tr>
								<th>報名費用</th>
								<td>${comp.fee}</td>
							</tr>
							<tr>
								<th>報名狀態</th>
								<td>${signup.status}</td>
							</tr>
							<tr>
                                <th>備註訊息</th>
								<td><c:choose>
										<c:when test="${signup.status.equals(\"已繳費\")}">
											記得到電子信箱收取電子發票 PDF 喔！
										</c:when>
										<c:when test="${signup.status.equals(\"未繳費\")}">
											記得在期限內繳納報名費用 ${comp.fee} 元喔！
										</c:when>
									</c:choose></td>
							</tr>
						</table>
					</div>
					<div class="col-3"></div>
				</div>
				<div class="row text-center">
					<h4>要不要繼續報名其它活動呢？</h4>
				</div>
				<div class="row m-5">
					<div class="col-6 text-end">
						<form action="${contextRoot}/front/competition/show" method="get">
							<input title="查看其它活動" type="submit" class="btn btn-primary"
								value="好的" />
						</form>
					</div>
					<div class="col-6 text-start">
						<form action="${contextRoot}" method="get">
							<input title="回到首頁" type="submit" class="btn btn-primary"
								value="不用謝謝" />
						</form>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
	<script>
        $("document").ready(() => {
            $("th").addClass("text-end");
            $("td").addClass("text-start");
        });
    </script>
</body>
</html>