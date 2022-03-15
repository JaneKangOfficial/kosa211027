package school.service.professor;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.AuthInfo;
import school.domain.ProfessorDTO;
import school.mapper.ProfessorMapper;

@Service
public class ProfessorMyInfoService {
	
	@Autowired
	ProfessorMapper professorMapper;
	
	public void execute(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String userId = authInfo.getUserId();
		
		ProfessorDTO dto = professorMapper.selectOneById(userId);
		String departmentName = professorMapper.selectDepartmentNum(dto.getProfessorNum());
		
		ProfessorDTO dto2 = professorMapper.selectOne(dto.getProfessorNum());
		dto2.setDepartmentName(departmentName);
		
		model.addAttribute("professorCommand", dto2);
	}

}
