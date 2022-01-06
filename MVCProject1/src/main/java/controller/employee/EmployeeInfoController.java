package controller.employee;

import javax.servlet.http.HttpServletRequest;

import model.DAO.EmployeeDAO;
import model.DTO.EmployeeDTO;

public class EmployeeInfoController {

	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");
		
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO dto = dao.selectOne(num);
		request.setAttribute("dto", dto); // setAttribute : jsp 페이지에서 값을 받겠다.
		// "dto" 이름으로 empDetail.jsp에서 값을 받아온다. ${dto.empNum}
		// "abc" 면 ${abc.empNum}
	}
}
