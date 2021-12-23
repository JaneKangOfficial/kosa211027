<!-- page 지시문  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	for(var i = 0; i <= 9; i++) {
		document.write(i + "<br />");
	}
</script>
</head>
<body>
<!-- 스프립트릿 : 여러번 사용이 가능하므로 한줄씩 사용할 수 있다. -->
<%
// 이 안에 있는 코드는 html 코드가 아니다. servlet으로 변환시 out.write로 묶이지 않는다. 자바코드로 그대로 사용
	for(int i = 0; i <= 9; i++){
		out.print(i + "<br />");
		// System.out.println();
	}
	out.print("안녕하세요.<br/>");
%>

<%-- jsp 주석입니다. --%>

<%	for(int i = 0; i <= 9; i++){ %>
<%= i + "<br />"  %>	<!-- 표현식 : 코드 마지막에 ; 없다. -->
<!-- out.print(); -->	
<%	} %>

안녕하세요.<br/>
</body>
</html>