<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="게시글목록.bd" >게시글 목록</a>


<%--

MVC

Model : 데이터 : dto/vo, dao(database access object)
View : 화면처리 : jsp, html
Controller : 모든 연산 : Servlet


					/boardlist.db
클라이언트(웹브라우저) ==========================> FrontController
클라이언트(웹브라우저) <========================== FrontController
					/boardList.db(boardList.jsp)
								
				/boardWriteOk.db(input)				input값을 받은 request			request값을 담은(DTO:Model)		  DTO:Model
클라이언트(웹브라우저) =======================> FrontController ==============> Controller ==============> Model(dao) =====> DB
클라이언트(웹브라우저) <======================= FrontController <============== Controller <============== Model(dao) <===== DB
					/boardList.db										  

				
1. 웹브라우저가 요청한 주소와 값(search.naver?query=jsp)을 FrontController가 받고 
2. FrontController는 전달 받은 쿼리스트링을 request를 통해서 받아 변수에 저장하고 Controller에 전달
3. Controller는 FrontController로 부터 받은 값을 DAO에 전달
4. DAO는 Controller에서 넘어온 값을 쿼리문을 통해 데이터베이스(오라클)에 전달
5. 오라클은 쿼리문 결과값을 DAO에 전달하고
6. DAO는 데이터베이스로부터 받은 값을 DTO에 저장해서 Controller에게 주면
7. Controller는 전달 받은 DTO를 request에 저장하면
8. FrontController는 요청 페이지를 웹브라우저에게 전송한다.				

--%>

</body>
</html>

<!-- 

순서 중요!!!
1. index.jsp 작성 - 이동주소(링크)가 있으니까 frontController 만들기 / web.xml 생성
2. frontController 작성 -> 이동주소 .jsp 
3. web.xml 작성
4. run as
5. 2번 주소가 있으니까 frontController 추가 작성
6. 2번 .jsp 내용 작성
7. run as
8. frontController -> post 작성 (db에 값 저장을 위한 controller 생성)

-----
9. controller 작성 : (값을 DB에 저장하기 위해 controller가 DTO에 값을 담아 DAO에 전달) 
9-1. controller에 request값 받아오기
10. DTO 작성
10-1. controller에 DTO 추가 작성, DTO에 값 저장
11. DAO 작성 (오라클 접속)
11-1. controller에 DAO 추가 작성, DTO값을 DAO에 전달
12. DAO 가 DTO 값을 DB에 저장

 -->