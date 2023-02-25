<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
			<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
			<!DOCTYPE html>
			<html>
			<head>
				<meta charset="UTF-8">
				<title>Employee</title>
			</head>
			<jsp:include page="../Template/admin.jsp" />
			<h3>職員所有資料</h3>

			<body>
				<table class="table table-hover">
					<tr>
					    <th>職員頭像</th>
						<th>職員ID：</th>
						<th>職員名稱:</th>
						<th>職員帳號:</th>
						<th>職員密碼:</th>
						<th>職員年齡:</th>
						<th>職員身分證</th>
						<th>職員地址:</th>
						<th>職員性別:</th>
						<th>職員生日:</th>
						<th>職員薪水:</th>
						<th>職員狀態:</th>
						<th>職員信箱:</th>
						<th>職員職稱：</th>
						<th>職員入職日期：</th>
						</tr>
						<c:forEach items="${Employee}" var="employee">
						<tr>
						 <td style="width: 100px;"><img alt="查無圖片" src="${contextRoot}/Employee/photo?id=${employee.id}"/></td>
							<td>${employee.id}</td>
							<td>${employee.name}</td>
							<td>${employee.account}</td>
							<td>${employee.password}</td>
							<td>${employee.age}</td>						
							<td>${employee.identity_number}</td>
						<td><label>${employee.region}</label><label>${employee.address}</label></td>
							<td>
								<c:choose>
									<c:when test="${employee.sex == \" M\"}">男</c:when>
									<c:otherwise>女</c:otherwise>
								</c:choose>
							</td>
							<td><span><fmt:formatDate pattern="yyyy-MM-dd" value="${employee.birthday}"/></span></td>
							
							<td>${employee.salary}</td>
							<td>${employee.status}</td>
							<td>${employee.email}</td>
							<td>${employee.title}</td>
							<td>
							<fmt:formatDate pattern="yyyy-MM-dd" value="${employee.hired_date}"/></td>
							<td><a href="${contextRoot}/Employee/update/?id=${employee.id}"><button
										class="btn btn-info">編輯</button></a>
								<form action="${contextRoot}/Employee/delete" method="post">
									<input name="_method" type="hidden" value="delete" />
									<input name="id" type="hidden" value="${employee.id}" />
									<input type="submit" class="btn btn-danger" value="刪除" />
								</form>
					</tr>
					</c:forEach>
				</table>
				<a href="searchmain.controller"><button>回到搜尋頁</button></a>
			</body>

			</html>