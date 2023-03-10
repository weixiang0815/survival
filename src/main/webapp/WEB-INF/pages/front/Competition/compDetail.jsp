<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${comp.mandarinName}&nbsp;詳情</title>
<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>
	<!-- Page Header Start -->
	<div class="container-fluid page-header py-5 mb-5 wow fadeIn"
		data-wow-delay="0.1s">
		<div class="container text-center py-5">
			<h1
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">${comp.mandarinName}&nbsp;詳情</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}">首頁</a></li>
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}/front/competition">活動</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">活動詳情</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->
	<div class="container-xxl py-5 text-white">
		<div class="container">
			<div class="row g-5">
				<div class="col-lg-12 wow fadeIn text-center" data-wow-delay="0.1s">
					<h3>${startDate} ${startTime}～${endDate} ${endTime}</h3>
				</div>
				<div class="col-lg-6 wow fadeIn" data-wow-delay="0.1s">
					<div class="d-flex flex-column">
						<img class="img-fluid w-75 align-self-end"
							src="${contextRoot}/img/about.jpg" alt="">
						<div class="w-50 bg-secondary p-5" style="margin-top: -25%;">
							<h1 class="text-uppercase text-primary mb-3">$&nbsp;${comp.fee}</h1>
							<h2 class="text-uppercase mb-0">報名費</h2>
						</div>
					</div>
				</div>
				<div class="col-lg-6 wow fadeIn" data-wow-delay="0.5s">
					<p class="d-inline-block bg-secondary text-primary py-1 px-4">${comp.englishName}</p>
					<h1 class="text-uppercase mb-4">${comp.mandarinName}</h1>
					<div id="content" class="user-select-none"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="container text-white user-select-none">
		<div class="row mb-3">
			<div class="col-12">中文活動名稱：${comp.mandarinName}</div>
			<div class="col-12">英文活動名稱：${comp.englishName}</div>
			<div class="col-3">開始日期：${startDate}</div>
			<div class="col-3">開始時段：${startTime}</div>
			<div class="col-6"></div>
			<div class="col-3">結束日期：${endDate}</div>
			<div class="col-3">結束時段：${endTime}</div>
			<div class="col-6"></div>
			<div class="col-3">發布狀態：${comp.status}</div>
			<div class="col-3">
				競賽模式：
				<c:choose>
					<c:when test="${comp.singleOrCrew == \"C\"}">
	    					團體戰
	    				</c:when>
					<c:when test="${comp.singleOrCrew.equals(\"S\")}">
	    					單人戰
	    				</c:when>
					<c:otherwise>
	    					未定
	    				</c:otherwise>
				</c:choose>
			</div>
			<div class="col-6"></div>
			<div class="col-12">
				場地：
				<c:choose>
					<c:when test="${player != null && employee == null}">
                ${place.place_name}（費用/時段：${place.place_fee} 元，容納人數：${place.place_capacity} 人）
            </c:when>
					<c:when test="${player == null && employee != null}">
                ${place.place_name}（容納人數：${place.place_capacity} 人）
            </c:when>
					<c:otherwise>
                ${place.place_name}（費用/時段：${place.place_fee} 元，容納人數：${place.place_capacity} 人）
            </c:otherwise>
				</c:choose>
			</div>
			<div class="col-12">預計報名人數：${comp.capacity} 人</div>
			<div class="col-12">預算：${comp.budget} 元</div>
			<div class="col-12">報名費：${comp.fee} 元</div>
			<div class="col-12">
				<c:choose>
					<c:when test="${prizes == null}">
			尚未確定活動獎品：<a href="${contextRoot}/competition/prize/new?id=${comp.id}"><button
								class="btn btn-primary btn-sm">新增活動獎品</button></a>
					</c:when>
					<c:otherwise>
			活動獎品：<br>
						<ol>
							<c:if test="${prizes.firstPrize != null}">
								<li>冠軍獎品：${prizes.firstPrize.name}</li>
							</c:if>
							<c:if test="${prizes.secondPrize != null}">
								<li>亞軍獎品：${prizes.secondPrize.name}</li>
							</c:if>
							<c:if test="${prizes.thirdPrize != null}">
								<li>季軍獎品：${prizes.thirdPrize.name}</li>
							</c:if>
							<c:if test="${prizes.singlePrize != null}">
								<li>個人獎品：${prizes.singlePrize.name}</li>
							</c:if>
							<c:if test="${prizes.crewPrize != null}">
								<li>團體獎品：${prizes.crewPrize.name}</li>
							</c:if>
							<c:if test="${prizes.comfortPrize != null}">
								<li>安慰獎品：${prizes.comfortPrize.name}</li>
							</c:if>
						</ol>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="col-12">
				<c:choose>
					<c:when test="${pictures == null || pictures.size() == 0}">
			尚未上傳相簿
					</c:when>
					<c:otherwise>
			這次活動一共有 ${pictures.size()} 張照片呦～
			</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
	<script>
		$(document).ready(function () {
			$.ajax({
				url: "${contextRoot}/front/api/competition/get-comp/${comp.id}",
				method: "get",
				success: function(res) {
					let content = res.content;
					content.replace("<h1>", "<p>");
					content.replace("</h1>", "</p>");
					$("#content").html(res.content);
				},
				error: function(err) {
					console.log(err);
				}
			});
		});
	</script>
</body>
</html>