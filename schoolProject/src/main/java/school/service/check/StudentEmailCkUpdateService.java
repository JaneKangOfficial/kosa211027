package school.service.check;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.AuthInfo;
import school.domain.CheckDTO;
import school.domain.StudentDTO;
import school.mapper.CkMapper;
import school.mapper.StudentMapper;

@Service
public class StudentEmailCkUpdateService {

	@Autowired
	CkMapper ckMapper;
	@Autowired
	StudentMapper studentMapper;
	
	public Integer execute(String email, HttpSession session) {
//		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
//		String userId = authInfo.getUserId();
//		StudentDTO dto1 = studentMapper.selectOneById(userId);
//		String studentEmail = dto1.getStudentEmail();
			
		
		CheckDTO dto = ckMapper.emailCk(email);
//		if(dto == null || studentEmail.equals(email)) {
		if(dto == null) {
			return 0;
		}else {
			return 1;
		}
	}
}
