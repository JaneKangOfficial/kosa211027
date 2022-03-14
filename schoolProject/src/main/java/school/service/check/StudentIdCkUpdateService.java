package school.service.check;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.AuthInfo;
import school.domain.CheckDTO;
import school.mapper.CkMapper;

@Service
public class StudentIdCkUpdateService {
	@Autowired
	CkMapper ckMapper;
	
	public Integer execute(String id, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String userId = authInfo.getUserId();
		
		CheckDTO dto = ckMapper.idCk(id);
		
		if(dto == null || userId.equals(id)) {
//		if(dto == null) {
			return 0;
		}else {
			return 1;
		}
		
	}

}
