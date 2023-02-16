<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../Layout/navbar_user.jsp" />
<h3>新增職員</h3>
<form:form action="${contextRoot}/Employee/addEmployee"  enctype="multipart/form-data">
<table>
			<tr>
				<td>使用者名稱：</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>帳號：</td>
				<td><input type="text" name="account" /></td>
			</tr>
			<tr>
				<td>密碼：</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>職位：</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>性別：</td>
				<td><label>男:</label><input type="radio" name="sex" value="M" /><label>女:</label><input
					type="radio" name="sex" value="F" /></td>
			</tr>
			<tr>
				<td>縣市：</td>
				<td><input type="text" name="region" /></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Email：</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>年齡：</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>圖片:</td>
				<td><input type="file" name="thumbnail" />
			</tr>
			<tr>
				<td>個人身分證：</td>
				<td><input type="text" name="identity" /></td>
			</tr>
			<tr>
				<td>薪水：</td>
				<td><input type="text" name="salary" /></td>
			</tr>
			<tr>
				<td>電話：</td>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><input type="date" name="birthday" /></td>
			</tr>
			<tr>
				<td>入職時間：</td>
				<td><input type="date" name="hired_date" /></td>
			</tr>
				<tr>
				<td>個人狀況：</td>
				<td><input type="text" name="status" /></td>
			</tr>		
			<tr>
				<td><input type="submit" value="註冊" /></td>
			</tr>
		</table>


</form:form>
</body>
</html>