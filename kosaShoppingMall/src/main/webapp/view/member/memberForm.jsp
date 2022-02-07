<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원 등록<br />

<!-- modelAttribute="memberCommand" => 오류 메세지 출력 + command 값을 가져오기 위해 -->
<form:form action="memberRegist" method="post" name="frm" id="frm" modelAttribute="memberCommand">
   <!--  path는 name(필드에 있는 멤버필드명) -->
	회원 번호 : <form:input path="memberNum" readonly="readonly" /> : 번호자동부여
				<form:errors path="memberNum" /><br />
	
	회원 이름 : <form:input path="memberName" />
				<form:errors path="memberName" /><br />
	
	생년월일 : <input type="date" name="memberBirth" 
				value="<fmt:formatDate value='${memberCommand.memberBirth}' pattern='yyyy-MM-dd'/>"/>
				<form:errors path="memberBirth" /><br />
	
	성별 : <form:radiobutton path="gender" value="F" />여자 
	 	  <form:radiobutton path="gender" value="M" />남자
				<form:errors path="gender" /><br />
	
	가입일 : <input type="date" name="memberRegist" value="<fmt:formatDate value='${memberCommand.memberRegist}' pattern='yyyy-MM-dd'/>"/>
				<form:errors path="memberRegist" /><br />

	회원 아이디 : <form:input path="memberId" />
				<form:errors path="memberId" /><br />
	
	회원 비밀번호 : <form:password path="memberPw" />
				<form:errors path="memberPw" /><br />
	
	회원 비밀번호 확인 : <form:password path="memberPwCon" />
				<form:errors path="memberPwCon" /><br />
	
	연락처 : <input type="tel" name="memberPhone" placeholder="031-123-1234" value="${memberCommand.memberPhone}"/>
				<form:errors path="memberPhone" /><br />
	
	회원 주소 : <form:input path="memberAddr" />
				<form:errors path="memberAddr" /><br />
	
	회원 이메일 : <input type="email" name="memberEmail" value="${memberCommand.memberEmail}" />
				<form:errors path="memberEmail" /><br />

	<input type="submit" value="회원 등록" />
</form:form>
</body>
</html>