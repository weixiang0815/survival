<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">

<head>
<meta charset="UTF-8">
<title>新增使用者</title>
</head>

<body>
	<jsp:include page="../../Template/admin.jsp" />
	<h3>新增使用者</h3>
	<form:form action="${contextRoot}/player/addpost"
		enctype="multipart/form-data" modelAttribute="player">
		<table>
			<tr>
			<tr>
				<td>使用者名稱：</td>
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
				<td>暱稱：</td>
				<td><form:input type="text" path="nickname" /></td>
			</tr>
			<tr>
				<td>性別：</td>
				<td><form:radiobutton path="sex" value="M" label="男" /> <form:radiobutton
						path="sex" value="F" label="女" /></td>
			</tr>
			<tr>
				<td>縣市:</td>
				<td class="twzipcode"><form:select data-role="county"
						name="county" path="county">
						<option data-value="county">縣市</option>
					</form:select> <form:select data-role="district" name="district" path="district">
						<option data-value="district">鄉鎮市區</option>
					</form:select> <input type="text" data-role="zipcode" placeholder="郵遞區號"
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
				<td>圖片:</td>
				<td><form:input type="file" path="playerImage" />
			</tr>
			<tr>
				<td>個人身分證：</td>
				<td><form:input type="text" path="identity_number" /></td>
			</tr>
			<tr>
				<td>電話：</td>
				<td><form:input type="text" path="phone" /></td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><form:input type="date" path="birthday" /></td>
			</tr>
			<tr>
				<td><form:input type="hidden" path="banned" /></td>
			</tr>
			<tr>
				<td>個人介紹：</td>
				<td><input type="hidden" name="info" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="註冊" /></td>
			</tr>

		</table>
	</form:form>
	<jsp:include page="../../Layout/footer.jsp" />
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="${contextRoot}/js/twzipcode.js"></script>
	<script>
		const twzipcode = new TWzipcode();
		const county = $("select[data-role='county']");
		const district = $("select[data-role='district']");
		const zipcode = $("input[data-role='zipcode']");
		county.val();
	</script>

</body>

</html>