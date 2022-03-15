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
전체 학생수 : ${count}
	<tr>
		<td>학생 번호</td>
		<td>학생 아이디</td>
		<td>학생 이름</td>
		<td>학과 번호</td>
	</tr>
	
	<c:forEach items="${list}" var="studentCommand">
	<tr>
		<td><a href="studentInfo?num=${studentCommand.studentNum}">${studentCommand.studentNum}</a></td>
		<td>${studentCommand.studentId}</td>
		<td>${studentCommand.studentName}</td>
		<td>${studentCommand.departmentNum}</td>
	</tr>
	</c:forEach>
	<tr>
		<th colspan="4">
			<c:if test="${page <= 1}">
				[이전]
			</c:if>
			<c:if test="${page > 1}">
				<a href="studentList?page=${page - 1}">[이전]</a>
			</c:if>
			<c:forEach begin="${startPage}" end="${endPage}" var="i" step="1">
				[<a href="studentList?page=${i}">${i}</a>]
			</c:forEach>
			<c:if test="${page < maxPage}">
				<a href="studentList?page=${page + 1}">[이후]</a>
			</c:if>
			<c:if test="${page >= maxPage}">
				[이후]
			</c:if>
		</th>
	</tr>
</table>

<a href="studentRegist">학생 등록</a>
</body>
</html>