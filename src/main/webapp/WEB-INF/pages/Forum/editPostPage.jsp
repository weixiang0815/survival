<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>貼文發佈</title>
</head>
<body>

<jsp:include page="../Template/admin.jsp"/>
	<div class="container">
		<div class="col-10">
			<form:form action="${contextRoot}/post/edit" modelAttribute="editPost" method="PUT">
				<form:input type="hidden" path="id"/>
				<form:input  type="hidden" path="added"/>
				<label for="inputName">請輸入標題:</label>
			    <form:input class="form-control" id="inputName" path="name"/>
			    <br/>
			    <label for="inputClassify">請輸入分類:</label>
			    <form:select class="form-control" id="inputClassify" path="classify">
			    	<form:option value="活動">活動</form:option>
			    	<form:option value="心得">心得</form:option>
			    	<form:option value="問題">問題</form:option>
			    	<form:option value="閒聊">閒聊</form:option>
			    	<form:option value="討論">討論</form:option>
			    </form:select>
	
			    <br/>
			    <label for="inputEssay">請輸入內容:</label>
			    <form:textarea id="ckeditor" path="essay" class="form-control" />
			    <br/>
			    
			    <button type="submit" class="btn btn-outline-primary">送出</button>
			    
			</form:form>
		</div>
		
	</div>
	<script src="${contextRoot}/js/CKEditor5/ckeditor.js"></script>
	<script src="${contextRoot}/js/CKEditor5/script.js"></script>
</body>
</html>