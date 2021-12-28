<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
여기는 index3.jsp 입니다. 이 내용은 안나온다. <br />
<jsp:forward page="../home10/index2.jsp?num=3" /><!-- 자기 주소가 남는다. 연결된 주소의 값만 가져온다. -->
</body>
</html>