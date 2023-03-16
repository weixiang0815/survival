<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<jsp:include page="../../Template/admin.jsp"/>
	<div class="container">
		<h3>使用者修改資料</h3>
		<form:form action="${contextRoot}/player/update1" method="put"
			modelAttribute="player" enctype="multipart/form-data">
			<table class="table table-hover">
				<tr>
					<td colspan="2"><img src="${contextRoot}/player/photo/${player.id}"></td>
				</tr>
				<tr>
					<td>大頭貼:</td>
					<td><form:input class="form-control" type="file"
							path="playerImage" />
				</tr>
				<tr>
					<td>ID：</td>
					<td><form:input class="form-control" path="id" /></td>
				</tr>
				<tr>
					<td>名稱：</td>
					<td><form:input class="form-control" path="name" /></td>
				</tr>
				<tr>
					<td>帳號：</td>
					<td><form:input class="form-control" path="account" /></td>
				</tr>
				<tr>
					<td>密碼：</td>
					<td><form:input class="form-control" type="password"
							path="password" /></td>
				</tr>
				<tr>
					<td>暱稱：</td>
					<td><form:input class="form-control" path="nickname" /></td>
				</tr>
				<tr>
					<td>生日：</td>
					<td><form:input class="form-control" path="birthday" /></td>
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
							<option data-value="county" >縣市</option>
						</form:select> 
						<form:select data-role="district"  path="district">
							<option data-value="district">鄉鎮市區</option>
						</form:select> 
						<input type="text" data-role="zipcode" placeholder="郵遞區號" name="zipcode"/>
					</td>
				</tr>
				<tr>
					<td>地址：</td>
					<td><form:input class="form-control" path="address" /></td>
				</tr>
				<tr>
					<td>電話：</td>
					<td><form:input class="form-control" path="phone" /></td>
				</tr>
				<tr>
					<td>Email：</td>
					<td><form:input class="form-control" path="email" /></td>
				</tr>
				<tr>
					<td>年齡：</td>
					<td><form:input class="form-control" path="age" /></td>
				</tr>
				<tr>
					<td>個人身分證：</td>
					<td><form:input class="form-control" path="identity_number" />
					</td>
				</tr>
				<tr>
					<td>個人介紹：</td>
					<td><input type="hidden" name="info" /></td>
				</tr>
			</table>
			<input class="btn btn-outline-primary" type="submit" value="更新" />
		</form:form>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="${contextRoot}/js/twzipcode.js"></script>
	<script type="text/javascript">
		const twzipcode = new TWzipcode();
		$(document).ready(function() {
			$.ajax({
				url: "${contextRoot}/player/get/${player.id}",
				method: "GET",
				success: function(res) {
					console.log(res);
					let county = res.county;
					let district = res.district;
					twzipcode.set({
						"county": county,
						"district": district,
					});
				},
				error: function(err) {
					console.log(err);
				}
			});
		});
		function confirmUpdate(id) {
			let result = confirm("確定送出此筆記錄(帳號:" + id.trim() + ")?");
			if (result) {
				document.forms[0].putOrDelete.name = "_method";
				document.forms[0].putOrDelete.value = "PUT";
				return true;
			}
			return false;
		}
	</script>
</body>

</html>