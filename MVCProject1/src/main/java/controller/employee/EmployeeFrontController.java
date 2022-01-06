package controller.employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeFrontController extends HttpServlet implements Servlet{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
		}catch (Exception e) {}
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		if(command.equals("/employeeList.emp")) {
			EmployeeListController action = new EmployeeListController();
			action.execute(request); // setAttribute : DB값을 가져와서 페이지에 넘겨준다. / request : 한 페이지에서만 사용 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/empList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/employeeRegist.emp")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/empForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/employeeWrite.emp")) {
			EmployeeWriteController action = new EmployeeWriteController();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/empSuccess.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/employeeInfo.emp")) {
			EmployeeInfoController action = new EmployeeInfoController();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/empDetail.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/employeeDelete.emp")) {
			EmployeeDeleteController action = new EmployeeDeleteController();
			action.execute(request);
			response.sendRedirect("employeeList.emp");
		}else if(command.equals("/employeeModify.emp")) {
			EmployeeInfoController action = new EmployeeInfoController();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/empUpdate.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/employeeUpdate.emp")) {
			EmployeeModifyController action = new EmployeeModifyController();
			action.execute(request);
			response.sendRedirect("employeeInfo.emp?num=" + request.getParameter("empNum"));
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
