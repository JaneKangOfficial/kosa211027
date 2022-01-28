package kosaShoppingMall.service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.mapper.EmployeeMapper;

@Component
@Service
public class EmployeeDeleteService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String execute(EmployeeCommand employeeCommand, Model model) {
		String path = "thymeleaf/employee/empDelPass";
		
		String empPw = employeeCommand.getEmpPw();
		EmployeeDTO dto = employeeMapper.selectOne(employeeCommand.getEmpId());
		String seEmpPw = dto.getEmpPw();
		
		if(passwordEncoder.matches(empPw, seEmpPw)) {
			Integer i = employeeMapper.empDel(employeeCommand.getEmpId());
			model.addAttribute("num",i);
			path = "thymeleaf/employee/empDel";
		}else {
			model.addAttribute("employeeCommand", dto);
			model.addAttribute("err_pw","비밀번호가 일치하지 않습니다.");
		}
		return path;
	}
}
