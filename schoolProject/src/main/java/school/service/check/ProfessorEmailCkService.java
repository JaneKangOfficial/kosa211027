package school.service.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.CheckDTO;
import school.mapper.CkMapper;
import school.mapper.ProfessorMapper;

@Service
public class ProfessorEmailCkService {
	@Autowired
	CkMapper ckMapper;
	@Autowired
	ProfessorMapper professorMapper;
	
	public Integer execute(String email) {
	
		CheckDTO dto = ckMapper.emailCk(email);
		if(dto == null) {
			return 0; 
		}else{
			return 1;
		}
	}
}
