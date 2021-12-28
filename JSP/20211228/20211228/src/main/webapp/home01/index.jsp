<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num = request.getParameter("num");
	
	String path = "../home01/movie.jsp";
	if (num == null) path = "../home01/movie.jsp";
	else {
		if (num.equals("1")) path = "../home01/movie.jsp";
		if (num.equals("2")) path = "../home01/music.jsp";
		if (num.equals("3")) path = "../home01/picture.jsp";
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1 width="600px">
	<thead>
		<tr>
			<td colspan=2>
				<%@ include file="../menu/top2.jsp" %>
			</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td width="25%">
				<%@ include file="../menu/left.jsp" %>
			</td>
			<td width="75%">
				<jsp:include page="<%= path %>" /> <%-- jsp action tag --%>
				<%-- 
				<%@ include file="<%= path %>" %> jsp tag안에 jsp tag 사용 못한다
				--%>
			</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td colspan=2>
				<%@ include file="../menu/footer.jsp" %>	
			</td>
		</tr>
	</tfoot>
</table>
</body>
</html>