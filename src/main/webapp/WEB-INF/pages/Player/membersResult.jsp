<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>成功</title>
<script type="text/javascript">
	function confirmDelete(name, id) {
		var result = confirm("確定刪除此筆記錄(姓名：" + name.trim() + ", 帳號：" + id + ")?");
		if (result) {
			document.forms[0].putOrDelete.name = "_method";
			document.forms[0].putOrDelete.value = "DELETE";
			return true;
		}
		return false;
	}
	function confirmUpdate(id) {
		var result = confirm("確定送出此筆記錄(帳號:" + id.trim() + ")?");
		if (result) {
			 		  document.forms[0].putOrDelete.name = "_method";
			 		  document.forms[0].putOrDelete.value = "PUT";
			return true;
		}
		return false;
	}
</script>
</head>
<body>
<jsp:include page="../Layout/navbar_user.jsp"/>
	<h3>會員資訊</h3>
	<table>
		<tr>
			<td>會員名稱</td>
			<td>${memberName}</td>
		</tr>
		<tr>
			<td>性別</td>
			<td>${gender}</td>
		</tr>
		<tr>
			<td>年齡</td>
			<td>${age}</td>
		</tr>
	</table>
<jsp:include page="../Layout/footer.jsp"/>
</body>
</html>