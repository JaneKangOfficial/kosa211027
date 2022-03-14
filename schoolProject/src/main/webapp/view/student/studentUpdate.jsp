<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script>
function checkId(){
	$.ajax({
		type: "post",
		dataType: "text",
		data : {id : $('#studentId').val()},
		url : "idCkUpdate",
		success : function(result) {
			$("#id").html(result);
			if(result == "사용 가능한 아이디입니다.") {
				$("#id").css("color", "blue");
			}else {
				$("#id").css("color", "red");
			}
		}
	});
}

function checkEmail(){
	$.ajax({
		type: "post",
		dataType: "text",
		data: {email : $('#studentEmail').val()},
		url : "emailCkUpdate",
		success : function(result){
			$("#email").html(result);
			if(result == "사용 가능한 이메일입니다."){
				$("#email").css("color", "blue");
			}else {
				$("#email").css("color", "red");
			}
		}
	});
}

</script>
</head>
<body>
<form:form action="studentUpdate" method="post" modelAttribute="studentCommand">
<input type="hidden" name="studentPwCon" value="123" />
<table>
	<tr>
		<td>학생 번호</td>
		<td>
			<input type="text" name="studentNum" value="${studentCommand.studentNum}" readonly="readonly"/>
			<form:errors path="studentNum"/>
		</td>
	</tr>
	<tr>
		<td>학생 아이디</td>
		<td>
			<input type="text" name="studentId" id="studentId" value="${studentCommand.studentId}" oninput="checkId()"/>
			<span id="id"></span>
			<form:errors path="studentId"/>
		</td>
	</tr>
	<tr>
		<td>현재 비밀번호</td>
		<td>
			<input type="password" name="studentPw" />
			<form:errors path="studentPw"/>
		</td>
	</tr>
	<tr>
		<td>새로운 비밀번호</td>
		<td>
			<input type="password" name="newPw" />
		</td>
	</tr>
	<tr>
		<td>새로운 비밀번호 확인</td>
		<td>
			<input type="password" name="newPwCon" />
		</td>
	</tr>
	<tr>
		<td>학생 이름</td>
		<td>
			<input type="text" name="studentName" value="${studentCommand.studentName}"/>
			<form:errors path="studentName"/>
		</td>
	</tr>
	<tr>
		<td>학생 연락처</td>
		<td>
			<input type="tel" name="studentPhone" value="${studentCommand.studentPhone}"/>
			<form:errors path="studentPhone"/>
		</td>
	</tr>
	<tr>
		<td>학생 이메일</td>
		<td>
			<input type="email" name="studentEmail" id="studentEmail" value="${studentCommand.studentEmail}" oninput="checkEmail()"/>
			<span id="email"></span>
			<form:errors path="studentEmail"/>
		</td>
	</tr>
	<tr>
		<td>학과 번호</td>
		<td>
			<select name="departmentNum">
				<c:forEach items="${departmentNum}" var="studentCommand"  >
					<option value="${studentCommand.departmentNum}" >${studentCommand.departmentNum}</option>		
				</c:forEach>
			</select>
			<form:errors path="departmentNum"/>
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