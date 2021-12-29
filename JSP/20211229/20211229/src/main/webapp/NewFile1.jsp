<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %><!-- c custom tag -->
<%@ page import="java.util.*" %>
<%
	Integer ii[] = {1,2,3,4,5};
	request.setAttribute("ii", ii);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	for(int i = 0; i < ii.length; i++) {
		out.print(ii[i] + "<br />");		
	}

	for (Integer i : ii) {
		out.print(i + "<br />");
	}
%>

<c:forEach items="${ii}" var="i">
	${i }<br />
</c:forEach>

<%
	String str = "Hello JSTL!";
%>
<c:set var="str1" value="Hello JSTL!" />
${str1 }

<%
	request.setAttribute("str1", "Hello JSTL!!!");
%>
${str1 }<br /> <!-- 이렇게 사용하기 위해서는 set 에 담아야 한다. -->

<c:set var="str2" value="Hello JSTL!!!!!" />
str2 : ${str2 }<br />


</body>
</html>