<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
안녕하세요

<%--

MVC

Model : 데이터 : dto/vo, dao(database access object)
View : 화면처리 : jsp, html
Controller : 모든 연산 : Servlet


		http://www.naver.com/index.html
클라이언트(웹브라우저) ==========================> FrontController
클라이언트(웹브라우저) <========================== FrontController
								index.html
								
		http://search.naver.com/search.naver?query=jsp		jsp				  jsp				jsp
클라이언트(웹브라우저) ==========================> FrontController =====> Controller =====> Model(dao) =====> DB
클라이언트(웹브라우저) <========================== FrontController <===== Controller <===== Model(dao) <===== DB
				search.naver   (DTO)										   dto				DTO/VO 에 저장
				
1. 웹브라우저가 요청한 주소와 값(search.naver?query=jsp)을 FrontController가 받고 
2. FrontController는 전달 받은 쿼리스트링을 request를 통해서 받아 변수에 저장하고 Controller에 전달
3. Controller는 FrontController로 부터 받은 값을 DAO에 전달
4. DAO는 Controller에서 넘어온 값을 쿼리문을 통해 데이터베이스(오라클)에 전달
5. 오라클은 쿼리문 결과값을 DAO에 전달하고
6. DAO는 데이터베이스로부터 받은 값을 DTO에 저장해서 Controller에게 주면
7. Controller는 전달 받은 DTO를 request에 저장하면
8. FrontController는 요청 페이지를 웹브라우저에게 전송한다.				


<a href="boardlist.nhn">링크</a> : get 방식

<form action"boardlist.nhn" method="post"> : post 방식
</form>
--%>
</body>
</html>