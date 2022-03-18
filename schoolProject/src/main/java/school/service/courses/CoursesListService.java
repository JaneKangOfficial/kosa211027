package school.service.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.CoursesSubjectDTO;
import school.mapper.CoursesSubjectMapper;

@Service
public class CoursesListService {
	@Autowired
	CoursesSubjectMapper coursesSubjectMapper;
	
	public void execute(Model model) {
		List<CoursesSubjectDTO> list = coursesSubjectMapper.selectAll();
		model.addAttribute("list", list);
	}
}
