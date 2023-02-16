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

		<body>
			<h1>Employee</h1>
			<table>
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
				<th>職員入職：</th>
				<c:forEach items="${Employees}" var="employee">
					<tr>

						<th>${employee.id}</th>

						<th>${employee.name}</th>

						<th>${employee.account}</th>

						<th>${employee.password}</th>

						<th>${employee.age}</th>
						
						<th>${employee.identity_number}</th>
						
						<th><label>${employee.region}</label><label>${employee.address}</label></th>

						<th>${employee.sex}</th>

						<th>${employee.birthday}</th>

						<th>${employee.salary}</th>

						<th>${employee.status}</th>

						<th>${employee.email}</th>

						<th>${employee.title}</th>
						
						<th>${employee.hired_date}</th>

						
					</tr>
				</c:forEach>
			</table>
			<a href="searchmain.controller"><button>回到搜尋頁</button></a>
		</body>

		</html>