<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setAttribute("name", "홍길동"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl</title>
</head>
<body>
<%= 10 + 5 %><br />
${10 + 5} <br />
<%= request.getAttribute("name") %> <br />
${empty name}<br /> <!-- name 안 비어있으니까 false -->
${empty age}<br /> <!-- name 비어있으면 true -->
</body>
</html>