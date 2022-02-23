package kosaShoppingMall.service.employees;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.domain.EducationDTO;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.mapper.EmployeeMapper;


@Service
public class EmployeesWriteService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	EmployeeMapper employeeMapper;
	
	public void execute(EmployeeCommand employeeCommand) {
		// 암호화
		String empPw =  passwordEncoder.encode(employeeCommand.getEmpPw());
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpAddr(employeeCommand.getEmpAddr());
		dto.setEmpId(employeeCommand.getEmpId());
		dto.setEmpName(employeeCommand.getEmpName());
		dto.setEmpPhone(employeeCommand.getEmpPhone());
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		dto.setEmpPw(empPw);
		
		employeeMapper.empInsert(dto);
		
		
		List<EducationDTO> lists = new ArrayList<EducationDTO>();
		int i = 0;
		for(String school : employeeCommand.getSchool()) {
			EducationDTO educationDTO = new EducationDTO();
			educationDTO.setEmpId(employeeCommand.getEmpId());
			educationDTO.setSchool(school);
			educationDTO.setSchoolYear(employeeCommand.getSchoolYear()[i]);
			lists.add(educationDTO);
			i++;
		}
		employeeMapper.educationInsert(lists);
	}
}
