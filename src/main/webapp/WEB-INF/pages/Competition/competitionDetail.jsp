<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>活動詳情</title>
<style>
button {
	margin-left: 5px;
	margin-right: 5px;
}
</style>
</head>
<body>
<%-- 	<jsp:include page="../Layout/navbar_competition.jsp" /> --%>
<jsp:include page="../Template/admin.jsp" />
	<div class="container">
		<h1>活動詳情</h1>
		<div class="row mt-3 mb-3 p-3">
			<div class="col-12">中文活動名稱：${comp.mandarinName}</div>
			<div class="col-12">英文活動名稱：${comp.englishName}</div>
			<div class="col-3">開始日期：${comp.startDate}</div>
			<div class="col-3">開始時段：${start}</div>
			<div class="col-6"></div>
			<div class="col-3">結束日期：${comp.endDate}</div>
			<div class="col-3">結束時段：${end}</div>
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
			<div class="col-12">內容：${comp.content}</div>
			<div class="col-12 align-text-start">
				<a href="${contextRoot}/competition/edit?id=${comp.id}"><button
						class="btn btn-primary">編輯</button></a> <a
					href="${contextRoot}/competition/delete?id=${comp.id}"><button
						class="btn btn-danger">刪除</button></a>
			</div>
		</div>
	</div>
	<%-- <jsp:include page="../Layout/footer.jsp"/> --%>
</body>
</html>