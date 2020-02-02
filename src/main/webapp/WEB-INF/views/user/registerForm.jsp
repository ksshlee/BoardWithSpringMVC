<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body>

<a href="/study">메인화면으로</a>

<h1>회원가입</h1>

<form action="register" method="post">

	이름 : <input type="text" name="user_name"><br>
	아이디 : <input type="text" name="id"><br>
	비밀번호 : <input type="password" name="pwd"><br>
	
	<input type="submit" value="회원가입">

</form>

</body>
</html>