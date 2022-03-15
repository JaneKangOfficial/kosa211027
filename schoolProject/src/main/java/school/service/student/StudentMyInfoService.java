package school.service.student;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.AuthInfo;
import school.domain.StudentDTO;
import school.mapper.StudentMapper;

@Service
public class StudentMyInfoService {
	@Autowired
	StudentMapper studentMapper;

	public void execute(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String userId = authInfo.getUserId();
		
		StudentDTO dto = studentMapper.selectOneById(userId);		
		String departmentName = studentMapper.selectDepartmentNum(dto.getStudentNum());
		
		StudentDTO dto2 = studentMapper.selectOne(dto.getStudentNum());
		dto2.setDepartmentName(departmentName);
		
		model.addAttribute("studentCommand", dto2);
		
	}
}
