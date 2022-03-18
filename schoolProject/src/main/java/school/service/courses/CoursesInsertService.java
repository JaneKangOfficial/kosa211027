package school.service.courses;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.command.CoursesSubjectCommand;
import school.domain.AuthInfo;
import school.domain.CoursesSubjectDTO;
import school.mapper.StudentMapper;

@Service
public class CoursesInsertService {
	@Autowired
	StudentMapper studentMapper;

	public void execute(CoursesSubjectCommand coursesSubjectCommand, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String studentNum = (studentMapper.selectOneById(authInfo.getUserId())).getStudentNum();
		
		CoursesSubjectDTO dto = new CoursesSubjectDTO();
		dto.setProfessorNum(coursesSubjectCommand.getProfessorNum());
		dto.setStudentNum(studentNum);
		dto.setSubjectNum(coursesSubjectCommand.getSubjectNum());
		
		studentMapper.coursesInsert(dto);
	}
}
