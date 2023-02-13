<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<c:forEach items="${Emploee}" var="employee">
					<tr>
						<th>職員ID：</th><th><label>${employee.id}</label></th>
						<th>職員名稱:</th><th>${emploee.name}</th>
						<th>職員帳號:</th><th>${emploee.account}</th>
						<th>職員密碼:</th><th>${emploee.password}</th>
						<th>職員年齡:</th><th>${emploee.age}</th>
						<th>職員地址:</th><th><label>${emploee.region}</label><label>${emploee.address}</label></th>
						<th>職員性別:</th><th>${emploee.sex}</th>
						<th>職員生日:</th><th>${emploee.birthday}</th>
						<th>職員薪水:</th><th>${emploee.salary}</th>
						<th>職員狀態:</th><th>${emploee.status}</th>
						<th>職員信箱:</th><th>${emploee.email}</th>
						<th>職員職稱：</th><th>${employee.title}</th>
						<th>職員入職：</th><th>${employee.hired_date}</th>

							<!-- <td><label>職員工作地點：</label>${employee.fk_workplace_id}
				<td><label>上司：</label>${employee.fk_supervisor_id}				 -->
				</c:forEach>
			</table>
			<a href="searchmain.controller"><button>回到搜尋頁</button></a>
		</body>

		</html>