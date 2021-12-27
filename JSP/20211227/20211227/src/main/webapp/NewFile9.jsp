<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("req", "request에 저장된 값");
	session.setAttribute("sess", "session에 저장한 값");
	application.setAttribute("app", "application에 저장한 값");	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	request에 저장한 값 : <%= request.getAttribute("req") %><br />	<!-- 현 페이지내에서만 -->
	session에 저장한 값 : <%= session.getAttribute("sess") %><br />	<!-- 현 브라우저내에서만 -->
	application에 저장한 값 : <%= application.getAttribute("app") %><br />	<!-- 전세계 모두 공유 -->
</body>
</html>