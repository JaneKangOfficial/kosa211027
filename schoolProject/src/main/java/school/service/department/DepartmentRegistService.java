package school.service.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.command.DepartmentCommand;
import school.domain.DepartmentDTO;
import school.mapper.DepartmentMapper;

@Service
public class DepartmentRegistService {
	@Autowired
	DepartmentMapper departmentMapper;
	
	public void execute(DepartmentCommand departmentCommand) {
		
		DepartmentDTO dto = new DepartmentDTO();
		
		dto.setDepartmentNum(departmentCommand.getDepartmentNum());
		dto.setDepartmentName(departmentCommand.getDepartmentName());
		dto.setDepartmentPhone(departmentCommand.getDepartmentPhone());
		dto.setDepartmentAddr(departmentCommand.getDepartmentAddr());
		
		departmentMapper.departmentInsert(dto);
		
		
	}

}
