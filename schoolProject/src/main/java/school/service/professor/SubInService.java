package school.service.professor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.AuthInfo;
import school.domain.ProfessorSubjectDTO;
import school.mapper.ProfessorMapper;
import school.mapper.ProfessorSubjectMapper;

@Service
public class SubInService {
	@Autowired
	ProfessorSubjectMapper professorSubjectMapper;
	@Autowired
	ProfessorMapper professorMapper;
	
	public void execute(String[] subIn, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String proNum = (professorMapper.selectOneById(authInfo.getUserId())).getProfessorNum();
		
		List<String[]> condition = new ArrayList<String[]>();
		String[] arr;
		
		ProfessorSubjectDTO dto = new ProfessorSubjectDTO();
		for(String num: subIn) {
			String[] n = num.split(" ");
			
//			for(String nn : n) {
//				dto.setProfessorNum(proNum);
//				dto.setSubjectNum(nn);
//				System.out.println("dtoooooooooo111 "+dto);
//			}
			condition.add(n);
			arr = condition.toArray(new String[condition.size()]);
			System.out.println("conditionnnnnnnnnnn1 "+arr[0]);
			System.out.println("conditionnnnnnnnnnn2 "+arr[1]);
			System.out.println("conditionnnnnnnnnnn3 "+arr[2]);
			System.out.println("conditionnnnnnnnnnn11 "+n[0]);
			System.out.println("conditionnnnnnnnnnn22 "+n[1]);
			System.out.println("conditionnnnnnnnnnn33 "+n[2]);
		}
//		professorSubjectMapper.subIn(dto);
		professorSubjectMapper.subIn(condition);
	}
}
