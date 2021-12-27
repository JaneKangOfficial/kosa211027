<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 현재 접속자 수 확인
	Integer count = (Integer)application.getAttribute("count");
	Integer newCount;
	
	if (count == null) {
		newCount = 1;
		application.setAttribute("count", 1);		
	}else {
			newCount = count;
		if (session.isNew()) {
			newCount += 1;
			application.setAttribute("count", newCount);			
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>counter.jsp</title>
</head>
<body>

	현재 접속자 수 : <%= newCount %><br />
	upload의 절대 경로 : <%= application.getRealPath("upload") %> <!-- webapp 밑에 있는 폴더의 절대 경로 -->
	
</body>
</html>