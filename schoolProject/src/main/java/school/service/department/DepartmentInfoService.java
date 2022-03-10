package school.service.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.DepartmentDTO;
import school.mapper.DepartmentMapper;

@Service
public class DepartmentInfoService {
	@Autowired
	DepartmentMapper departmentMapper;

	public void execute(String departmentNum, Model model) {
		
		DepartmentDTO dto = departmentMapper.selectOne(departmentNum);
		
		model.addAttribute("departmentCommand", dto);
	}
}
