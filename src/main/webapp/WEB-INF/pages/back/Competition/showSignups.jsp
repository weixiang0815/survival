<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>報名資訊搜尋結果</title>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.2/css/jquery.dataTables.min.css">
</head>
<body>
<%-- 	<jsp:include page="../Layout/navbar_competition.jsp" /> --%>
<jsp:include page="../../Template/admin.jsp" />
	<div class="container">
		<h1>報名資訊搜尋結果</h1>
		<table class="table table-hover table-bordered table-dark"
			id="compTable">
			<thead>
				<tr>
					<th>報名者</th>
					<th>活動</th>
					<th>報名時間</th>
					<th>活動開始時間</th>
					<th>活動結束時間</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${signupList}" var="signup">
					<tr>
						<td>${signup.player.name}</td>
						<td><a
							style="text-decoration: none; color: white; font-weight: bolder;"
							href="${contextRoot}/competition/detail?id=${signup.competition.id}">
								${signup.competition.mandarinName}</a></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss a EEEE"
								value="${signup.signUpDate}" /></td>
						<td>${signup.competition.startDate}</td>
						<td>${signup.competition.endDate}</td>
						<td><a
							href="${contextRoot}/competition/signup/edit?id=${signup.id}"><button
									class="btn btn-primary">編輯</button></a></td>
						<td><a
							href="${contextRoot}/competition/signup/delete?id=${signup.id}"><button
									class="btn btn-danger">刪除</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.datatables.net/1.13.2/js/jquery.dataTables.min.js"></script>
	<script>
		$(document)
				.ready(
						function() {
							var table = $('#compTable')
									.DataTable(
											{
												"pagingType" : "full_numbers",
												language : {
													url : 'https://cdn.datatables.net/plug-ins/1.13.2/i18n/zh-HANT.json'
												}
											});
							$('#page-length-select').on('change', function() {
								table.page.len(this.value).draw();
							});
						});
	</script>
	<%-- <jsp:include page="../Layout/footer.jsp" /> --%>
</body>
</html>