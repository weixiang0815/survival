<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>各類使用條款</title>
<jsp:include page="../Template/front/includedinhead.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../Template/front/navbar.jsp"></jsp:include>
	<!-- Page Header Start -->
	<div class="container-fluid page-header py-5 mb-5 wow fadeIn"
		data-wow-delay="0.1s">
		<div class="container text-center py-5">
			<h1
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">各類使用條款</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}">首頁</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">各類使用條款</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->

	<!-- Code of Conduct Start -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center mx-auto mb-5 wow fadeInUp"
				data-wow-delay="0.1s" style="max-width: 600px;">
				<p class="d-inline-block bg-secondary text-primary py-1 px-4">使用條款</p>
				<h1 class="text-uppercase">參閱各項使用條款</h1>
			</div>
			<div class="row g-4">
				<div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
					<div class="team-item">
						<div class="team-img position-relative overflow-hidden">
							<img class="img-fluid" src="${contextRoot}/img/team-1.jpg" alt="">
							<div class="team-social">
								<button id="company"
									class="btn btn-primary btn-terms" data-bs-toggle="modal"
									data-bs-target="#terms-modal">檢視</button>
							</div>
						</div>
						<div class="bg-secondary text-center p-4">
							<h5 class="text-uppercase">公司權利</h5>
							<span class="text-primary">參閱詳細內文</span>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
					<div class="team-item">
						<div class="team-img position-relative overflow-hidden">
							<img class="img-fluid" src="${contextRoot}/img/team-2.jpg" alt="">
							<div class="team-social">
								<button id="disclaimer"
									class="btn btn-primary btn-terms" data-bs-toggle="modal"
									data-bs-target="#terms-modal">檢視</button>
							</div>
						</div>
						<div class="bg-secondary text-center p-4">
							<h5 class="text-uppercase">免責條款</h5>
							<span class="text-primary">參閱詳細內文</span>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
					<div class="team-item">
						<div class="team-img position-relative overflow-hidden">
							<img class="img-fluid" src="${contextRoot}/img/team-3.jpg" alt="">
							<div class="team-social">
								<button id="user"
									class="btn btn-primary btn-terms" data-bs-toggle="modal"
									data-bs-target="#terms-modal">檢視</button>
							</div>
						</div>
						<div class="bg-secondary text-center p-4">
							<h5 class="text-uppercase">使用條款</h5>
							<span class="text-primary">參閱詳細內文</span>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.7s">
					<div class="team-item">
						<div class="team-img position-relative overflow-hidden">
							<img class="img-fluid" src="${contextRoot}/img/team-4.jpg" alt="">
							<div class="team-social">
								<button id="rent"
									class="btn btn-primary btn-terms" data-bs-toggle="modal"
									data-bs-target="#terms-modal">檢視</button>
							</div>
						</div>
						<div class="bg-secondary text-center p-4">
							<h5 class="text-uppercase">場地租借條款</h5>
							<span class="text-primary">參閱詳細內文</span>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.7s">
					<div class="team-item">
						<div class="team-img position-relative overflow-hidden">
							<img class="img-fluid" src="${contextRoot}/img/team-4.jpg" alt="">
							<div class="team-social">
								<button id="privacy"
									class="btn btn-primary btn-terms" data-bs-toggle="modal"
									data-bs-target="#terms-modal">檢視</button>
							</div>
						</div>
						<div class="bg-secondary text-center p-4">
							<h5 class="text-uppercase">隱私權條款</h5>
							<span class="text-primary">參閱詳細內文</span>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
					<div class="team-item">
						<div class="team-img position-relative overflow-hidden">
							<img class="img-fluid" src="${contextRoot}/img/team-3.jpg" alt="">
							<div class="team-social">
								<button id="signup"
									class="btn btn-primary btn-terms" data-bs-toggle="modal"
									data-bs-target="#terms-modal">檢視</button>
							</div>
						</div>
						<div class="bg-secondary text-center p-4">
							<h5 class="text-uppercase">活動條款</h5>
							<span class="text-primary">參閱詳細內文</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Code of Conduct End -->

	<!-- Scrollable modal -->
	<div class="modal fade" id="terms-modal" tabindex="-1"
		aria-labelledby="terms-title" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h1 style="color: black;" class="modal-title fs-5" id="terms-title">Modal
						title</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">關閉</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../Template/front/includedinbody.jsp"></jsp:include>
	<script>
		const url = "http://localhost:8080/Survival/front/api/getTerms/";
		const termsContent = $(".modal-body");
		const termsTitle = $("#terms-title");
		$(".btn-terms").on({
			click : function() {
				let type = $(this).attr("id");
				$.ajax({
					url : url + type,
					method : "GET",
					success : function(res) {
						termsContent.html(res);
						let title;
						switch(type) {
							case "company":
								title = "公司權利";
								break;
							case "disclaimer":
								title = "免責條款";
								break;
							case "user":
								title = "使用條款";
								break;
							case "rent":
								title = "場地租借條款";
								break;
							case "privacy":
								title = "隱私權條款";
								break;
							case "signup":
								title = "活動條款";
								break;
							default:
								title = "錯誤存取";
								break;
						}
						termsTitle.text(title);
					},
					error : function(err) {
						console.log(err);
					}
				});
			},
		});
	</script>
</body>
</html>