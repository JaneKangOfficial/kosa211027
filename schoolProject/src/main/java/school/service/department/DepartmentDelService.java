package school.service.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.mapper.DepartmentMapper;

@Service
public class DepartmentDelService {
	@Autowired
	DepartmentMapper departmentMapper;

	public void execute(String departmentNum , Model model) {
		Integer i = departmentMapper.departmentDel(departmentNum);
		model.addAttribute("i" ,i.toString());
	}
}
