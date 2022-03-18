package school.service.courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.mapper.CoursesSubjectMapper;

@Service
public class CoursesDelService {
	@Autowired
	CoursesSubjectMapper coursesSubjectMapper;

	public void execute(String[] delete) {
		List<String[]> condition = new ArrayList<String[]>();
	    
		String[] n = null;
	    for(String num : delete) {
	       n = num.split("`");
	       condition.add(n);
	    }
	    
	    coursesSubjectMapper.coursesDel(condition);
	}

	
}
