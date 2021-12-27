<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response</title>
<script>
	function send(){
		location.href="http://www.daum.net"; /* 자바스크립트에서 사용하는 흐름제어 */
	}
</script>
</head>
<body>
	<!-- response : 흐름 제어(이동) -->
	<a href="http://www.naver.com">네이버</a><br /> <!-- html에서 사용하는 흐름제어 -->
	<button type="button" onclick="send()">다음</button><br />
	<%
		/* 바로 페이지 이동 */
		response.sendRedirect("http://www.nate.com"); /* jsp에서 사용하는 흐름제어 */
	%>

</body>
</html>