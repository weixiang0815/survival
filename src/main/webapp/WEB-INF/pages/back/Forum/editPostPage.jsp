<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
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

<jsp:include page="../../Template/admin.jsp"/>
	<div class="container">
		<div class="col-10">
			<form:form modelAttribute="postsBean" method="POST">
				<input type="hidden" name="_method"  id='putOrDelete'   value="" >


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
			    <form:textarea id="ckeditor" path="content" class="form-control" />
			    <br/>
			    
<!-- 			    <button type="submit" >送出</button> -->
			    <input type='submit' class='btn btn-outline-primary' value='修改' name='updateBtn' onclick="return confirmUpdate('${postsBean.id}');">&nbsp; 	
				<input type='submit' class='btn btn-outline-danger' value='刪除' name='deleteBtn' onclick="return confirmDelete('${postsBean.id}');" >
						
			</form:form>
		</div>
		
	</div>
	<script src="${contextRoot}/js/CKEditor5/ckeditor.js"></script>
	<script src="${contextRoot}/js/CKEditor5/script.js"></script>
	<script type="text/javascript">
  function confirmDelete(id){
	  var result = confirm("確定刪除此筆記錄(帳號:" + id.trim() + ")?");
	  if (result) {
// 		  document.forms[0].putOrDelete.name = "_method";
		  document.forms[0].putOrDelete.value = "DELETE";
	      return true;
	  }
	  return false;
  }
  function confirmUpdate(id){
	  var result = confirm("確定送出此筆記錄(帳號:" + id.trim() + ")?");
	  if (result) {
// 		  document.forms[0].putOrDelete.name = "_method";
		  document.forms[0].putOrDelete.value = "PUT";
	      return true;
	  }
	  return false;
  }
</script>
	
</body>
</html>