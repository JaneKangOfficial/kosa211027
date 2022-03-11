package school.service.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.ProfessorDTO;
import school.mapper.ProfessorMapper;

@Service
public class ProfessorInfoService {
	@Autowired
	ProfessorMapper professorMapper;
	
	public void execute(String professorNum, Model model) {
		ProfessorDTO dto = professorMapper.selectOne(professorNum);
		model.addAttribute("professorCommand", dto);
		
	}
}
