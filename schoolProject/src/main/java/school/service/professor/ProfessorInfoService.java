package school.service.professor;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.AuthInfo;
import school.domain.ProfessorDTO;
import school.mapper.ProfessorMapper;

@Service
public class ProfessorInfoService {
	@Autowired
	ProfessorMapper professorMapper;
	
	public void execute(String professorNum, Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String id = authInfo.getUserId();
		ProfessorDTO dto1 = professorMapper.selectOneById(id);
		String num = dto1.getProfessorNum();
		
		if(num.equals(professorNum)) {
			model.addAttribute("id", id);
		}
		
		ProfessorDTO dto = professorMapper.selectOne(professorNum);
		model.addAttribute("professorCommand", dto);
		
	}
}
