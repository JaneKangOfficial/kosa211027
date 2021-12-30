<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="boardList.bd">게시글 목록</a>
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