package kosaShoppingMall.service.employees;

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
public class EmployeeUpdateService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String execute(EmployeeCommand employeeCommand, BindingResult result) {
		String path = "thymeleaf/employee/empModify";
		
		EmployeeDTO dto = new EmployeeDTO();
		
		String empPw = employeeCommand.getEmpPw();
		EmployeeDTO dto2 = employeeMapper.selectOne(employeeCommand.getEmpId());
		String SeEmpPw = dto2.getEmpPw();
		System.out.println("empPwwwwwwwww " + empPw);
		System.out.println("dto.empPwwwwwwwww " + dto2.getEmpPw());
		
		if(passwordEncoder.matches(empPw, SeEmpPw)) {
			dto.setEmpAddr(employeeCommand.getEmpAddr());
			dto.setEmpId(employeeCommand.getEmpId());
			dto.setEmpName(employeeCommand.getEmpName());
			dto.setEmpPhone(employeeCommand.getEmpPhone());
			System.out.println("oooooooooooooo");
			employeeMapper.empUpdate(dto);
			path = "redirect:empInfo?num="+employeeCommand.getEmpId();
		}else {
			System.out.println("xxxxxxxxxxxxxx");
			// result.rejectValue(필드명, 오브젝트, 출력메세지)
			// result.addError(new FiledError("employeeCommand", "empPw", "비밀번호가 일치하지 않습니다."));
			result.rejectValue("empPw", "employeeCommand.empPw", "비밀번호가 일치하지 않습니다.");
		}
		return path;
	}
}
