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
public class EmployeePassUpdateService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String execute(EmployeeCommand employeeCommand, Model model) {
		//String path = "redirect:empPassModify?num="+ employeeCommand.getEmpId();
		String path = "thymeleaf/employee/empPass";
		
		EmployeeDTO dto = employeeMapper.selectOne(employeeCommand.getEmpId());
		String empPw = employeeCommand.getEmpPw();
		String seEmpPw = dto.getEmpPw();
		System.out.println("empPwwwwwww " + empPw);
		System.out.println("dto.empPwwwwwww " + seEmpPw);
		if(passwordEncoder.matches(empPw, seEmpPw)) {
			path = "thymeleaf/employee/empPassChange";
		}else {
			System.out.println("xxxxxxxxxxxxxx");
			model.addAttribute("err_pw", "비밀번호가 일치하지 않습니다.");
		}
		return path;
	}
	
}
