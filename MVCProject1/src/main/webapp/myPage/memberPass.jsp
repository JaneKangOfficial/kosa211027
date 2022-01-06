<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberPass.jsp</title>
</head>
<body>
비밀번호 변경 <br />
<form action="memberPassword.mem" name="frm" id="frm">
	<div style="color:red">${msg}<br /></div> <%-- ${setAttribute명} --%> 
	현재 비밀번호 : <input type="password" name="memPw" />
	<input type="submit" value="비밀번호 확인" />
</form>
</body>
</html>