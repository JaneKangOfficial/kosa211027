package controller.login;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFrontController extends HttpServlet implements Servlet{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		if(command.equals("/loginPro.login")) { // 로그인
			LoginProController action = new LoginProController(); // id, pw 비교 확인
			action.execute(request, response);
		}else if(command.equals("/logout.login")) {
			// 로그인 유지 쿠키 로그아웃
			Cookie cookie = new Cookie("autoLogin","");
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			
			// session 객체 생성
			// invalidate() : 로그아웃
			HttpSession session = request.getSession();
			session.invalidate(); // 로그아웃
			response.sendRedirect(contextPath + "/");
		}
	}	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
