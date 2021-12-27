<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
<%@ include file="" %>
<%@ taglib %> taglib를 사용하면 스크립트릿은 사용하지 않는다.
 --%>
<%! // 선언문 : 함수(메서드), 전역변수(멤버변수) %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	document.write("스크립트입니다.<br />");
</script>
</head>
<body>
10 + 5 = <%= 10 + 5 %><br /><!-- 표현식 -->
10 * 5 = <% out.print(10 * 5); %><br /><!-- 스크립트릿 -->
 <!-- html : input type이 file일 경우 form 안에 method="post" enctype="multipart/form-data" 무조건 있어야 한다. -->
<form action="NewFile1.jsp" method="post" enctype="multipart/form-data">
	성 : <input type="text" name="userName" /><br />
	이름 : <input type="text" name="userName" /><br />
	아이디 : <input type="text" name="userId" /><br />
	비밀번호 : <input type="password" name="userPw" /><br />
	이메일 수신 여부 : <input type="radio" name="ra" value="Y"/>예
					<input type="radio" name="ra" value="N"/>아니오<br />
	취미 : <input type="checkbox" name="cp" value="야구"/>야구
			<input type="checkbox" name="cp" value="농구"/>농구
			<input type="checkbox" name="cp" value="배구"/>배구
			<input type="checkbox" name="cp" value="축구"/>축구<br />
	관심분야 : <select name="like" multiple size="3">
				<option>html</option>
				<option>css</option>
				<option>java</option>
				<option>데이터베이스</option>
				<option>자바스크립트</option>
			</select><br />							
	<!-- html : input type이 file일 경우 form 안에 method="post" enctype="multipart/form-data" 무조건 있어야 한다. -->
	<!-- file의 multiple : jsp에서는 사용 못함. spring에서 사용 가능 -->
	파일 : <input type="file" name="upFile" multiple /><br />
	<input type="submit" value="전송" />
</form>
</body>
</html>