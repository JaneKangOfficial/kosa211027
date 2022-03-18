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
		<td>${one.professorNum}</td>
	</tr>
	<tr>
		<td>과목 번호</td>
		<td>${one.subjectNum}</td>
	</tr>
	<tr>
		<td>폐강</td>
		<td>${one.status}</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<c:if test="${proNum == one.professorNum}">
				<a href="subDel2?num=${one.professorNum}&num2=${one.subjectNum}" >삭제</a>
			</c:if>
			<c:if test="${one.status == 'N'}">
			|	<a href="subClose?num=${one.professorNum}&num2=${one.subjectNum}" >폐강</a>
			</c:if>
			<c:if test="${one.status == 'Y'}">
			|	<a href="subCancel?num=${one.professorNum}&num2=${one.subjectNum}" >폐강 취소</a>
			</c:if>
		|	<a href="mySubList" >내 강의 목록</a>
		|	<a href="subInsertList" >전체 강의 목록</a>
		</td>
	</tr>
</table>
</body>
</html>