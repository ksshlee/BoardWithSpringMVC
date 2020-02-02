<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 쓰기</title>
</head>
<body>

<h1>글 쓰기</h1>


<form action="newBoard" method="post">

제목 : <input type="text" name="title"><br>

내용 : <textarea cols="50" rows="10" name="content"></textarea><br>


<input type="submit" value="글쓰기">



</form>







</body>
</html>