<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>場地表</title>
</head>
<body>
<jsp:include page="../../Template/admin.jsp"></jsp:include>

<div class="container">
<h1>新增場地</h1>
<form action="" id="ajaxForm">
		<table>
			<tr>
				<td>場地名稱：</td>
				<td><input type="text" name="place_name" /></td>
			</tr>
			<tr>
				<td>場地地址：</td>
				<td><input type="text" name="place_address" /></td>
			</tr>
			<tr>
				<td>容納人口數：</td>
				<td><input type="text" name="place_capacity" /></td>
			</tr>
			<tr>
				<td>費用/時段：</td>
				<td><input type="text" name="place_fee" /></td>
			</tr>
						
			<tr>
				<td>場地圖片:</td>
				<td><input type="file" name="place_photo" value="上傳圖片" />
			</tr>
			
			<tr>
				<td><input type="submit" value="新增" id="uploadBtn"/></td>
			</tr>
		</table>
	</form>
	
	<div id="upload_result"></div>
</div>

        <script>
				const uploadBtn = document.getElementById('uploadBtn')

				uploadBtn.addEventListener('click', e => {
					e.preventDefault(); // 取消原本 form 表單 submit 送出的功能 , 因為要用 js 送

					let ajaxForm = document.getElementById('ajaxForm');

					let formData = new FormData(ajaxForm);

					sendPostRequest(formData)
				})


				function sendPostRequest(formData) {
					axios({
						url: 'http://localhost:8080/Survival/place/post',
						method: 'post',
						data: formData,
						headers: { 'Content-Type': 'multipart/form-data' }
					})
					.then(res => {
							console.log(res)
							let resultDiv = document.getElementById('upload_result');
							resultDiv.innerHTML = res.data

					})
					.catch(err => {
							console.log(err)

					})

				}



			</script>	
</body>
</html>