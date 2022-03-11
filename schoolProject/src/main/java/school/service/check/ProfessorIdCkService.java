package school.service.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.CheckDTO;
import school.mapper.CkMapper;

@Service
public class ProfessorIdCkService {
	@Autowired
	CkMapper ckMapper;
	
	public Integer execute(String id) {
		CheckDTO dto = ckMapper.idCk(id);
		if(dto == null) {
			return 0;
		}else {
			return 1;
		}
	}

}
