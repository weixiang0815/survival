<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>報名資訊</title>
<jsp:include page="../../Template/front/includedinhead.jsp"></jsp:include>
<style>
#checkResult {
	color: red;
	font-weight: bolder;
}
</style>
</head>
<body>
	<jsp:include page="../../Template/front/navbar.jsp"></jsp:include>
	<!-- Page Header Start -->
	<div class="container-fluid page-header py-5 mb-5 wow fadeIn"
		data-wow-delay="0.1s">
		<div class="container text-center py-5">
			<h1
				class="display-3 text-white text-uppercase mb-3 animated slideInDown">報名資訊</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center text-uppercase mb-0">
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}">首頁</a></li>
					<li class="breadcrumb-item"><a class="text-white"
						href="${contextRoot}/front/competition">活動</a></li>
					<li class="breadcrumb-item text-primary active" aria-current="page">報名資訊</li>
				</ol>
			</nav>
		</div>
	</div>
	<!-- Page Header End -->

	<!-- 活動條款 modal -->
	<div class="modal fade user-select-none" id="exampleModal"
		tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog dmodal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text-dark" id="exampleModalLabel">活動條款</h5>
				</div>
				<div id="codeOfConduct" class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						onclick="javascript:history.back(-1);">回到上一頁</button>
					<button type="button" class="btn btn-primary" id="modal-yes"
						data-bs-dismiss="modal" disabled>下一步</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 報名表單 -->
	<div class="container text-white">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<form:form action="${contextRoot}/front/signup/new"
					modelAttribute="signup">
					<div class="input-group">
						<div class="d-flex flex-column">
							<fieldset class="mt-3 mb-3 p-3">
								<legend>一、會員基本資料</legend>
								<form:input hidden="true" path="playerId" value="${player.id}"
									required="true" />
                                <table class="table table-hover">
                                    <tr>
                                        <th class="text-end">名稱</th>
                                        <td>${player.name}</td>
                                    </tr>
                                    <tr>
                                        <th class="text-end">暱稱</th>
                                        <td>${player.nickname}</td>
                                    </tr>
                                    <tr>
                                        <th class="text-end">帳號</th>
                                        <td>${player.account}</td>
                                    </tr>
                                    <tr>
                                        <th class="text-end">Email</th>
                                        <td>${player.email}</td>
                                    </tr>
                                    <tr>
                                        <th class="text-end">手機</th>
                                        <td>${player.phone}</td>
                                    </tr>
                                </table>
							</fieldset>
							<fieldset class="mt-3 mb-3 p-3">
								<c:choose>
									<c:when test="${competition != null}">
										<legend>二、你選的活動</legend>
										<div class="col">
											<span id="checkResult"></span>
											<form:hidden path="competitionId" value="${competition.id}" />
											<div>
												${competition.mandarinName}（${competition.englishName}）；
												<c:choose>
													<c:when test="${competition.singleOrCrew == \" S\"}">個人戰
                                                                </c:when>
													<c:when test="${competition.singleOrCrew == \" C\"}">團體戰
                                                                </c:when>
													<c:otherwise>未定</c:otherwise>
												</c:choose>
												；報名費&nbsp;${competition.fee}&nbsp;元
											</div>
											<div>${startDate}${startTime}～${endDate}${endTime}</div>
										</div>
									</c:when>
									<c:otherwise>
										<legend>二、請選一個活動</legend>
										<div class="col">
											<span id="checkResult"></span>
											<form:select class="form-select" path="competitionId">
												<c:forEach items="${compList}" var="comp">
													<form:option value="${comp.id}">
                                                                    ${comp.mandarinName}（${comp.englishName}）；
                                                                    <c:choose>
															<c:when test="${comp.singleOrCrew == \" S\"}">
                                                                            個人戰
                                                                        </c:when>
															<c:when test="${comp.singleOrCrew == \" C\"}">
                                                                            團體戰
                                                                        </c:when>
															<c:otherwise>未定</c:otherwise>
														</c:choose>
                                                                    ；報名費&nbsp;${comp.fee}&nbsp;元
                                                                </form:option>
												</c:forEach>
											</form:select>
										</div>
									</c:otherwise>
								</c:choose>
							</fieldset>
							<fieldset class="mt-3 mb-3 p-3">
								<legend>三、是否直接繳費</legend>
								<div class="col-12">
									<form:radiobutton name="status" class="form-check-input"
										path="status" id="paid" value="已繳費" label="是" required="true" />
									<form:radiobutton name="status" class="form-check-input"
										path="status" id="notpaid" value="未繳費" label="否"
										required="true" />
								</div>
							</fieldset>
							<div class="mt-3 mb-3 p-3 text-end">
								<button id="thinkaboutit" class="m-3 btn btn-primary">再讓我想一下</button>
								<button id="submitBtn" class="m-3 btn btn-primary" type="submit">報名</button>
							</div>
						</div>
					</div>
				</form:form>
			</div>
			<div class="col-3"></div>
		</div>
	</div>
	<jsp:include page="../../Template/front/footer.jsp"></jsp:include>
	<jsp:include page="../../Template/front/includedinbody.jsp"></jsp:include>
	<script src="${contextRoot}/js/Competition/front/signup.js"></script>
</body>
</html>