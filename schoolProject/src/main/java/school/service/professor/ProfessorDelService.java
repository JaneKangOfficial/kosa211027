package school.service.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.mapper.ProfessorMapper;

@Service
public class ProfessorDelService {
	@Autowired
	ProfessorMapper professorMapper;
	
	public void execute(String professorNum) {
		professorMapper.proDel(professorNum);
	}
}
