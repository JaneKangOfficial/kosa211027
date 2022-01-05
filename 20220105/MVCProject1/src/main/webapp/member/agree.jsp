<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>agree.jsp</title>
</head>
<body>
회원 가입하시려면 아래 내용에 동의하십시오.<br />
<form action="memberJoin.mem" method="post">
...내용...<br />
<input type="checkbox" required="required" />동의
<input type="submit" value="다음" />
</form>

</body>
</html>