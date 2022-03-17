<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr>
		<td>교수 번호</td>
		<td>${one.professorNum}</td>
	</tr>
	<tr>
		<td>과목 번호</td>
		<td>${one.subjectNum}</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<a href="subDel2?num=${one.professorNum}&num2=${one.subjectNum}" >삭제</a>
		</td>
	</tr>
</table>
</body>
</html>