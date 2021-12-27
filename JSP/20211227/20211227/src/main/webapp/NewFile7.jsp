<%@ page language="java" contentType="application/hwp; charset=UTF-8"
    pageEncoding="UTF-8"%>	<!-- 한글로 저장 -->
<%
	response.setHeader("Content-Disposition", "attachment;filename=member.hwp");
	response.setHeader("Content-Description", "JSP Generated Data" );
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response : 한글로 저장 </title>
</head>
<body>
<table border=1 width="500">
	<tr><th>이름</th><th>주소</th><th>연락처</th></tr>
	<tr><td>홍길동</td><td>성남</td><td>031-123-1234</td></tr>
	<tr><td>가나다</td><td>의정부</td><td>031-234-2345</td></tr>
</table>
</body>
</html>