package school.service.professor;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.AuthInfo;
import school.domain.ProfessorSubjectDTO;
import school.mapper.ProfessorMapper;
import school.mapper.ProfessorSubjectMapper;

@Service
public class SubInfoService {
	@Autowired
	ProfessorSubjectMapper professorSubjectMapper;
	@Autowired
	ProfessorMapper professorMapper;
	
	public void execute(String professorNum, String subjectNum, Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String proNum = (professorMapper.selectOneById(authInfo.getUserId())).getProfessorNum();

		ProfessorSubjectDTO dto = new ProfessorSubjectDTO();
		dto.setProfessorNum(professorNum);
		dto.setSubjectNum(subjectNum);
		
		ProfessorSubjectDTO dto1 = professorSubjectMapper.selectOne(dto);
		model.addAttribute("one", dto1);
		model.addAttribute("proNum", proNum);
	}
}
