package school.service.professor;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.AuthInfo;
import school.domain.ProfessorSubjectDTO;
import school.mapper.ProfessorMapper;
import school.mapper.ProfessorSubjectMapper;

@Service
public class SubInsertService {

	@Autowired
	ProfessorMapper professorMapper;
	@Autowired
	ProfessorSubjectMapper professorSubjectMapper;
	
	public Integer execute(String[] subjectNum, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String proNum = (professorMapper.selectOneById(authInfo.getUserId())).getProfessorNum();
		System.out.println("2222222proNum " + proNum);
		ProfessorSubjectDTO dto = new ProfessorSubjectDTO();
		dto.setProfessorNum(proNum);
		dto.setSubjectNums(subjectNum);
		System.out.println("333333333dtoooooooo "+dto);
		
		Integer i = professorSubjectMapper.subInsert(dto);
		System.out.println("4444444444iiiiiiii "+i);
		return i;
	}
}
