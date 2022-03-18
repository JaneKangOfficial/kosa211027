package school.service.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.command.CoursesSubjectCommand;
import school.domain.CoursesSubjectDTO;
import school.mapper.CoursesSubjectMapper;

@Service
public class CoursesInfoService {

	@Autowired
	CoursesSubjectMapper coursesSubjectMapper;

	public void execute(CoursesSubjectCommand coursesSubjectCommand, Model model) {
		CoursesSubjectDTO dto = new CoursesSubjectDTO();
		dto.setProfessorNum(coursesSubjectCommand.getProfessorNum());
		dto.setSubjectNum(coursesSubjectCommand.getSubjectNum());
		System.out.println("dtooooooo1 "+dto);
		CoursesSubjectDTO dto2 = coursesSubjectMapper.selectOne(dto);
		System.out.println("dtooooooo2 "+dto2);
		model.addAttribute("dto", dto2);
	}
	
}
