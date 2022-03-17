package school.service.professor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.AuthInfo;
import school.mapper.ProfessorMapper;
import school.mapper.ProfessorSubjectMapper;

@Service
public class SubDeletesService {

	@Autowired
	ProfessorSubjectMapper professorSubjectMapper;
	@Autowired
	ProfessorMapper professorMapper;
	
	public void execute(String[] deletes, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String proNum = (professorMapper.selectOneById(authInfo.getUserId())).getProfessorNum();
		
		List<String[]> condition = new ArrayList<String[]>();
	    
		String[] n = null;
	    for(String num : deletes) {
	       n = num.split("`");
	       condition.add(n);
	    }
	    
	    if(n[0].equals(proNum)) {
	    	professorSubjectMapper.subDeletes(condition);
	    }
	      
	}
}
