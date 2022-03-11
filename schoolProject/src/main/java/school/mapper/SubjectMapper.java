package school.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import school.domain.StartEndPageDTO;
import school.domain.SubjectDTO;

@Repository("school.mapper.SubjectMapper")
public interface SubjectMapper {
	
	public String autoNum();
	public Integer setSubjectInsert(SubjectDTO dto);
	public List<SubjectDTO> selectAll(StartEndPageDTO dto);
	public SubjectDTO selectOne(String subjectNum);
	public Integer subUpdate(SubjectDTO dto);
	public Integer subDel(String subjectNum);
	public Integer count();
	

}
