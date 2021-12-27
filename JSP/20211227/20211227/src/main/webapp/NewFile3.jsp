<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); /* 전달 받은 값이 깨졌을 경우 */
	String searchVal = request.getParameter("search");
	request.setAttribute("subject", "jsp는 서버프로그램입니다."); /* setAttribute :  클라이언트에게 전달하기 위해 서버에 있는 값을 저장 */
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request</title>
</head>
<body>
검색 페이지입니다.<br />
<form action="NewFile3.jsp" method="post" name="frm">
	검색 : <input type="search" name="search" value="<%= searchVal %>"/><br />
	<%-- value="<%= searchVal %> : 검색한 값 가져오기 --%>
	검색 결과 : <%= request.getAttribute("subject") %><br /> <!-- getAttribute : 서버에서 클라이언트에게 -->
	<input type="submit" value="검색" />
</form>
</body>
</html>