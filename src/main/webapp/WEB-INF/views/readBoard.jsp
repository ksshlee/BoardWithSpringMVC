<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 읽기</title>
<script type="text/javascript">

	/* 댓글 작성 동적 form */
	function comment_click(){
		var form = document.createElement("form");
        form.setAttribute("method", "post"); 
        form.setAttribute("action", "createComment?pid=${boardVO.pid}");
        
        
        var hidden2 = document.createElement("input"); 

        hidden2.setAttribute("type", "input");

        hidden2.setAttribute("name", "content");

        form.appendChild(hidden2);
  
      
        var submit = document.createElement("input"); 
        
        submit.setAttribute("type","submit");
        submit.setAttribute("value","댓글 생성");
        
        form.appendChild(submit);
        
        
        document.body.appendChild(form);
	}





	/* 댓글 수정 동적 form */
	function modify_click(pid,cid,rcid) {
		var form = document.createElement("form");
        form.setAttribute("method", "post"); 
        form.setAttribute("action", "modifyComment?pid="+pid);
        
        
        var hid1 = document.createElement("input"); 

        hid1.setAttribute("type", "hidden");

        hid1.setAttribute("name", "pid");
        
        hid1.setAttribute("value", pid);

        form.appendChild(hid1);
        
        var hid2 = document.createElement("input"); 

        hid2.setAttribute("type", "hidden");

        hid2.setAttribute("name", "cid");
        
        hid2.setAttribute("value", cid);

        form.appendChild(hid2);
        
        var hid3 = document.createElement("input"); 

        hid3.setAttribute("type", "hidden");
        hid3.setAttribute("name", "rcid");
        
        hid3.setAttribute("value", rcid);

        form.appendChild(hid3);
        
        
        
        
        
        var hidden2 = document.createElement("input"); 

        hidden2.setAttribute("type", "input");

        hidden2.setAttribute("name", "content");

        form.appendChild(hidden2);
        
  
        var submit = document.createElement("input"); 
        
        submit.setAttribute("type","submit");
        submit.setAttribute("value","수정");
        
        form.appendChild(submit);
        
        
        document.body.appendChild(form);

        
	}
	
	
	
	
	/* 답글 동적 form */
	function commentofcomment(cid,pid){
		var form = document.createElement("form");
        form.setAttribute("method", "post"); 
        form.setAttribute("action", "createCommentOfComment?pid="+pid+"&cid="+cid);  
        
        var hidden2 = document.createElement("input"); 

        hidden2.setAttribute("type", "input");

        hidden2.setAttribute("name", "content");

        form.appendChild(hidden2);
        
        var submit = document.createElement("input"); 
        
        submit.setAttribute("type","submit");
        submit.setAttribute("value","답글 생성");
        
        form.appendChild(submit);
        
        
        document.body.appendChild(form);
	}
</script>

</head>
<body>
	<h1>게시글 읽기</h1>

	<table border=1>
		<tbody>
			<tr>
				<th>게시글 번호
				<td>${boardVO.pid}
			</tr>

			<tr>
				<th>제목
				<td>${boardVO.title}
			</tr>
			<tr height="40">
				<th width="30%">내용
				<td width="30%">${boardVO.content}
			</tr>
			<tr>
				<th>작성자
				<td>${boardVO.author}
			</tr>


		</tbody>
	</table>


	<a href="/study">목록</a>
	<br>
	<c:choose>

		<c:when test="${sessionUserId eq boardVO.author}">
			<a href="modify?pid=${boardVO.pid}">수정</a>
			<br>

			<a href="deleteBoard?pid=${boardVO.pid}">삭제</a>
			<br>
		</c:when>

	</c:choose>

	<br>
	<hr>

	<h3>댓글</h3>


	<table border=1>
		<tbody>
			<c:forEach items="${CommentList}" var="comment">
				<tr>
					<th width="30%">내용
					<td width="30%">${comment.content}
					<th>작성자
					<td>${comment.author}
					<c:if test="${!empty sessionUserId }">
							
								<c:if test="${sessionUserId eq comment.author or sessionUserId eq boardVO.author}">
									<th><a
										href="deleteComment?cid=${comment.cid}&pid=${boardVO.pid}">삭제</a></th>
								</c:if>
								<c:if test="${sessionUserId eq comment.author}">
									<th><input type="button"
										onclick="modify_click(${boardVO.pid},${comment.cid},${comment.rcid});"
										value="수정" id="coc"></th>
								</c:if>
					
							
							
							
							<th><input type="button"
								onclick="commentofcomment(${comment.cid},${boardVO.pid});"
								value="답글"></th>
						</c:if> 
				</tr>

			</c:forEach>

		</tbody>
	</table>



	<c:if test="${!empty sessionUserId }">
		<input type="button" onclick="comment_click();" value="댓글쓰기">
	</c:if>




</body>

</html>