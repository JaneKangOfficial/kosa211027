package kosaShoppingMall.service.empMypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.EmpPwUpdateCommand;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.mapper.EmployeeMapper;

@Component
@Service
public class EmpPwUpdateService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String execute(EmpPwUpdateCommand empPwUpdateCommand, BindingResult result) {
		EmployeeDTO dto = employeeMapper.selectOne(empPwUpdateCommand.getEmpId());
		String empPw = passwordEncoder.encode(empPwUpdateCommand.getNewPw());
		
		System.out.println("aaaaa "+passwordEncoder.matches(empPwUpdateCommand.getEmpPw(), dto.getEmpPw()));
		
		if(passwordEncoder.matches(empPwUpdateCommand.getEmpPw(), dto.getEmpPw())) {
			dto.setEmpId(empPwUpdateCommand.getEmpId());
			dto.setEmpPw(empPw);
			employeeMapper.empPassUpdate(dto);
			// 성공하면 무조건 redirect!!! , next page는 무조건 redirect!!!
			return "redirect:empDetail";
			// thymeleaf로 보내면 값을 받아오지 않기 때문에 empId가 null이 된다.
			//return "thymeleaf/employeesShip/empDetail";
		}else {
			result.rejectValue("empPw", "employeeCommand.empPw", "일치하지 않음");
			return "thymeleaf/employeesShip/empPwUpdate";
		}
		
	}
}
