<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<img src="http://localhost:8080/20211229/images/pet.png" alt="그림" />
<br />
<img src="../images/pet.png" alt="그림" />
<br />

<!-- / : 최상위 경로(localhost:8080) -->
<!-- contextPath : 프로젝트명(20211229) -->
<img src="/20211229/images/pet.png" alt="그림" />
<br />
<!-- contextPath 없이 사용 가능 -->
<img src="<c:url value='/images/pet.png' />" alt="그림" />

</body>
</html>