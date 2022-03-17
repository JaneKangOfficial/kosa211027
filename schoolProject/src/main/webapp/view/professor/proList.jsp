<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<td>교수 아이디</td>
		<td>교수 이름</td>
		<td>학과명</td>
	</tr>
	<c:forEach items="${list}" var="professorCommand">
	<tr>
		<td><a href="professorInfo/${professorCommand.professorNum}">${professorCommand.professorNum}</a></td>
		<td>${professorCommand.professorId}</td>
		<td>${professorCommand.professorName}</td>
		<td>${professorCommand.departmentNum}</td>
	</tr>
	</c:forEach>
</table>
	<a href="professorRegist">교수 등록</a>
</body>
</html>