<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="model.DAO.*, model.DTO.*" %>
<%
	// 현재 웹브라우저에 있는 모든 쿠키를 request로 담아 서버에 보낸다.
	Cookie[] cookies = request.getCookies();

	if(cookies != null && cookies.length > 0) {
		for(Cookie c: cookies) {
			// 아이디 저장 체크박스 쿠키
			if(c.getName().equals("storeId")) {
				request.setAttribute("isId", c.getValue()); /* jsp에 값을 출력하는 방법은 request뿐 */
			}
			// 로그인 유지 쿠키
			if(c.getName().equals("autoLogin")) {
				LoginDAO dao = new LoginDAO();
				AuthInfo authInfo = dao.loginCk(c.getValue(), "비밀번호");
				session.setAttribute("authInfo", authInfo);
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
메인 페이지입니다. <br />
<!-- 로그인 되지 않은 상태에서 보이는 페이지 -->
<c:if test="${empty authInfo}">
<form action="loginPro.login" method="post" name="frm" id="frm">
<table border=1>
	<tr>
		<td colspan=2>
			<input type="checkbox" value="autoLogin" name="autoLogin" />로그인 유지 |
			<input type="checkbox" value="store" name="storeId" <c:if test="${!empty isId}">checked</c:if> /> 아이디 저장
			
		</td>
	</tr>
	<tr>
		<td>
			<input type="text" name="id" placeholder="아이디 입력" value="${isId}" />
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
</form>
</c:if>

<!-- 로그인 된 상태에서 보이는 페이지 -->
<c:if test="${!empty authInfo}">
	${authInfo.userId}님 방문을 환영합니다.<br />
	<a href="boardList.kosa">게시글 목록</a> | 
	
	<c:if test="${authInfo.grade == 'emp'}">
		<a href="employeeList.emp">직원 리스트</a> | 
		<a href="memberList.mem">회원 리스트</a> | 
		<a href="goodsList.gd">상품 리스트</a> | 
	</c:if>
	
	<c:if test="${authInfo.grade == 'mem'}">
		<a href="myPage.html">마이페이지</a> |
	</c:if>
	 
	<a href="logout.login">로그아웃</a>
</c:if>
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
 
 <!-- 
 
 쿠키 : 서버에서 만들어서 브라우저에 저장하는 파일
 
 
 		쿠키생성요청  	  쿠키생성			쿠키파일	   쿠키결과
 웹브라우저 =====>	톰켓서버 =====> 웹브라우저 =====> 서버 =====> 웹브라우저
 
 
 핸드폰은 쿠키 아님/ id,pw를 파일 저장
 
  -->