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
	<jsp:include page="../Template/admin.jsp" />
	<h3>新增使用者</h3>
	<form:form action="${contextRoot}/player/addpost"
		enctype="multipart/form-data">
		<table>
			<tr>
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
				<td>暱稱：</td>
				<td><input type="text" name="nickname" /></td>
			</tr>
			<tr>
				<td>性別：</td>
				<td><label>男:</label><input type="radio" name="sex" value="M" /><label>女:</label><input
					type="radio" name="sex" value="F" /></td>
			</tr>
			<tr>
				<td>縣市:</td>
				<td class="twzipcode">
					<select data-role="county" name="county">
						<option value="">縣市</option>
					</select>
					<select data-role="district" name="district">
						<option value="">鄉鎮市區</option>
					</select>
					<input type="text" data-role="zipcode" placeholder="郵遞區號" name="zipcode" >
				</td>
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
				<td>電話：</td>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><input type="date" name="birthday" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="banned" /></td>
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
	<jsp:include page="../Layout/footer.jsp" />
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