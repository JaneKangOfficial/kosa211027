<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!-- 통화 단위, 날짜 변환 --> 
<%
	request.setAttribute("date", new Date());
	request.setAttribute("money", 1234567891112L);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fmt : format</title>
</head>
<body>

<fmt:formatNumber value="${money }" pattern="###,###,###" /><br />
<fmt:formatNumber value="${money }" type="currency" /><br />
<fmt:formatNumber value="0.15" type="percent" /><br />
<hr />
<fmt:formatDate value="${date }" type="date" /><br /> <!-- 2021. 12. 29. -->
<fmt:formatDate value="${date }" type="time" /><br /> <!-- 오전 11:16:29 -->
<fmt:formatDate value="${date }" type="both" /><br /> <!-- 2021. 12. 29. 오전 11:17:15 -->
<fmt:formatDate value="${date }" type="both" timeStyle="short" /><br /> <!-- 2021. 12. 29. 오전 11:18 -->
<fmt:formatDate value="${date }" type="both" timeStyle="long" /><br /> <!-- 2021. 12. 29. 오전 11시 18분 5초 KST -->
<fmt:formatDate value="${date }" type="both" dateStyle="short" /><br /> <!-- 21. 12. 29. 오전 11:19:07 -->
<fmt:formatDate value="${date }" type="both" dateStyle="long" /><br /> <!-- 2021년 12월 29일 오전 11:19:07 -->
<fmt:formatDate value="${date }" type="both" timeStyle="short" dateStyle="long" /><br /> <!-- 2021년 12월 29일 오전 11:20 -->
<fmt:formatDate value="${date }" pattern="yyyy-MM-dd a hh:mm:ss z" /><br /> <!-- hh: 24h  --> <!-- 2021-12-29 오전 11:28:02 KST -->
<fmt:formatDate value="${date }" pattern="yyyy-MM-dd h:mm:ss" /><br /> <!-- h: 12h --> <!-- 2021-12-29 11:28:02 -->

</body>
</html>