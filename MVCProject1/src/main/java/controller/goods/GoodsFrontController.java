package controller.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodsFrontController extends HttpServlet implements Servlet{
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		if(command.equals("/goodsList.gd")) { // 제품 리스트
			GoodsListController action = new GoodsListController();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/goods/goodsList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsEnter.gd")) { // 제품 등록
			GoodsAutoNumController action = new GoodsAutoNumController();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/goods/goodsForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsRegist.gd")) {
			GoodsProController action = new GoodsProController();
			try {
				action.execute(request);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("goodsList.gd");
		}else if(command.equals("/goodsInfo.gd")) {
			GoodsInfoController action = new GoodsInfoController();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/goods/goodsInfo.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsDelete.gd")) {
			GoodsDeleteController action = new GoodsDeleteController();
			action.execute(request);
			response.sendRedirect("goodsList.gd");
		}else if(command.equals("/goodsModify.gd")) {
			GoodsModifyController action = new GoodsModifyController();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/goods/goodsModify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsUpdate.gd")) {
			GoodsUpdateController action = new GoodsUpdateController();
			action.execute(request, response);
			//response.sendRedirect("goodsInfo.gd?num=" + request.getParameter("goodsNum"));
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
