package school.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import school.command.StudentCommand;
import school.domain.StudentDTO;
import school.mapper.StudentMapper;

@Service
public class StudentRegistService {

	@Autowired
	StudentMapper studentMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void execute(StudentCommand studentCommand) {
		String pw = passwordEncoder.encode(studentCommand.getStudentPw());
//		String num = studentMapper.autoNum(studentCommand.getDepartmentNum());
					
		StudentDTO dto = new StudentDTO();
//		dto.setStudentNum(num);
		dto.setStudentNum(studentCommand.getStudentNum());
		dto.setStudentId(studentCommand.getStudentId());
		dto.setStudentPw(pw);
		dto.setStudentName(studentCommand.getStudentName());
		dto.setStudentPhone(studentCommand.getStudentPhone());
		dto.setStudentEmail(studentCommand.getStudentEmail());
		dto.setDepartmentNum(studentCommand.getDepartmentNum());
		
		studentMapper.studentInsert(dto);
	}
}
