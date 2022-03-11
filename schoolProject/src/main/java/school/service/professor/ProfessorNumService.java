package school.service.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.mapper.ProfessorMapper;

@Service
public class ProfessorNumService {
	@Autowired
	ProfessorMapper professorMapper;

	public void execute(Model model) {
		String professorNum = professorMapper.autoNum();
		model.addAttribute("professorNum", professorNum);
		
	}
}
