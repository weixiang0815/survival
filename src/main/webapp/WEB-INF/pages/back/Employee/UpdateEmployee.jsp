<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<jsp:include page="../../Template/admin.jsp" />
	<h3>使用者修改資料</h3>
	<form:form action="${contextRoot}/Employee/update1" method="put"
		modelAttribute="Employee" enctype="multipart/form-data">
		<table class="table table-hover">
			<tr>
				<td colspan="2"><img
					src="${contextRoot}/Employee/photo/${Employee.id}"></td>
			</tr>
			<tr>
				<td>大頭貼:</td>
				<td><form:input type="file" path="employeeImage" value="上傳圖片" />
			</tr>
			<tr>
				<td>ID：</td>
				<td><form:input type="text" path="id" /></td>
			</tr>
			<tr>
				<td>名稱：</td>
				<td><form:input type="text" path="name" /></td>
			</tr>
			<tr>
				<td>帳號：</td>
				<td><form:input type="text" path="account" /></td>
			</tr>
			<tr>
				<td>密碼：</td>
				<td><form:input type="password" path="password" /></td>
			</tr>
			<tr>
				<td>薪水：</td>
				<td><form:input type="text" path="salary" /></td>
			</tr>
			<tr>
				<td>職稱：</td>
				<td><form:input type="text" path="title" /></td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><form:input type="text" path="birthday" /></td>
			</tr>
			<tr>
				<td>就職日期：</td>
				<td><form:input type="text" path="hired_date" /></td>
			</tr>
			<tr>
				<td>性別：</td>
				<td><form:radiobutton name="sex" id="male" path="sex"
						class="form-check-input" value="M" label="男" /> <form:radiobutton
						name="sex" id="female" path="sex" class="form-check-input"
						value="F" label="女" /></td>
			</tr>
			<tr>
				<td>縣市:</td>
				<td class="twzipcode">
				<form:select data-role="county" path="county">
						<option data-value="county">縣市</option>
					</form:select> 
					<form:select data-role="district" path="district">
						<option data-value="district">鄉鎮市區</option>
					</form:select> 
					<input type="text" data-role="zipcode" placeholder="郵遞區號"
					name="zipcode"></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><form:input type="text" path="address" /></td>
			</tr>
			<tr>
				<td>Email：</td>
				<td><form:input type="text" path="email" /></td>
			</tr>
			<tr>
				<td>年齡：</td>
				<td><form:input type="text" path="age" /></td>
			</tr>
			<tr>
				<td>個人身分證：</td>
				<td><form:input type="text" path="identity_number" /></td>
			</tr>
			<tr>
				<td>職員狀況：</td>
				<td><form:input type="text" path="status" value="在職中" /></td>
			</tr>
		</table>
		<input class="btn btn-outline-primary" type="submit" value="更新" />
	</form:form>
	<jsp:include page="../../Layout/footer.jsp" />
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="${contextRoot}/js/twzipcode.js"></script>
	<script type="text/javascript">
		const twzipcode = new TWzipcode();
		$(document).ready(function() {
			$.ajax({
				url : "${contextRoot}/Employee/get/${Employee.id}",
				method : "GET",
				success : function(res) {
					console.log(res);
					let county = res.county;
					let district = res.district;
					twzipcode.set({
						"county" : county,
						"district" : district,
					});
				},
				error : function(err) {
					console.log(err);
				}
			});
		});
	</script>
</body>
</html>