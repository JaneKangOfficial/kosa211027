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
총 과목 수 : ${count} <br />
현재 페이지 과목 수 : ${list.size()}
	<tr>
		<td>과목 번호</td>
		<td>과목명</td>
		<td>과목 제목</td>
		<td>과목 내용</td>
	</tr>
	
	<c:forEach items="${list}" var="subjectCommand">
	<tr>
		<td><a href="subInfo/${subjectCommand.subjectNum}">${subjectCommand.subjectNum}</a></td>
		<td>${subjectCommand.subjectName}</td>
		<td>${subjectCommand.subjectTitle}</td>
		<td>${subjectCommand.subjectContent}</td>
	</tr>
	</c:forEach>
	
	<tr>
		<th colspan="4">
			<c:if test="${page <= 1}">
				[이전]
			</c:if>
			<c:if test="${page > 1}">
				<a href="subList?page=${page - 1}">[이전]</a>
			</c:if>
			
			<c:forEach begin="${startPage}" end="${endPage}" var="i" step="1">
				[<a href="subList?page=${i}">${i}</a>]
			</c:forEach>
			
			<c:if test="${page < maxPage}">
				<a href="subList?page=${page + 1}">[이후]</a>
			</c:if>
			<c:if test="${page >= maxPage}">
				[이후]
			</c:if>
		</th>
	</tr>

</table>
<a href="subRegist">과목 등록</a>
</body>
</html>