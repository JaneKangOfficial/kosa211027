<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form.jsp</title>
</head>
<body>
<form action="recieve.jsp" name="frm" method="post">
	이름 : <input type="text" name="userName" /><br />
	아이디 : <input type="text" name="userId" /><br />
	비밀번호 : <input type="password" name="userPw" /><br />
	<!-- get 방식이면 비밀번호가 보이기 때문에 post 방식으로 한다. -->
	자기소개서 : <textarea rows="5" cols="30" name="desc"></textarea>
	<input type="submit" value="전송" />
</form>
</body>
</html>