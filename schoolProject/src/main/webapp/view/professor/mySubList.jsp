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
<form action="mySubDeletes" method="post">
<table border="1">
	<tr>
		<td>교수 번호</td>
		<td>과목 번호</td>
		<td>폐강</td>
		<td><input type="submit" value="삭제"/></td>
	</tr>
	<c:forEach items="${list}" var="dto">
	<tr align="center">
		<td>
		<a href="subInfo?num=${dto.professorNum}&num2=${dto.subjectNum}" >${dto.professorNum}</a>
<%-- 			<a href="professorInfo/${dto.professorNum}">${dto.professorNum}</a> --%>
		</td>
		<td>${dto.subjectNum}</td>
		<td>${dto.status}</td>
		<td><input type="checkbox" name="delete" value="${dto.professorNum}`${dto.subjectNum}"/></td>
	</tr>
	</c:forEach>
</table>
</form>
<a href="../subject/subList">과목 정보</a>
</body>
</html>