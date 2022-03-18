package school.service.courses;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.AuthInfo;
import school.domain.StudentDTO;
import school.domain.SubjectDTO;
import school.mapper.DepartmentMapper;
import school.mapper.StudentMapper;

@Service
public class ClassSubjectService {
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	StudentMapper studentMapper;
	
	public void execute(String departmentNum, HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
	    StudentDTO dto = studentMapper.selectOneById(authInfo.getUserId());
	    // 사용자의 아이디를 이용해서 사용자의 학과번호 갖고오기
	    String studentNum = dto.getStudentNum();
		// session으로 학과 번호 가져오기
		String departmentNum1 = studentNum.substring(2, studentNum.length()-5); // 학과
		
		
		List<SubjectDTO> list = departmentMapper.selectSubject(departmentNum);
		model.addAttribute("list", list);
		
	}

}
