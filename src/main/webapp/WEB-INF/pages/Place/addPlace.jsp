<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>場地表</title>
</head>
<body>
<h1>AddPlace</h1>
<div class="container">
<form action="addPlace" method="post">
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
				<td>費用/小時：</td>
				<td><input type="text" name="place_fee" /></td>
			</tr>
						
			<tr>
				<td>場地圖片:</td>
				<td><input type="file" name="place_photo" value="上傳圖片" />
			</tr>
			
			<tr>
				<td><input type="submit" value="新增" /></td>
			</tr>
		</table>
	</form>
</div>	
</body>
</html>