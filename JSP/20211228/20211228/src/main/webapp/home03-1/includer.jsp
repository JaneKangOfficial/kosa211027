<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String start = "[";
	String end = "]";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>includer.jsp</title>
</head>
<body>
현재의 날짜와 시각은 <jsp:include page="date.jsp" /> 입니다. 
<!-- 서블릿이 각자 만들어지기 때문에 오류 발생, param값을 줘야 한다. home8 참고 -->
<br />
<%= date_jsp_var %>

</body>
</html>