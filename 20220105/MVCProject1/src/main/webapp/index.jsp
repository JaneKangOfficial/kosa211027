<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1>
	<tr>
		<td colspan=2>
			<input type="checkbox" value="autoLogin" name="autoLogin" />로그인 유지 |
			<input type="checkbox" value="storeId" name="storeId" /> 아이디 저장
		</td>
	</tr>
	<tr>
		<td>
			<input type="text" name="id" placeholder="아이디 입력"/>
		</td>
		<td rowspan=2>
			<input type="image" src="images/강아지2.jpg" width="50px" height="50px"/>
		</td>
	</tr>
	<tr>
		<td>
			<input type="password" name="pw" placeholder="비밀번호"/>
		</td>
	</tr>
	<tr>
		<td colspan=2>
			아이디/비밀번호 찾기 | 
			<a href="memberAgree.mem" >회원가입</a>
		</td>
	</tr>
</table>
<br />
<a href="boardList.kosa">게시글 목록 | </a>
<a href="employeeList.emp">직원 리스트 | </a>
<a href="memberList.mem">회원 리스트 | </a>
<a href="myPage.html">마이 페이지 </a>
</body>
</html>

<!-- 

1. 라이브러리가 있다면 제일 먼저 복사하는것이 좋다.
2. index.jsp 작성
3. web.xml 생성
4. FrontController - .jsp 주소 연결, 페이지 만들려면 RequestDispatcher
5. web.xml 작성
6. run as
7. 연결된 .jsp 작성
8. 하나씩 할 때마다 run as로 error 확인하기!
9. FrontController 추가 작성
10. DTO 생성
11 Controller 에 dto 작성
12. DAO 생성
12. Controller에 dao 작성 

 -->