<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cp[] = request.getParameterValues("cp");
/* []배열은 values로 여러개를 받는다. */

	String emailCk = request.getParameter("emailCk");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>rcform.jsp</title>
</head>
<body>
관심분야 : <br />
<%
	for(String s : cp) {
		out.print(s + ", ");
	}
%><br />

이메일 여부<br />
<%
	switch(emailCk) {
	case "Y" : out.print("이메일을 받습니다.");
	case "N" : out.print("이메일을 받지 않습니다.");	
	}
%>
</body>
</html>