package school.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import school.domain.CoursesSubjectDTO;

@Repository("school.mapper.CoursesSubjectMapper")
public interface CoursesSubjectMapper {
	
	public List<CoursesSubjectDTO> selectAll();
	public Integer coursesDel(List<String[]> condition);
	public CoursesSubjectDTO selectOne(CoursesSubjectDTO dto);

}
