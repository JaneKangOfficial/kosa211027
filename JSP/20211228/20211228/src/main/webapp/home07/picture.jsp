<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1 width="600px">
	<tr>
		<td colspan=2>
			<jsp:include page="menu/top.jsp"/>			
		</td>
	</tr>
	<tr>
		<td width="25%">
			<jsp:include page="menu/left.jsp"/>
		</td>
		<td width="75%">
			<img alt="그림" src="../images/bg4.jpg">
		</td>
	</tr>
	<tr>
		<td colspan=2>
			<jsp:include page="menu/footer.jsp"/>
		</td>
	</tr>
</table>
</body>
</html>