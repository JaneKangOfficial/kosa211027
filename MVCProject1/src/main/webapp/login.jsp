<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인 페이지입니다. <br />
<form action="loginPro.login" method="post" name="frm" id="frm">
<table border=1>
	<tr>
		<td colspan=2>
			<input type="checkbox" value="autoLogin" name="autoLogin" />로그인 유지 |
			<input type="checkbox" value="storeId" name="storeId" /> 아이디 저장
		</td>
	</tr>
	<tr>
		<td>
			<input type="text" name="id" placeholder="아이디 입력" value="${userId}"/><br />
			<span style="color:red">${idErr}</span>
		</td>
		<td rowspan=2>
			<input type="image" src="images/강아지2.jpg" width="50px" height="50px"/>
		</td>
	</tr>
	<tr>
		<td>
			<input type="password" name="pw" placeholder="비밀번호"/><br />
			<span style="color:red">${pwErr}</span>
		</td>
	</tr>
	<tr>
		<td colspan=2>
			아이디/비밀번호 찾기 | 
			<a href="memberAgree.mem" >회원가입</a>
		</td>
	</tr>
</table>
</form>

</body>
</html>