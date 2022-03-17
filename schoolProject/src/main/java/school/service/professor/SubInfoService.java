package school.service.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.ProfessorSubjectDTO;
import school.mapper.ProfessorSubjectMapper;

@Service
public class SubInfoService {
	@Autowired
	ProfessorSubjectMapper professorSubjectMapper;
	
	public void execute(String professorNum, String subjectNum, Model model) {

		ProfessorSubjectDTO dto = new ProfessorSubjectDTO();
		dto.setProfessorNum(professorNum);
		dto.setSubjectNum(subjectNum);
		
		ProfessorSubjectDTO dto1 = professorSubjectMapper.selectOne(dto);
		model.addAttribute("one", dto1);
	}
}
