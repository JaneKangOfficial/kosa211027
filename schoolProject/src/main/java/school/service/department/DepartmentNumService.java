package school.service.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.mapper.DepartmentMapper;

@Service
public class DepartmentNumService {
	@Autowired
	DepartmentMapper departmentMapper;

	public void execute(Model model) {
		
		String departmentNum = departmentMapper.autoNum();
		model.addAttribute("departmentNum", departmentNum);
	}
	
	
}
