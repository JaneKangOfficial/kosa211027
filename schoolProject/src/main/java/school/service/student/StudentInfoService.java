package school.service.student;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.command.StudentCommand;
import school.domain.AuthInfo;
import school.domain.StudentDTO;
import school.mapper.StudentMapper;

@Service
public class StudentInfoService {

	@Autowired
	StudentMapper studentMapper;
	
	public void execute(String studentNum, Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String id = authInfo.getUserId();
		StudentDTO dto1 = studentMapper.selectOneById(id);
		String num = dto1.getStudentNum();
		if(studentNum.equals(num)) {
			model.addAttribute("id", id);
		}
		
//		StudentDTO dto  = studentMapper.selectOne(studentNum);
//		model.addAttribute("studentCommand", dto);
		
		String departmentName = studentMapper.selectDepartmentNum(studentNum);
		
		StudentDTO dto2 = studentMapper.selectOne(studentNum);
		dto2.setDepartmentName(departmentName);
		
		model.addAttribute("studentCommand", dto2);
	}
}
