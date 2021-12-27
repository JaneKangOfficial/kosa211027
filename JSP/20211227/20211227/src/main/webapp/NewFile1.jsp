<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>    
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>    
<%@ page import="java.io.*" %>    
<%
	String savePath = request.getServletContext().getRealPath("/upload");
	int sizeLimit = 1024 * 1024 * 5;
	MultipartRequest multi = new MultipartRequest(
			request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy()
			);
	/*  request를 multi에 줬기 때문에 request를 사용하면 null error 발생 -> multi 사용
	String fullName[] = request.getParameterValues("userName");
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	String ra = request.getParameter("ra");
	String cp[] = request.getParameterValues("cp");
	String like[] = request.getParameterValues("like");
	 */
	 	 
	String fullName[] = multi.getParameterValues("userName");
	String userId = multi.getParameter("userId");
	String userPw = multi.getParameter("userPw");
	String ra = multi.getParameter("ra");
	String cp[] = multi.getParameterValues("cp");
	String like[] = multi.getParameterValues("like");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NewFile1.jsp</title>
</head>
<body>
<%
	/* out : html 코드로 변환하겠다. */
	out.print("성 : " + fullName[0] + "<br />");
	out.print("이름 : " + fullName[1] + "<br />");
	out.print("아이디 : " + userId + "<br />");
	out.print("비밀번호 : " + userPw + "<br />");
	out.print("이메일 수신 여부 : " + ra + "<br />");
	
	out.print("취미 : ");
	for(int i = 0; i < cp.length; i++) {
		out.print(cp[i] + ", ");		
	}
	out.print("<br />");
	
	out.print("관심분야 : ");
	for(int i = 0; i < like.length; i++) {
		out.print(like[i] + ", ");		
	}
	out.print("<br />");
%>
<br />
	파일명 : <%= multi.getOriginalFileName("upFile") %><br />
	파일 사이즈 : <% File file = multi.getFile("upFile");
				out.print(file.length()); %> Byte<br />
	<img src="upload/<%=multi.getFilesystemName("upFile")  %>" alt="그림" width="300px"/>	
	
</body>
</html>