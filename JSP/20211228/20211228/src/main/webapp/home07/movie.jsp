<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	include : 공통된 내용을 본문 페이지에 가져다가 사용하기 위해서,
				유지보수를 편하게 하기 위해서,
				include 페이지는 독자적으로 사용되는 페이지는 아니다.				
 -->
<table border=1 width="600px">
	<tr>
		<td colspan=2>
			<jsp:include page="menu/top.jsp"/><!-- 코드가 아닌 결과 값을 가져옴, 파일마다 서블릿이 각각 만들어진다. -->
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