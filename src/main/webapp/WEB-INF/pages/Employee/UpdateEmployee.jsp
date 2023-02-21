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
	<form:form action="${contextRoot}/Employee/update1" method="put" modelAttribute="Employee">
		<table class="table table-hover">
		    <tr>
				<td>大頭貼:</td>
				<td><form:input type="file" path="thumbnail" value="上傳圖片" />
			</tr>
			<tr>
				<td>ID：</td>
				<td><form:input type="text" path="id" value="${employee.id}" /></td>
			</tr>
			<tr>
				<td>名稱：</td>
				<td><form:input type="text" path="name" value="${eemployee.name}" /></td>
			</tr>
			<tr>
				<td>帳號：</td>
				<td><form:input type="text" path="account" value="${employee.account}" /></td>
			</tr>
			<tr>
				<td>密碼：</td>
				<td><form:input type="password" path="password"
					value="${employee.password}" /></td>
			</tr>
			<tr>
				<td>薪水：</td>
				<td><form:input type="text" path="salary" value="${employee.salary}" /></td>
			</tr>
			<tr>
				<td>職稱：</td>
				<td><form:input type="text" path="title" value="${employee.title}" /></td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><form:input type="text"  path="birthday" value="${employee.birthday}" /></td>
			</tr>
			<tr>
				<td>就職日期：</td>
				<td><form:input type="Date" pattern="yyyy-MM-dd" path="hired_date" value="${employee.hired_date}" /></td>
			</tr>
			<tr>
				<td>性別：</td>
				<td>
				<c:choose>
				<c:when test="${employee.sex == 'M'}">
					<form:radiobutton name="sex" class="form-check-input" path="sex" value="M" label="男" required="true" checked="checked"/>
					<form:radiobutton name="sex" class="form-check-input" path="sex" value="F" label="女" required="true" />
				</c:when>
				<c:otherwise>
					<form:radiobutton name="sex" class="form-check-input" path="sex" value="M" label="男" required="true"/>
					<form:radiobutton name="sex" class="form-check-input" path="sex" value="F" label="女" required="true" checked="checked"/>
				</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>縣市：</td>
				<td><form:input type="text" path="region" value="${employee.region}" /></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><form:input type="text" path="address" value="${employee.address}" /></td>
			</tr>
			<tr>
				<td>Email：</td>
				<td><form:input type="text" path="email" value="${employee.email}" /></td>
			</tr>
			<tr>
				<td>年齡：</td>
				<td><form:input type="text" path="age" value="${employee.age}" /></td>
			</tr>
			<tr>
				<td>個人身分證：</td>
				<td><form:input type="text" path="identity_number" value="${employee.identity_number}" /></td>
			</tr>
			<tr>
				<td>職員狀況：</td>
				<td><form:input type="text" path="status" value="在職中" /></td>
			</tr>
		</table>
		<input class="btn btn-outline-primary" type="submit"  value="更新"/>
	</form:form>
<jsp:include page="../Layout/footer.jsp"/>
</body>
</html>