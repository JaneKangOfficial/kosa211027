package school.service.professor;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.AuthInfo;
import school.domain.ProfessorSubjectDTO;
import school.mapper.ProfessorMapper;
import school.mapper.ProfessorSubjectMapper;

@Service
public class SubInsertOneService {

	@Autowired
	ProfessorMapper professorMapper;
	@Autowired
	ProfessorSubjectMapper professorSubjectMapper;
	
	public String execute(String subjectNum, HttpSession session) {
		String path = "subject/subList";
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String proNum = (professorMapper.selectOneById(authInfo.getUserId())).getProfessorNum();
		
		ProfessorSubjectDTO dto = new ProfessorSubjectDTO();
		dto.setProfessorNum(proNum);
		dto.setSubjectNum(subjectNum);
		
		if(professorSubjectMapper.selectOne(dto) == null) {
			professorSubjectMapper.subInsertOne(dto);
			path = "redirect:../mySubList";
		}
		return path;
	}
}
