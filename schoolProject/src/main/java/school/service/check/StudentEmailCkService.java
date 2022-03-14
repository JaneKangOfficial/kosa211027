package school.service.check;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.CheckDTO;
import school.mapper.CkMapper;
import school.mapper.StudentMapper;

@Service
public class StudentEmailCkService {

	@Autowired
	CkMapper ckMapper;
	@Autowired
	StudentMapper studentMapper;
	
	public Integer execute(String email) {
		
		CheckDTO dto = ckMapper.emailCk(email);
		if(dto == null) {
			return 0;
		}else {
			return 1;
		}
	}
}
