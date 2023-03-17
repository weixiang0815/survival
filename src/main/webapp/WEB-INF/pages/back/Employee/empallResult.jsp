<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
<style type="text/css">
img {
	max-width: 100%;
}
</style>
</head>
<jsp:include page="../../Template/admin.jsp" />
<h3>職員所有資料</h3>
<body>
	<table class="table table-hover">
		<tr>
			<th>職員頭像</th>
			<th>職員名稱:</th>
			<th>職員年齡:</th>
			<th>職員身分證</th>
			<th>職員地址:</th>
			<th>職員性別:</th>
			<th>職員信箱:</th>
			<th>職員職稱：</th>
			<th>職員入職日期：</th>
		</tr>
		<c:forEach items="${Employee}" var="employee">
			<tr>
				<td style="width: 100px;"><img alt="查無圖片"
					src="${contextRoot}/Employee/photo/${employee.id}" /></td>			
				<td>${employee.name}</td>
				<td>${employee.age}</td>
				<td>${employee.identity_number}</td>
				<td><label>${employee.county}</label><label>${employee.district}</label><label>${employee.address}</label></td>
				<td><c:choose>
						<c:when test="${employee.sex.equals(\"M\")}">男</c:when>
						<c:otherwise>女</c:otherwise>
					</c:choose></td>
				<td><span><fmt:formatDate pattern="yyyy-MM-dd"
							value="${employee.birthday}" /></span></td>
				<td>${employee.email}</td>
				<td>${employee.title}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd"
						value="${employee.hired_date}" /></td>
				<td><a href="${contextRoot}/Employee/update/?id=${employee.id}"><button
							class="btn btn-info">編輯</button></a>
					<form action="${contextRoot}/Employee/delete" method="post">
						<input name="_method" type="hidden" value="delete" /> <input
							name="id" type="hidden" value="${employee.id}" /> <input
							type="submit" class="btn btn-danger" value="刪除" />
					</form>
			</tr>
		</c:forEach>
	</table>
</body>
</html>