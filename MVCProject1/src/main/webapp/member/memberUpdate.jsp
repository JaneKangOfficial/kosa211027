<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberUpdate.jsp</title>
</head>
<body>
회원 수정 페이지입니다. <br />
<form action="memberUpdate.mem" method="get" name="frm" id="frm">
	고객 번호 : <input type="text" name="memNum" value="${memberDTO.memNum}" readonly="readonly"/> : 번호 자동부여<br />
	고객 이름 : <input type="text" name="memName" value="${memberDTO.memName}" /><br />
	<!-- 형식이 달라서 나오지 않는다. 변환하기 -->
	<!-- datetime-local : 뒤에 T00:00 붙여야 한다. value="<fmt:formatDate value='${memberDTO.memBirth}' pattern='yyyy-MM-dd' />T00:00" -->
	고객 생년월일 : <input type="datetime-local" name="memBirth" value="<fmt:formatDate value='${memberDTO.memBirth}' pattern='yyyy-MM-dd' />T00:00"  required="required" /><br />
	고객 성별 : <input type="radio" name="memGender" value="F" <c:if test="${memberDTO.memGender=='F'}">checked</c:if> />여자
			 <input type="radio" name="memGender" value="M" <c:if test="${memberDTO.memGender=='M'}">checked</c:if> />남자<br />
	고객 가입일 : <input type="date" name="memRegiDate" value="<fmt:formatDate value='${memberDTO.memRegiDate}' pattern='yyyy-MM-dd'/>"  required="required"/><br />
	고객 아이디 : <input type="text" name="memId" value="${memberDTO.memId}"  /><br />
	고객 비밀번호 : <input type="password" name="memPw" id="memPw" required="required" /><br />
	고객 비밀번호 확인 : <input type="password" name="memPwCon" id="memPwCon" required="required" /><br />
	고객 연락처1 : <input type="tel" name="memPhone1" value="${memberDTO.memPhone1}" placeholder="031-1234-1234" /><br />
	고객 연락처2 : <input type="tel" name="memPhone2" value="${memberDTO.memPhone2}" placeholder="031-1234-1234" /><br />
	고객 주소 : <input type="text" name="memAddr" value="${memberDTO.memAddr}"  /><br />
	고객 이메일 : <input type="email" name="memEmail" value="${memberDTO.memEmail}"  /><br />
	<input type="submit" value="수정완료" />
</form>
</body>
</html>