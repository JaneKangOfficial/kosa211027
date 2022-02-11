<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border=1 width="90%">
	<tr valign="middle">
		<td colspan="3" align="center">회원 리스트</td>
		<td align="center">총 회원수 : ${count}</td>
		<td align="center">현재 페이지 회원수 : ${list.size()}</td>
	</tr>
	<tr>
		<th>회원 아이디</th>
		<th>회원 이름</th>
		<th>회원 연락처</th>
		<th>이메일</th>
		<th>등록일</th>
	</tr>
	<c:forEach items="${list}" var="dto">
	<tr align="center" valign="middle">
		<td align="center">
			<a href="/mem/memberInfo/${dto.memberNum}">${dto.memberId}</a>
		</td>
		<td align="center">${dto.memberName}</td>
		<td align="center">${dto.memberPhone}</td>
		<td align="center">${dto.memberEmail}</td>
		<td align="center"><fmt:formatDate value="${dto.memberRegist}" pattern="yyyy-MM-dd"/></td>
	</tr>
	</c:forEach>
	
	<tr>
		<th colspan="5">
			<c:if test="${page <= 1}">
				[이전]
			</c:if>
			<c:if test="${page > 1}">
				<a href="memList?page=${page - 1}">[이전]</a>
			</c:if>
			
			<c:forEach begin="${startPage}" end="${endPage}" var="i" step="1">
				[<a href="memList?page=${i}">${i}</a>]
			</c:forEach>
			
			<c:if test="${page < maxPage}">
				<a href="memList?page=${page + 1}">[이후]</a>
			</c:if>
			<c:if test="${page >= maxPage}">
				[이후]
			</c:if>
		</th>
	</tr>
</table>
<a href="memberRegist">회원등록</a>
</body>
</html>