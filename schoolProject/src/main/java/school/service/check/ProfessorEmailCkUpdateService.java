package school.service.check;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.AuthInfo;
import school.domain.CheckDTO;
import school.domain.ProfessorDTO;
import school.mapper.CkMapper;
import school.mapper.ProfessorMapper;

@Service
public class ProfessorEmailCkUpdateService {
	@Autowired
	CkMapper ckMapper;
	@Autowired
	ProfessorMapper professorMapper;
	
	public Integer execute(String email, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String userId = authInfo.getUserId();
		ProfessorDTO dto1 = professorMapper.selectOneById(userId);
		String professorEmail = dto1.getProfessorEmail();
	
		CheckDTO dto = ckMapper.emailCk(email);
		if(dto == null || professorEmail.equals(email)) {
//		if(dto == null) {
			return 0; 
		}else{
			return 1;
		}
		
	}

}
