<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>檔案上傳</title>
</head>
<body>

<form action="upload.controller" method="post" enctype="multipart/form-data">
請上傳一張圖片：<input type="file" name="myFiles" /><br/>
<input type="submit" value="上傳" />
</form>
</body>
</html>