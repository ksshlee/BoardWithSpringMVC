<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<title>Home</title>
</head>
<body>

<h1>게시판</h1>



<a href="./newBoard">글쓰기</a>


<table border=1>
	<thead>
		<tr>
			<th>번호</th>
			<th>게시글 제목</th>
			<th>작성자</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td>${board.pid}</td>
				<td><a href="./read?pid=${board.pid}">${board.title}</a></td>
				<td>${board.author}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>




</body>
</html>
