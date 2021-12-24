<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest, com.oreilly.servlet.multipart.DefaultFileRenamePolicy"  %>   
<%@ page import="java.io.File" %>
<%
	// getRealPath(폴더명) : 절대경로를 가지고 옴. 실제 서비스에 사용되는 데이터, 실제 데이터가 저장되는 경로
	String savePath = application.getRealPath("upload"); // 저장경로
	// out.print(savePath);
	int sizeLimit = 1024 * 1024 * 5; // 5MB / 1024 : kb / 1024 * 1024 : mb
	
	// 전송 받은 파일을 저장
	// DefaultFileRenamePolicy : 같은 파일명을 변경하는 정책
	// request를 multi로 받았기 때문에 값을 받아올 때도 request가 아닌 multi로 받아야 한다.
	MultipartRequest multi = new MultipartRequest(
			request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
	
	File file = multi.getFile("upFile");	
	String fileName = file.getName();
	long fileSize = file.length(); // 파일크기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload.jsp</title>
</head>
<body>
<!-- request를 multi로 받았기 때문에 값을 받아올 때도 request가 아닌 multi로 받아야 한다.  -->
이름 : <%= multi.getParameter("userName")%><br />
파일명 : <%= fileName %><br />
사이즈 : <%= fileSize %><br />
원본 파일명 : <%= multi.getOriginalFileName("upFile") %><br />
</body>
</html>