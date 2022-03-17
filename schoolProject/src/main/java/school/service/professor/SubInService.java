package school.service.professor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.mapper.ProfessorSubjectMapper;

@Service
public class SubInService {
	@Autowired
	ProfessorSubjectMapper professorSubjectMapper;
	
	public void execute(String[] subIn) {
		
		List<String[]> condition = new ArrayList<String[]>();
		
		for(String num: subIn) {
			String[] n = num.split(" ");
			condition.add(n);
		}
		professorSubjectMapper.subIn(condition);
	}
}
