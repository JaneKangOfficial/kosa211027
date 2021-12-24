<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest, com.oreilly.servlet.multipart.DefaultFileRenamePolicy"  %>   
<%@ page import="java.io.*" %>
<%
	// upload 라는 폴더의 절대경로를 가져온다.
	String savePath = application.getRealPath("upload");
	int sizeLimit = 1024 * 1024 * 5; // 5MB
	// MultipartRequest : 파일 업로드
	// cos.jar library 사용
	MultipartRequest multi = new MultipartRequest(
			request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
	File file = multi.getFile("imgFile");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>imageUp.jsp</title>
</head>
<body>
<!-- client ip 주소를 가져올 때는 multi가 아닌 request를 사용해야 한다. -->
<!-- 내가 나한테 보냈을 때의 ip 주소 :  0:0:0:0:0:0:0:1 -->
전송한 사람의 ip 주소 : <%= request.getRemoteAddr() %><br />
제목 : <%= multi.getParameter("subject") %><br />
파일명 : <%= multi.getOriginalFileName("imgFile") %><br />
파일크기 : <%= file.length() %> <br />
이미지 <br />
<img src="upload/<%= multi.getFilesystemName("imgFile") %>" />
</body>
</html>