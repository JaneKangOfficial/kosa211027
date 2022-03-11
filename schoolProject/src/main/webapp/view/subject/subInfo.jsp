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
		<td>과목 번호</td>
		<td>${subjectCommand.subjectNum}</td>
	</tr>
	<tr>
		<td>과목명</td>
		<td>${subjectCommand.subjectName}</td>
	</tr>
	<tr>
		<td>과목 제목</td>
		<td>${subjectCommand.subjectTitle}</td>
	</tr>
	<tr>
		<td>과목 내용</td>
		<td>${subjectCommand.subjectContent}</td>
	</tr>
</table>
<a href="../subList">리스트</a> | 
<a href="../subUpdate/${subjectCommand.subjectNum}">수정</a> | 
<a href="../subDel/${subjectCommand.subjectNum}">삭제</a> 
</body>
</html>