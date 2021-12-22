package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * url => https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=jsp
 * queryString(요청하기 위한 문자) => where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=jsp
 * HttpServletRequest => queryString을 받아온다.
 * request.getParameter("변수명") => 변수명에 해당하는 값을 가져온다.
 */

// Servlet
public class MemberServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("forward");
		response.setCharacterEncoding("UTF-8"); // 화면에 이런 식으로 보내겠습니다. 
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();	// 화면에 출력
		if(str.equals("main")) {
			out.print("<!DOCTYPE html>");
			out.print("<html><head>");
			out.print("<meta charset='UTF-8'>");
			out.print("<title>servlet</title>");
			out.print("</head><body>");
			out.print("<a href='member?forward=next'>다음 페이지</a>");
			out.print("</body></html>");
		}else if(str.equals("next")) {
			out.print("<!DOCTYPE html>");
			out.print("<html><head>");
			out.print("<meta charset='UTF-8'>");
			out.print("<title>servlet</title>");
			out.print("</head><body>");
			out.print("다음 페이지입니다.");
			out.print("</body></html>");
		}
				
	}
}
/*	
 	브라우저(search.naver?forward=main을 웹서버인 tomcat에게 요청) ===> tomcat(서버) ===> 
 	dispatcher 객체(web.xml을 읽어서 실행시킨다. dispatcher 객체가 HttpServletRequest(queryString 받아옴), HttpServletResponse(환경값 받아옴)에 전달한다.)  
 	===> servlet.doGet(request,response)  
  
  
  		     Tomcat의 역할
  		     
  		     servlet
  	JSP	===>	java	===>	class	===> html 
 						compile
 						
 			MVC
 	view : jsp (html 코드 작성)
 	business logic : 컨트롤러 : servlet (java 코드 작성)
 	 
 */
