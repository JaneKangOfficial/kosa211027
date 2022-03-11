<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="../subUpdate" method="post">
<table>
	<tr>
		<td>과목 번호</td>
		<td><input type="text" name="subjectNum" value="${subjectCommand.subjectNum}" /></td>
	</tr>
	<tr>
		<td>과목명</td>
		<td><input type="text" name="subjectName" value="${subjectCommand.subjectName}"/></td>
	</tr>
	<tr>
		<td>과목 제목</td>
		<td><input type="text" name="subjectTitle" value="${subjectCommand.subjectTitle}"/></td>
	</tr>
	<tr>
		<td>과목 내용</td>
		<td><input type="text" name="subjectContent" value="${subjectCommand.subjectContent}"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="수정완료" />
		</td>
	</tr>
</table>
</form>
</body>
</html>