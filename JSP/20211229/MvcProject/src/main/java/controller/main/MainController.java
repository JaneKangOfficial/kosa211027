package controller.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet implements Servlet{
	// web.xml 에 servlet 정보 작성해야 한다.
	// web.xml 생성 : 프로젝트 우클릭 -> Java EE Tools -> Generate Deployment Descriptor Stub
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String requestURI = request.getRequestURI();
		// String requestURI = URLDecoder.decode(request.getRequestURI(), "UTF-8"); // 한글 주소
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		if(command.equals("/main.nhn")) {// .jsp 이면 파일을 열겠다가 되어서 안된다. .jsp가 아닌 주소를 적어야 한다.
			// RequestDispatcher : 웹브라우저에 jsp 파일 전송
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp"); // .jsp가 아닌 servlet으로 봐야 이해가 쉽다.
			dispatcher.forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
