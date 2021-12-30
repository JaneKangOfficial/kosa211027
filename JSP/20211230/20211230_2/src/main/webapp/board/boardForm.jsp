<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
boardForm.jsp 입니다.
<form action="boardWrite.bd" method="post"> <!-- 주소를 만들었으면 무조건 controller에 등록 -->

<table>
	<caption>게시글 쓰기</caption>
	<tr>
		<td>글쓴이</td>
		<td>
			<input type="text" name="boardWriter" required="required"/>
		</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>
			<input type="text" name="boardSubject" required="required"/>
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<textarea rows="6" cols="30" name="boardContent"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan=2 align="center">
			<input type="submit" value="게시글 등록" />
		</td>
	</tr>
	
</table>
</form>


</body>
</html>