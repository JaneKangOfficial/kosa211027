package controller.board;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 오라클DB(Express), sqlDevleoper 설치하기
// DB 접속을 위해 필요함 => 오라클 설치 경로 = C:\\app\\user\product\21c\dbhomeXE\jdbc\lib => ojdbc8.jar ==> lib에 복사 

public class BoardFrontController extends HttpServlet implements Servlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = URLDecoder.decode(request.getRequestURI(),"UTF-8");	// 한글 주소 
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/게시글목록.db")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/board/boardList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/게시글쓰기.db")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/board/boardWrite.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/boardWriteOk.db")) {
			BoardWriteController action = new BoardWriteController(); 
			action.execute(request);
			response.sendRedirect(URLEncoder.encode("게시글목록.db", "UTF-8"));; // sendRedirect : 이미 있는 주소 사용
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = URLDecoder.decode(request.getRequestURI(),"UTF-8");	// 한글 주소 
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		if (command.equals("/boardWriteOk.db")) {
			BoardWriteController action = new BoardWriteController(); // request 값을 DB에 저장하기 위해서
			action.execute(request); // jsp name 값을 doPost request가 받음 -> doPost request가 받은 값을 controller에만 전달
			response.sendRedirect(URLEncoder.encode("게시글목록.db", "UTF-8"));; // sendRedirect : 이미 있는 주소 사용
		}
	}

}
