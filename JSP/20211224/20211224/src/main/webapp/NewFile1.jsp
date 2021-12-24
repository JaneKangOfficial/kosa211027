<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include</title>
</head>
<body>
<!-- include된 내용까지 하나의 java 파일로 통합되어 만들어진다. -->
<table border=1 width="640">
	<tr><th colspan=2><%@ include file="include/top.jsp" %></th></tr>
	<tr><th width="30%"><%@ include file="include/left.jsp" %></th>
		<td><img src="images/tomato.jpg" /></td>
	</tr>
	<tr><th colspan=2><%@ include file="include/footer.jsp" %></th></tr>
</table>
</body>
</html>