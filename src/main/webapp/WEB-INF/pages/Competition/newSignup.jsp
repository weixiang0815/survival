<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>報名頁面</title>
</head>
<body>
	<jsp:include page="../Layout/navbar_competition.jsp" />
	<div class="container pt-3 pb-3">
		<div class="row justify-content-center">
			<div class="col-10 col-md-6 col-lg-8"
				style="border: 2px solid red; border-radius: 5px;">
				<h1>報名頁面</h1>
				<span>${error}</span>
				<c:choose>
					<c:when test="${player == null}">
						<h1>請先登入再報名活動呦😊～</h1>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
				<form:form action="${contextRoot}/competition/signup/create"
					modelAttribute="signup">
					<div class="input-group">
						<fieldset class="row mt-3 mb-3 p-3">
							<legend>請選一個活動</legend>
							<div class="col-12">
<%-- 								<form:label path="competitionId" class="form-label">活動</form:label> --%>
								<form:select title="選擇一個活動" class="form-select"
									path="competitionId" id="placeId">
									<c:forEach items="${compList}" var="comp">
										<form:option value="${comp.id}">${comp.mandarinName}（${comp.englishName}）
										競賽模式：
										<c:choose>
												<c:when test="${comp.singleOrCrew == \"S\"}">個人戰</c:when>
												<c:when test="${comp.singleOrCrew == \"C\"}">團體戰</c:when>
												<c:otherwise>未定</c:otherwise>
											</c:choose>
										；報名費&nbsp;${comp.fee}&nbsp;元
										</form:option>
									</c:forEach>
								</form:select>
							</div>
						</fieldset>
						<fieldset class="row mt-3 mb-3 p-3">
							<button class="col auto m-3 btn btn-primary" type="submit">報名</button>
						</fieldset>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<%-- <jsp:include page="../Layout/footer.jsp"/> --%>
</body>
</html>