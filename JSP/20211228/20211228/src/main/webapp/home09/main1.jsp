<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>     
<%
	request.setAttribute("addr", "경기도");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
본문 페이지입니다. <br />
<jsp:include page="sub1.jsp">
	<jsp:param value="red" name="color1"/>
	<jsp:param value="서적" name="val"/>
</jsp:include>
<br />
본문 중간입니다. <br />
<%
	request.setAttribute("age", 10);
	request.setAttribute("userName", "홍길동");
%>
<br />
<jsp:include page="sub2.jsp" />

본문 페이지입니다. <br />
</body>
</html>