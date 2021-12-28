<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서브1 페이지입니다. <br />
<span style='color:<%=request.getParameter("color1") %>'>
	<%= request.getParameter("val") %>
</span>
<br />
<!-- "userName"과 "age"는 main1.jsp에서 값을 가져오기 전이라 null이 나온다. -->
<%= request.getAttribute("userName") %>의 나이는 <%= request.getAttribute("age") %> 입니다. <br />
주소는 : <%= request.getAttribute("addr") %> <br />
서브1 페이지입니다. <br />
</body>
</html>