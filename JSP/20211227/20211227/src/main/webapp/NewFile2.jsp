<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 기본 객체 
	request, response, application, session(로그인, 장바구니)
	out : out.print(), out.write()
--%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request</title>
</head>
<body>
	<!-- request -->
	클라이언트 IP 주소 : <%= request.getRemoteAddr() %><br /><!-- 0:0:0:0:0:0:0:1 본인이 접속했을 경우의 IP 주소 -->
	요청 메서드 : <%= request.getMethod() %><br /><!-- GET -->
	Protocol : <%= request.getProtocol() %><br /><!-- HTTP/1.1 -->
	ServerName : <%= request.getServerName() %><br /><!-- localhost -->
	ServerPort : <%= request.getServerPort() %><br /><!-- 8080 -->
	요청 URI : <%= request.getRequestURI() %><br /><!-- /20211227/NewFile2.jsp -->
	<!-- URL = Protocol + ServerName + ServerPosrt + URI -->
	요청 URL : <%= request.getRequestURL() %><br /><!-- http://localhost:8080/20211227/NewFile2.jsp -->
	요청한 ContextPath : <%= request.getContextPath() %><br /><!-- /20211227 -->
	요청 QueryString : <%= request.getQueryString() %><br /><!-- ?name=홍길동 -->
	<br />
	
	문제 : /NewFile2.jsp만 출력하시오. <br />
	ContextPath의 길이 : <%= request.getContextPath().length() %><br /> <!-- 9 --> 
	<%= request.getRequestURI().substring(9) %><br /> <!-- /NewFile2.jsp -->
	<%= request.getRequestURI().substring(request.getContextPath().length()) %><br /> <!-- /NewFile2.jsp -->
	<br />
	<%
		String stridx = "abcd";
		String str = "abcdefghi";
		out.print("de : " + str.substring(3, 3+2) + "<br />");
		out.print("efghi : " + str.substring(4) + "<br />");
		out.print("efghi : " + str.substring(stridx.length()) + "<br />");
	%>
	<br />
	<%
		String str1 = "경기도 성남시 분당구 운중로 160";
	//				   012 345678
		String sido = "경기도 성남시";
		/* 문제 : 시도를 뺀 나머지 주소를 가지고 오시오. */
		out.print(sido.length() + "<br />"); // 7
		out.print(str1.substring(sido.length() + 1) + "<br />"); // 7은 공백문자, 8인 '분'당구부터 가져옴
	%>

</body>
</html>