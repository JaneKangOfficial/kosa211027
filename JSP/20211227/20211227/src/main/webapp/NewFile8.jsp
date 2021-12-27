<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
<!--  
									session
		웹브라우저 <=====================================================> 웹서버
	session_id, 연결된 시점의 시간, 연결이 유지된 상태에서 재접속 시간
-->
<!--  
	request.setAttribute() ===> request.getAttribute() // 현 페이지에서만 유지
	session.setAttribute() ===> session.getAttribute() // 현 브라우저에서만 유지
	application.setAttribute() ===> application.getAttribute() // 전세계 모두 공유 : 접속자 수
-->

Session ID : <%= session.getId() %><br /> 
Creation Time : <%= new Date(session.getCreationTime()) %><br /> 
마지막 접속 시간 : <%= new Date(session.getLastAccessedTime()) %><br />
유지 시간 : <%= session.getMaxInactiveInterval() %><br />

<!-- =============== 아래 3 제일 많이 사용 =============== -->
 		<% session.setMaxInactiveInterval(10); %><br /> <!-- 10초 유지 -->
새로 접속 여부 : <%= session.isNew() %><br /> <!-- true : 새로 접속 / false : 이미 접속된 상태 -->
<%-- session 종료 : <%= session.invalidate() %><br /> --%>
<!-- =============== =============== =============== -->

<%
	session.setAttribute("result", "session에 저장한 값");
%>
session에 저장한 값 : <%= session.getAttribute("result") %>

</body>
</html>