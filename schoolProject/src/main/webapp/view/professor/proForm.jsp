<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script>
	function checkEmail() {
		$.ajax({
			type : "post" ,
			dataType : "text" ,
			data : {email : $('#professorEmail').val()},
			url : "emailCk",
			success : function(result) {
				$("#asd").html(result);
				if(result == "사용 가능한 이메일입니다.") {
					$('#asd').css("color","blue");
				}else {
					$('#asd').css("color","red");
				}
			}
		});	
	}
	
	function checkId() {
		$.ajax({
			type: "post",
			dataType : "text",
			data : {id : $('#professorId').val()},
			url : "idCk",
			success : function(result) {
				$("#sdf").html(result);
				if(result == "사용 가능한 아이디입니다.") {
					$('#sdf').css("color","blue");
				}else {
					$('#sdf').css("color","red");
				}
			}
		});
	}
</script>
</head>
<body>
<form:form action="professorRegist" method="post" modelAttribute="professorCommand">
<table border="1">
	<tr>
		<td>교수 번호</td>
		<td>
			<input type="text" name="professorNum" value="${professorNum}" readonly="readonly"/>
			<form:errors path="professorNum"/>
		</td>
	</tr>
	<tr>
		<td>교수 이름</td>
		<td>
			<input type="text" name="professorName" />
			<form:errors path="professorName"/>
		</td>
	</tr>
	<tr>
		<td>교수 연락처</td>
		<td>
			<input type="tel" name="professorPhone" />
			<form:errors path="professorPhone"/>
		</td>
	</tr>
	<tr>
		<td>교수 이메일</td>
		<td>
			<input type="email" name="professorEmail" id="professorEmail" oninput="checkEmail()"/>
			<span id="asd"></span>
			<form:errors path="professorEmail"/>
		</td>
	</tr>
	<tr>
		<td>교수 아이디</td>
		<td>
			<input type="text" name="professorId" id="professorId" oninput="checkId()" />
			<span id="sdf"></span>
			<form:errors path="professorId"/>
		</td>
	</tr>
	<tr>
		<td>교수 비밀번호</td>
		<td>
			<input type="password" name="professorPw" />
			<form:errors path="professorPw" />
		</td>
	</tr>
	<tr>
		<td>교수 비밀번호 확인</td>
		<td>
			<input type="password" name="professorPwCon" />
			<input type="hidden" name="newPw" value="123" />
			<form:errors path="professorPwCon"/>
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
		<form:errors path="departmentNum"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="등록" />
		</td>
	</tr>
</table>
</form:form>
</body>
</html>