package school.service.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.ProfessorSubjectDTO;
import school.mapper.ProfessorSubjectMapper;

@Service
public class SubDelService2 {
	@Autowired
	ProfessorSubjectMapper professorSubjectMapper;

	public void execute(String professorNum, String subjectNum) {
		ProfessorSubjectDTO dto = new ProfessorSubjectDTO();
		dto.setProfessorNum(professorNum);
		dto.setSubjectNum(subjectNum);
		
		professorSubjectMapper.subDel2(dto);
	}
	
	

}
