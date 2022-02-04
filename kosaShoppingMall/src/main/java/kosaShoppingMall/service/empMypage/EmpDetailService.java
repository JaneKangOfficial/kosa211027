package kosaShoppingMall.service.empMypage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.command.EmpPwUpdateCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.mapper.EmployeeMapper;

@Component
@Service
public class EmpDetailService {
	@Autowired
	EmployeeMapper employeeMapper;
	
	public void execute(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empId = authInfo.getUserId();
		
		EmployeeDTO dto = employeeMapper.selectOne(empId);
		model.addAttribute("employeeCommand", dto);
	}
}
