package school.service.student;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import school.command.StudentCommand;
import school.domain.AuthInfo;
import school.domain.StudentDTO;
import school.mapper.StudentMapper;

@Service
public class StudentUpdateService {

	@Autowired
	StudentMapper studentMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String execute(StudentCommand studentCommand, BindingResult result, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		
		StudentDTO dto2 = studentMapper.selectOneById(authInfo.getUserId());
		StudentDTO dto1 = studentMapper.selectOne(studentCommand.getStudentNum());
		
		if(dto2.getStudentId().equals(authInfo.getUserId()) ) {
			if(passwordEncoder.matches(studentCommand.getStudentPw(), dto1.getStudentPw())) {
				StudentDTO dto = new StudentDTO();
				dto.setStudentNum(studentCommand.getStudentNum());
				dto.setStudentId(studentCommand.getStudentId());
				dto.setStudentPw(studentCommand.getNewPw());
				dto.setStudentName(studentCommand.getStudentName());
				dto.setStudentPhone(studentCommand.getStudentPhone());
				dto.setStudentEmail(studentCommand.getStudentEmail());
				dto.setDepartmentNum(studentCommand.getDepartmentNum());
				
				studentMapper.studentUpdate(dto);
				return "redirect:studentInfo?num="+studentCommand.getStudentNum();
			}else {
				result.rejectValue("studentPw", "studentCommand.studentPw", "일치하지 않음");
				return "student/studentUpdate";
			}
		}else {
			result.rejectValue("studentId", "studentCommand.studentId", "일치하지 않음");
			return "student/studentUpdate";
		}
		
	}
}
