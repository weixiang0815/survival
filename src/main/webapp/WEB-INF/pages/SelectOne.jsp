<%@ page language="java" contentType="text/html; charset=UTF-8"
import="java.util.*, tw.survival.model.User.UserBean" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢結果</title>
</head>
<body>
	<h3>查詢結果</h3>
		<table>
				<tr><td><label>使用者ID：</label>${user.id}
				<tr><td><label>使用者名稱：</label>${user.name}
				<tr><td><label>使用者帳號：</label>${user.account}
				<tr><td><label>使用者密碼：</label>${user.password}
				<tr><td><label>使用者性別：</label>${user.sex}
				<tr><td><label>使用者地址：</label>${user.address}
				<tr><td><label>使用者電子信箱：</label>${user.email}
				<tr><td><label>使用者年齡：</label>${user.age}
		</table>
		<a href="searchmain.controller"><button>回到搜尋頁</button></a>
</body>
</html>