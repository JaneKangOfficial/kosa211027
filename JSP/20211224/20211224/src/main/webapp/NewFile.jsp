<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, java.util.List"%>
<%@ page import="java.io.*, java.util.Calendar" %>

<%-- page 지시문 :  language, contentType, pageEncoding, import 
				만 사용하면 된다.
--%>
<%
	Calendar cal = Calendar.getInstance();
	List<String> list = new ArrayList<String>();
	list.add("가나다");
	list.add("라마바");
	list.add("사아자");
	list.add("차카타");
%>
<%-- List<String> : 컬렉션<제네럴타입> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지시문</title>
</head>
<body>

오늘 날짜 : 
<%= cal.get(Calendar.YEAR) %> 년
<%= cal.get(Calendar.MONTH)+ 1 %> 월
<%= cal.get(Calendar.DATE) %> 일
<br /><br />

<%
	for(String s : list) {
		out.println(s + "<br />");
	}
%>

</body>
</html>