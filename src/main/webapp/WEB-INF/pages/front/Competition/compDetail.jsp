<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${comp.mandarinName}&nbsp;詳情</title>
	<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
	<style>
	#proImg {
		max-width: 300px;
		display: none;
		position: absolute;
		cursor: pointer;
	}
	.productImg {
		cursor: pointer;
	}
	#signupnow:hover {
		background-color: red;
		transition: 0.2s ease-in-out;
	}
	</style>
</head>
<body>
	<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>
	<!-- Page Header Start -->
	<div class="container-fluid page-header py-5 mb-5 wow fadeIn" data-wow-delay="0.1s">
		<div class="container text-center py-5">
			<h1 class="display-3 text-white text-uppercase mb-3 animated slideInDown">
				${comp.mandarinName}&nbsp;詳情</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white" href="${contextRoot}">首頁</a></li>
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
					<p class="d-inline-block bg-secondary text-primary py-1 px-4">
						<c:choose>
							<c:when test="${comp.singleOrCrew == \" C\"}">
								團體戰
							</c:when>
							<c:when test="${comp.singleOrCrew.equals(\" S\")}">
								單人戰
							</c:when>
							<c:otherwise>
								未定
							</c:otherwise>
						</c:choose>
					</p>
					<p>${startDate}${startTime}～${endDate}${endTime}</p>
				</div>
				<div class="col-lg-6 wow fadeIn" data-wow-delay="0.1s">
					<div class="d-flex flex-column">
						<img class="img-fluid w-75 align-self-end" src="${contextRoot}/img/about.jpg" alt="">
						<div class="w-50 bg-secondary p-5" style="margin-top: -25%;">
							<h1 class="text-uppercase text-primary mb-3">$&nbsp;${comp.fee}</h1>
							<a href="${contextRoot}/front/signup?id=${comp.id}"><h2 id="signupnow" class="text-uppercase mb-0">手刀報名</h2></a>
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
	<div class="container text-white user-select-none text-center">
		<div class="row mb-3">
			<div class="col-6">
				<p class="d-inline-block bg-secondary text-primary py-1 px-4">活動詳情</p>
				<table class="table table-dark table-hover table-striped table-bordered">
					<tr>
						<th>中文名稱</th>
						<td>${comp.mandarinName}</td>
					</tr>
					<tr>
						<th>英文名稱</th>
						<td>${comp.englishName}</td>
					</tr>
					<tr>
						<th>開始時間</th>
						<td>${startDate}${startTime}</td>
					</tr>
					<tr>
						<th>結束時間</th>
						<td>${endDate}${endTime}</td>
					</tr>
					<tr>
						<th>競賽模式</th>
						<td>
							<c:choose>
								<c:when test="${comp.singleOrCrew.equals(\" C\")}">
									團體戰
								</c:when>
								<c:when test="${comp.singleOrCrew.equals(\" S\")}">
									單人戰
								</c:when>
								<c:otherwise>
									未定
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>活動場地</th>
						<td>${place.place_name}</td>
					</tr>
					<tr>
						<th>預計人數</th>
						<td>${comp.capacity}人</td>
					</tr>
					<tr>
						<th>報名費用</th>
						<td>${comp.capacity}元</td>
					</tr>
				</table>
			</div>
			<div class="col-6">
				<c:choose>
					<c:when test="${prizes == null}">
							<p class="d-inline-block bg-secondary text-primary py-1 px-4">尚未確定活動獎品</p>
					</c:when>
					<c:otherwise>
						<p class="d-inline-block bg-secondary text-primary py-1 px-4">活動獎品</p>
						<div>
							<img id="proImg">
						</div>
						<table id="prizes" class="table table-dark table-hover table-striped table-bordered">
							<c:if test="${prizes.firstPrize != null}">
								<tr id="${prizes.firstPrize.id}" class="productImg">
									<th>冠軍獎品</th>
									<td>${prizes.firstPrize.name}</td>
								</tr>
							</c:if>
							<c:if test="${prizes.secondPrize != null}">
								<tr id="${prizes.secondPrize.id}" class="productImg">
									<th>亞軍獎品</th>
									<td>${prizes.secondPrize.name}</td>
								</tr>
							</c:if>
							<c:if test="${prizes.thirdPrize != null}">
								<tr id="${prizes.thirdPrize.id}" class="productImg">
									<th>季軍獎品</th>
									<td>${prizes.thirdPrize.name}</td>
								</tr>
							</c:if>
							<c:if test="${prizes.singlePrize != null}">
								<tr id="${prizes.singlePrize.id}" class="productImg">
									<th>單人獎品</th>
									<td>${prizes.singlePrize.name}</td>
								</tr>
							</c:if>
							<c:if test="${prizes.crewPrize != null}">
								<tr id="${prizes.crewPrize.id}" class="productImg">
									<th>團體獎品</th>
									<td>${prizes.crewPrize.name}</td>
								</tr>
							</c:if>
							<c:if test="${prizes.comfortPrize != null}">
								<tr id="${prizes.comfortPrize.id}" class="productImg">
									<th>安慰獎品</th>
									<td>${prizes.comfortPrize.name}</td>
								</tr>
							</c:if>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<div id="collection" class="container">
		<div class="row">
			<c:choose>
				<c:when test="${pictures == null || pictures.size() == 0}">
					<div class="col-12 text-center">
						<p class="d-inline-block bg-secondary text-primary py-1 px-4">尚未上傳相簿</p>
					</div>
				</c:when>
				<c:otherwise>
					<div class="col-12 text-center">
						<p class="d-inline-block bg-secondary text-primary py-1 px-4">活動相簿</p>
					</div>
					<c:forEach items="${pictures}" var="pic">
						<div class="col-6 p-1">
							<a href="${contextRoot}/front/api/competition/photo/${pic.id}" data-bs-toggle="tooltip"
								data-bs-title="Image ${pic.id}"> <img alt="Image ${pic.id}"
									src="${contextRoot}/front/api/competition/photo/${pic.id}">
							</a>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
	<script>
		const prodcutImg_pos = $(".productImg");
		const productImg = $("#proImg");
		const hideBtn = $("#hideBtn");
		const productImgURL = "${contextRoot}/Market/id?id="
		$(document).ready(function () {
			$.ajax({
				url: "${contextRoot}/front/api/competition/get-comp/${comp.id}",
				method: "get",
				success: function (res) {
					let content = res.content;
					content = content.replace("<h1>", "<p>");
					content = content.replace("</h1>", "</p>");
					$("#content").html(content);
				},
				error: function (err) {
					console.log(err);
				}
			});
			$("td").addClass("text-start");
			$("#prizes").children().attr("title", "點擊可顯示圖片");
			$.each(prodcutImg_pos, function(index, pic) {
				let id = pic.getAttribute("id");
				$(pic).on({
					click: function (e) {
						let text = $(this).children("th").text();
						let productName = $(this).children("td").text();
						let mouseX = e.pageX;
						let mouseY = e.pageY;
						$.ajax({
							url: productImgURL + id,
							success: function(res) {
								productImg.attr({
									"src": productImgURL + id,
									"title": text + "：" + productName
								});
								productImg.css("display", "block");
								productImg.css({
									left: mouseX,
									top: mouseY
								});
							},
							error: function(err) {
								console.log(err);
							}
						})
						productImg.on({
							click: () => {
								productImg.css("display", "none");
							}
						});
					}
				});
			});
		});
	</script>
</body>
</html>