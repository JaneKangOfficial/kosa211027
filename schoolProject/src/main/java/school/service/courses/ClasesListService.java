package school.service.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.DepartmentDTO;
import school.domain.StartEndPageDTO;
import school.mapper.DepartmentMapper;

@Service
public class ClasesListService {
	@Autowired
	DepartmentMapper departmentMapper;

	public void execute(Model model) {
		List<DepartmentDTO> list = departmentMapper.selectAll();
		model.addAttribute("lists", list);
	}
}
