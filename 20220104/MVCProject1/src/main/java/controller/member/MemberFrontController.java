package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet implements Servlet{

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/memberList.mem")) {
			MemberListController action = new MemberListController();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/memberList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberRegist.mem")) {
			MemberNumberController action = new MemberNumberController();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/memberForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberWrite.mem")) {
			MemberWriteController action = new MemberWriteController();
			action.execute(request);
			response.sendRedirect("memberList.mem");
		}else if(command.equals("/memberDetail.mem")) {
			MemberDetailController action = new MemberDetailController();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/memberInfo.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberDelete.mem")) {
			MemberDeleteController action = new MemberDeleteController();
			action.execute(request);
			response.sendRedirect("memberList.mem");
		}else if(command.equals("/memberModify.mem")) {
			MemberDetailController action = new MemberDetailController();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/memberUpdate.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberUpdate.mem")) {
			MemberModifyController action = new MemberModifyController();
			action.execute(request);
			response.sendRedirect("memberDetail.mem?num=" + request.getParameter("memNum"));
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
