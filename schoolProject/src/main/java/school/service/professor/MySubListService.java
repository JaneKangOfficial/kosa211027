package school.service.professor;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.AuthInfo;
import school.domain.ProfessorSubjectDTO;
import school.mapper.ProfessorMapper;
import school.mapper.ProfessorSubjectMapper;

@Service
public class MySubListService {

	@Autowired
	ProfessorSubjectMapper professorSubjectMapper;
	@Autowired
	ProfessorMapper professorMapper;
	
	public void execute(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		String proNum = (professorMapper.selectOneById(authInfo.getUserId())).getProfessorNum(); 
		List<ProfessorSubjectDTO> list = professorSubjectMapper.selectProId(proNum);
		
		model.addAttribute("list", list);
	}
}
