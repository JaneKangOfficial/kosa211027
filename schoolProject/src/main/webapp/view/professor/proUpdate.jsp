<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="proUpdate" method="post" modelAttribute="professorCommand">
<table border="1">
	<tr>
		<td>교수 번호</td>
		<td>
			<input type="text" name="professorNum" value="${professorCommand.professorNum}" readonly="readonly"/>
			<form:errors path="professorNum"/>
		</td>
	</tr>
	<tr>
		<td>교수 이름</td>
		<td>
			<input type="text" name="professorName" value="${professorCommand.professorName}"/>
			<form:errors path="professorName"/>
		</td>
	</tr>
	<tr>
		<td>교수 연락처</td>
		<td>
			<input type="tel" name="professorPhone" value="${professorCommand.professorPhone}" />
			<form:errors path="professorPhone"/>
		</td>
	</tr>
	<tr>
		<td>교수 이메일  중복체크 하기!</td>
		<td>
			<input type="text" name="professorEmail" value="${professorCommand.professorEmail}" />
			<form:errors path="professorEmail"/>
		</td>
	</tr>
	<tr>
		<td>교수 아이디  중복체크 하기!</td>
		<td>
			<input type="text" name="professorId" value="${professorCommand.professorId}"/>
			<form:errors path="professorId"/>
		</td>
	</tr>
	<tr>
		<td>현재 비밀번호</td>
		<td>
			<input type="password" name="professorPw" />
			<input type="hidden" name="professorPwCon" value="123" />
			<form:errors path="professorPw" />
		</td>
	</tr>
	<tr>
		<td>새로운 비밀번호</td>
		<td>
			<input type="password" name="newPw"/>
			<form:errors path="newPw" />
		</td>
	</tr>
	<tr>
		<td>학과</td>
		<td>
		
		<select name="departmentNum">
			<c:forEach items="${list}" var="departmentCommand"  >
				<option value="${departmentCommand.departmentNum}" >${departmentCommand.departmentName}</option>		
			</c:forEach>
		</select>
		<form:errors path="departmentNum" />
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="수정완료" />
		</td>
	</tr>
</table>
</form:form>
</body>
</html>