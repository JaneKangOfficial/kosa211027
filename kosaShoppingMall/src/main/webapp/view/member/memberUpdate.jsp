<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
수정 <br />
<form:form action="memModify" method="post" modelAttribute="memberCommand">
	<!-- 수정에서 비밀번호가 empty이기 때문에 화면이 넘어가지 않는다. 히든으로 의미없는 값을 줘야 한다. -->
	<input type="hidden" name="memberPw" value="123">
    <input type="hidden" name="memberPwCon" value="123">
	
	번호 : <form:input path="memberNum" value="${memberCommand.memberNum}" readonly="readonly"/><br />
	
	회원 아이디 : <form:input path="memberId" value="${memberCommand.memberId}" /><br />
	
	회원 이름 : <form:input path="memberName"  value="${memberCommand.memberName}" /><br />
	
	회원 주소 : <form:input path="memberAddr"  value="${memberCommand.memberAddr}" /><br />
	
	성별 :
		<form:radiobutton path="gender"  value="F"  checked="${memberCommand.gender == 'F'}"/>여자
		<form:radiobutton path="gender"  value="M"  checked="${memberCommand.gender == 'M'}" />남자<br />
	
	연락처 : <input type="tel" name="memberPhone"  value="${memberCommand.memberPhone}"/><br />
	
	생년월일 : <input type="date" name="memberBirth"  value="<fmt:formatDate value='${memberCommand.memberBirth}' pattern='yyyy-MM-dd'/>"/><br />
	
	
	회원 이메일 : <input type="email" name="memberEmail"  value="${memberCommand.memberEmail}"/><br />
	
	등록일 : <input type="date" name="memberRegist"   value="<fmt:formatDate value='${memberCommand.memberRegist}' pattern='yyyy-MM-dd'/>"/>
	
	<input type="submit" value="수정 완료" />
</form:form>
</body>
</html>