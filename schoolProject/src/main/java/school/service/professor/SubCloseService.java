package school.service.professor;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.AuthInfo;
import school.domain.ProfessorSubjectDTO;
import school.mapper.ProfessorMapper;
import school.mapper.ProfessorSubjectMapper;

@Service
public class SubCloseService {

	@Autowired
	ProfessorSubjectMapper professorSubjectMapper;
	@Autowired
	ProfessorMapper professorMapper;
	
	public void execute(String professorNum, String subjectNum, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String proNum = (professorMapper.selectOneById(authInfo.getUserId())).getProfessorNum();
		
		ProfessorSubjectDTO dto = new ProfessorSubjectDTO();
		dto.setProfessorNum(professorNum);
		dto.setSubjectNum(subjectNum);
		
		String s = professorSubjectMapper.status(dto);
		Integer i = professorSubjectMapper.studentCount();
		
		if(proNum.equals(professorNum)) {
			if(i == 0) {
				professorSubjectMapper.subClose(dto);
			}
		}
	}
}
