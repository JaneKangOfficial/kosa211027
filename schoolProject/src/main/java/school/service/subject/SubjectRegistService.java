package school.service.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.command.SubjectCommand;
import school.domain.SubjectDTO;
import school.mapper.SubjectMapper;

@Service
public class SubjectRegistService {
	@Autowired
	SubjectMapper subjectMapper;
	
	public void execute(SubjectCommand subjectCommand) {
		
		SubjectDTO dto = new SubjectDTO();
		
		dto.setSubjectNum(subjectCommand.getSubjectNum());
		dto.setSubjectName(subjectCommand.getSubjectName());
		dto.setSubjectTitle(subjectCommand.getSubjectTitle());
		dto.setSubjectContent(subjectCommand.getSubjectContent());
		
		subjectMapper.setSubjectInsert(dto);
		
	}

}
