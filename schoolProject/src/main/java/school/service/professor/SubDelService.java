package school.service.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.mapper.ProfessorSubjectMapper;

@Service
public class SubDelService {

	@Autowired
	ProfessorSubjectMapper professorSubjectMapper;
	
	public Integer execute(String subjectNum) {
		Integer i = professorSubjectMapper.subDel(subjectNum);
		return i;
	}
}
