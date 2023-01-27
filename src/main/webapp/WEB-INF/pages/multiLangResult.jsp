<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>多國語言結果顯示</title>
</head>
<body>
	<p>
		<a href="resultMultilang.controller?locale=zh-TW">中文</a> <a
			href="resultMultilang.controller?locale=en-US">英文</a>
	</p>
	<spring:message code="program.error" />
</body>
</html>