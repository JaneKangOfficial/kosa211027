package controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardFrontController extends HttpServlet implements Servlet{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
		}catch (Exception e) {}
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		if(command.equals("/boardList.kosa")) {
			BoardListController action = new BoardListController();
			action.execute(request); // db로부터 가져온 값을 boardList.jsp에 전달
			// reqeust.setAttribute() // setAttribute에 저장하기 위한 request 값 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/board/boardList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardWrite.kosa")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/board/boardForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardRegist.kosa")) {
			BoardWriteController action = new BoardWriteController();
			action.execute(request);
			System.out.println(request.getParameter("boardWriter"));
			response.sendRedirect("boardList.kosa"); // "/" 붙이지 않게 주의! : 붙이면 contextPath가 없어진다.
		}else if(command.equals("/boardDetail.kosa")) {
			BoardDetailController action = new BoardDetailController();
			action.execute(request);
			BoardVisitCountController visit = new BoardVisitCountController();
			visit.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/board/boardInfo.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardDel.kosa")) {
			BoardDelController action = new BoardDelController();
			action.execute(request);
			response.sendRedirect("boardList.kosa");
		}else if(command.equals("/boardUpdate.kosa")) {
			BoardDetailController action = new BoardDetailController();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/board/boardModifyForm.jsp"); // 수정할 수 있는 페이지가 열려야 한다.
			dispatcher.forward(request, response);
		}else if(command.equals("/boardModify.kosa")) {
			BoardModifyController action = new BoardModifyController();
			action.execute(request);
			response.sendRedirect("boardDetail.kosa?num=" + request.getParameter("boardNum"));
		}
	}		
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
}
