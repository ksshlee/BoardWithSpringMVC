<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>

<h1>로그인</h1>

<a href="/study">메인화면으로</a>

<form action="login" method="post">
	id : <input type="text" name="id"><br>
	pwd : <input type="password" name="pwd"><br>
	
	<input type="submit" value="로그인">

</form>
</body>
</html>