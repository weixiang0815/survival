<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-hant-tw">
<head>
<meta charset="UTF-8">
<title>上傳活動相簿</title>
<style>
#drop-zone {
	border: 2px dashed #bbb;
	border-radius: 5px;
	padding: 25px;
	text-align: center;
	font-size: 18px;
	font-weight: bold;
	color: #bbb;
}

#drop-zone.hover {
	border-color: #999;
	color: white;
	background-color: black;
}

.image-container {
	display: inline-block;
	position: relative;
	margin: 10px;
}

.delete-button {
	display: none;
	position: absolute;
	top: 0;
	right: 0;
	width: 20px;
	height: 20px;
	font-size: 16px;
	font-weight: bold;
	color: rgba(255, 255, 255, 0.5);
	background-color: rgba(255, 0, 0, 0.5);
	border: none;
	border-radius: 50%;
	cursor: pointer;
}

.image-container:hover .delete-button {
	display: block;
}

.delete-button:hover {
	color: white;
	background-color: rgba(255, 0, 0, 1);
}

#image-container {
	margin-top: 20px;
}

#image-container img {
	max-width: 200px;
	max-height: 200px;
}
</style>
</head>
<body>
	<jsp:include page="../../Template/admin.jsp" />
	<div class="container">
		<h1>上傳活動相簿</h1>
		<form action="${contextRoot}/competition/prize/add" method="POST" enctype="multipart/form-data">
			<div id="drop-zone" class="mt-5 mb-5">將照片拖曳進來以上傳，可同時上傳多張照片</div>
			<input type="hidden" name="compId" value="${comp.id}">
			<input type="file" name="files" multiple style="display: none;">
			<button type="submit" class="btn btn-primary btn-sm">上傳</button>
		</form>
		<div id="log" style="display: none"></div>
		<div id="image-container"></div>
	</div>
	<script>
		const log = $("#log");
		const dropZone = $('#drop-zone');
		const input = $('input[type="file"]');
		const imgContainer = $('#image-container')
		$('#drop-zone').on(
				{
					'dragover' : function() {
						dropZone.addClass('hover');
						return false;
					},
					'dragleave' : function() {
						dropZone.removeClass('hover');
						return false;
					},
					'drop' : function(e) {
						e.stopPropagation();
						e.preventDefault();
						dropZone.removeClass('hover');
						let files = e.originalEvent.dataTransfer.files;
						input.prop('files', files);
						let props = input.prop("files");
						let str = "";
						for (let i = 0; i < props.length; i++) {
							let prop = props[i];
							console.log(prop);
							str += "<p>" + prop.name + "</p>";
						}
						log.html(str);
						imgContainer.html('');
						for (let i = 0; i < files.length; i++) {
							let reader = new FileReader();
							reader.onload = function(e) {
								let container = $('<div>').addClass(
										'image-container');
								let img = $('<img>').attr('src',
										e.target.result);
								let deleteButton = $('<button>').text('x')
										.addClass('delete-button');
								container.on('mouseenter', function() {
									deleteButton.show();
								}).on('mouseleave', function() {
									deleteButton.hide();
								});
								deleteButton.on('click', function() {
									container.remove();
									input.prop('value', '');
								});
								container.append(img, deleteButton);
								imgContainer.append(container);
							};
							reader.readAsDataURL(files[i]);
						}
					}
				});
		// $("form").on("submit", function(e) {
		// 	e.preventDefault();
		// 	confirm("你上傳了好多張圖片呦～");
		// });
	</script>
</body>
</html>