package kosaShoppingMall.service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.mapper.EmployeeMapper;

@Component
@Service
public class EmployeePassChangService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void execute(EmployeeCommand employeeCommand) {
		EmployeeDTO dto = employeeMapper.selectOne(employeeCommand.getEmpId());
		String empPw = passwordEncoder.encode(employeeCommand.getEmpPw());
		dto.setEmpPw(empPw);
		employeeMapper.empPassUpdate(dto);
	}
}
