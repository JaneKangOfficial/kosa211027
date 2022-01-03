package controller.employee;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.EmployeeDAO;
import model.DTO.EmployeeDTO;

public class EmployeeListController {
	public void execute(HttpServletRequest request) {
		EmployeeDAO dao = new EmployeeDAO();
		// dao.selectAll()의 return 값이 List<EmployeeDTO>이기 때문에 받는 값도 List<EmployeeDTO>로 받는다.
		List<EmployeeDTO> list = dao.selectAll(); 
		request.setAttribute("list", list);
		int i = test(); // i = tt;
		// System.out.println(i); // 10
	}
	
	public int test() {
		int tt = 10;
		return tt;
	}
}
