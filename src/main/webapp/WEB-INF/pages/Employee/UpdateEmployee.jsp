<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>使用者修改資料</title>
<style type="text/css">
img {
max-width: 100%;
}
</style>
</head>
<body>
<jsp:include page="../Layout/navbar_user.jsp"/>
<h3>使用者修改資料</h3>
	<form:form action="${contextRoot}/Employee/update1" method="put" modelAttribute="Employee" enctype="multipart/form-data">
		<table class="table table-hover">
		    <tr>
				<td>大頭貼:</td>
				<td><input type="file" name="thumbnail" value="上傳圖片" />
			</tr>
			<tr>
				<td>ID：</td>
				<td><input type="text" name="id" value="${Employee.id}" /></td>
			</tr>
			<tr>
				<td>名稱：</td>
				<td><input type="text" name="name" value="${Employee.name}" /></td>
			</tr>
			<tr>
				<td>帳號：</td>
				<td><input type="text" name="account" value="${Employee.account}" /></td>
			</tr>
			<tr>
				<td>密碼：</td>
				<td><input type="password" name="password"
					value="${Employee.password}" /></td>
			</tr>
			<tr>
				<td>薪水：</td>
				<td><input type="text" name="salary" value="${Employee.salary}" /></td>
			</tr>
			<tr>
				<td>職稱：</td>
				<td><input type="text" name="title" value="${Employee.title}" /></td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><input type="text"  name="birthday" value="${Employee.birthday}" /></td>
			</tr>
			<tr>
				<td>就職日期：</td>
				<td><input type="text"  name="hired_date" value="${Employee.hired_date}" /></td>
			</tr>
			<tr>
				<td>性別：</td>
				<td>
				<c:choose>
				<c:when test="${Employee.sex == 'M'}">
					<input type="radio" name="sex" class="form-check-input"  value="M"   checked="checked"/><label>男</label>
					<input type="radio" name="sex" class="form-check-input"  value="F"   /><label>女</label>
				</c:when>
				<c:otherwise>
					<input type="radio" name="sex" class="form-check-input"  value="M"  /><label>男</label>
					<input type="radio" name="sex" class="form-check-input"  value="F"  checked="checked"/><label>女</label>
				</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>縣市：</td>
				<td><input type="text" name="region" value="${Employee.region}" /></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><input type="text" name="address" value="${Employee.address}" /></td>
			</tr>
			<tr>
				<td>Email：</td>
				<td><input type="text" name="email" value="${Employee.email}" /></td>
			</tr>
			<tr>
				<td>年齡：</td>
				<td><input type="text" name="age" value="${Employee.age}" /></td>
			</tr>
			<tr>
				<td>個人身分證：</td>
				<td><input type="text" name="identity" value="${Employee.identity_number}" /></td>
			</tr>
			<tr>
				<td>職員狀況：</td>
				<td><input type="text" name="status" value="在職中" /></td>
			</tr>
		</table>
		<input class="btn btn-outline-primary" type="submit"  value="更新"/>
	</form:form>
<jsp:include page="../Layout/footer.jsp"/>
</body>
</html>