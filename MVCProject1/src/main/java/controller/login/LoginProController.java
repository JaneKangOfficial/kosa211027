package controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.LoginDAO;
import model.DTO.AuthInfo;

public class LoginProController {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		LoginDAO dao = new LoginDAO();
		AuthInfo authInfo = dao.loginCk(id, pw); // 권한 확인
		
		HttpSession session = request.getSession(); // 세션 생성 (세션은 request로 만들어진다.)
		
		String storeId = request.getParameter("storeId"); // 아이디 저장
		String autoLogin = request.getParameter("autoLogin"); // 자동 로그인
		
		if(authInfo == null) { // 아이디가 존재하지 않음 (i == -1)
			request.setAttribute("idErr", "아이디가 존재하지 않습니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}else {
			if (pw.equals(authInfo.getUserPw())) { // 로그인 성공 (i == 1)
				session.setAttribute("authInfo", authInfo);
				
				// 로그인 후 쿠키 생성 
				if (storeId != null && storeId.equals("store")) {
					// 쿠키는 사용자 컴퓨터에 파일로 저장되므로 객체를 저장할 수 없고 문자열만 저장 가능하다.
					Cookie cookie = new Cookie("storeId", id);
					cookie.setPath("/");
					// 60초(1분) * 60 = 1시간 * 24 = 24시간 * 30 = 30일 
					cookie.setMaxAge(60*60*24*30); 
					response.addCookie(cookie);
				}else {
					Cookie cookie = new Cookie("storeId", id);
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
				
				if(autoLogin != null && autoLogin.equals("autoLogin")) {
					Cookie cookie = new Cookie("autoLogin", id);
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}
				
				String contextPath = request.getContextPath();
				response.sendRedirect(contextPath + "/"); 
				
			}else { // (i == 0)
				request.setAttribute("pwErr", "비밀번호가 틀렸습니다.");
				request.setAttribute("userId", id); 
				
				// 아이디 저장 체크박스 쿠키
				//(먼저 로그인을 한 후에 쿠키를 생성시키고 / 다시 로그인해서 비밀번호 틀렸을 때 체크박스 표시 유지)
				Cookie[] cookies = request.getCookies();

				if(cookies != null && cookies.length > 0) {
					for(Cookie c: cookies) {
						if(c.getName().equals("storeId")) {
							request.setAttribute("isId", c.getValue());  // jsp에 값을 출력하는 방법은 request뿐
						}
					}
				}
				
				// 쿠키 생성 후 이동
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		/*
		if (i == 1) {	// 로그인 성공
			// session 속성에 "id"라는 속성이 있다면 로그인된 상태로 정함
			session.setAttribute("id", id);
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/"); // index.jsp로 이동
		}else if (i == 0) { // 비밀번호 틀림
			request.setAttribute("pwErr", "비밀번호가 틀렸습니다.");
			request.setAttribute("userId", id); // id는 그대로 사용하도록 전달
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}else if (i == -1) { // 아이디가 존재하지 않음
			request.setAttribute("idErr", "아이디가 존재하지 않습니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
		*/
	}
}