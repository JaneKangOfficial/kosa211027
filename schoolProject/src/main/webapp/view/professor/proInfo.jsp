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
		<td>${professorCommand.professorNum}</td>
	</tr>
	<tr>
		<td>교수 이름</td>
		<td>${professorCommand.professorName}</td>
	</tr>
	<tr>
		<td>교수 연락처</td>
		<td>${professorCommand.professorPhone}</td>
	</tr>
	<tr>
		<td>교수 이메일</td>
		<td>${professorCommand.professorEmail}</td>
	</tr>
	<tr>
		<td>교수 아이디</td>
		<td>${professorCommand.professorId}</td>
	</tr>
	<tr>
		<td>학과</td>
		<td>${professorCommand.departmentNum}</td>
	</tr>
</table>
<a href="../proUpdate?num=${professorCommand.professorNum}">수정</a> |
<a href="../proDel/${professorCommand.professorNum}">삭제</a>

</body>
</html>