<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>檔案上傳</title>
</head>
<body>
<jsp:include page="../Layout/navbar_user.jsp"/>

<form action="upload.controller" method="post" enctype="multipart/form-data">
請上傳一張圖片：<input type="file" name="myFiles" /><br/>
<input type="submit" value="上傳" />
</form>
<jsp:include page="../Layout/footer.jsp"/>
</body>
</html>