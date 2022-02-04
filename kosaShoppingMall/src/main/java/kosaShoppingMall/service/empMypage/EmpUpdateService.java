package kosaShoppingMall.service.empMypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.mapper.EmployeeMapper;

@Component
@Service
public class EmpUpdateService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String execute(EmployeeCommand employeeCommand, BindingResult result) {
		String empPw = passwordEncoder.encode(employeeCommand.getEmpPw());
		EmployeeDTO dto = employeeMapper.selectOne(employeeCommand.getEmpId());
		
		if(passwordEncoder.matches(employeeCommand.getEmpPw(), dto.getEmpPw())) {
			dto.setEmpId(employeeCommand.getEmpId());
			dto.setEmpPw(empPw);
			dto.setEmpName(employeeCommand.getEmpName());
			dto.setEmpPhone(employeeCommand.getEmpPhone());
			dto.setEmpAddr(employeeCommand.getEmpAddr());
			dto.setEmpEmail(employeeCommand.getEmpEmail());
			employeeMapper.empUpdate(dto);
			return "thymeleaf/employeesShip/empDetail";
		}else {
			result.rejectValue("empPw", "employeeCommand.empPw", "비밀번호 일치하지 않음");
			return "thymeleaf/employeesShip/empUpdate";
		}
	}
}
