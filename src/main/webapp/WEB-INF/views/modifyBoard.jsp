<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body>

<form action="modify?pid=${boardVO.pid}" method="post">
	<table border=1>
		<tbody>
			<tr>
				<th>게시글 번호
				<td>${boardVO.pid}
			</tr>

			<tr>
				<th>제목
				<td><input type="text" value="${boardVO.title}" name="title">
			</tr>
			<tr height="40">
				<th width="30%">내용
				<td width="30%"><textarea cols="50" rows="10" name="content">${boardVO.content}</textarea>
			</tr>

		</tbody>
	</table>
	
<input type="submit" value="수정하기">


</form>


</body>
</html>